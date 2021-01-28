package com.falardeau.algorithms;

import java.util.ArrayList;

public class TableAlgorithms {

    //Reverses an array of integer
    public void reverse(int[] tab){
        int n = tab.length;

        int i = 0;
        int j = n - 1;

        while(i < j){

            //Exchange i and j
            int temp = tab[i];
            tab[i] = tab[j];
            tab[j] = temp;

            i++;j--;
        }
    }

    //Gives an array of integer containing the local maximums
    public int[] maxLocaux(int[] tab){
        int n = tab.length;

        //An array of two of less elements does not contain local maximums
        if(n < 3){
            return tab;
        }

        //Retrieve the local maximums into an array list
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i < n - 1; i++){

            int prev = tab[i-1];
            int next = tab[i+1];
            int current = tab[i];

            if(current > prev && current > next){
                list.add(current);
            }
        }

        //Build an array of integer from the arraylist of integer
        n = list.size();
        int[] max = new int[n];
        for(int i = 0; i <  n; i++){
            max[i] = list.get(i);
        }

        return max;
    }

    //Removes all occurrences of x from T within a single iteration
    public int delete(int[] tab, int x){
        int n = tab.length;

        if(n == 0) return 0;

        //Holds the number of occurrences of non-x elements
        int count = 0;

        for(int i = 0; i < n; i++){

            //If the current element is non-x
            if(tab[i] != x){
                tab[count] = tab[i];
                count++;
            }
        }

        return count;
    }

    //Left rotate d times the array arr
    public void leftRotate(int arr[], int d, int n)
    {
        /* To handle if d >= n */
        d = d % n;

        int i, j, k, temp;

        int PGCD = plus_grand_commun_diviseur(d, n);

        for (i = 0; i < PGCD; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }

    }

    /*Function to get gcd of a and b*/
    //Greatest Common divisor
    private int plus_grand_commun_diviseur(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return plus_grand_commun_diviseur(b, a % b);
    }

}
