package com.falardeau.tools;

import com.falardeau.structures.Bag;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TableAlgorithms {

    //Exercice 1.1
    public void reverse(int[] tab){

        int i = 0, j = tab.length - 1;

        while(i < j){

            int temp = tab[i];
            tab[i] = tab[j];
            tab[j] = temp;

            i++; j--;
        }
    }

    //Exercice 1.2
    public int[] maxLocaux(int[] tab){

        int len = tab.length;

        if(len < 3){
            return tab;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 1; i < len - 1; i++){
            int prev = tab[i-1];
            int next = tab[i+1];
            int current = tab[i];
            if(current > prev && current > next){
                list.add(current);
            }
        }

        int size = list.size();
        int[] newTab = new int[size];
        for(int i = 0; i <  size; i++){
            newTab[i] = list.get(i);
        }

        return newTab;
    }

    //Exercice 1.3

    public int delete(int[] tab, int x){

        int len = tab.length;

        //Special cases
        if(len == 0) return 0;

        //Counts the number of occurrences of x
        int count = 0;

        for(int i = 0; i < len; i++){

            while(tab[i] == x && //While the current element is x
                    i < len-count){//And we have not yet arrived at the last portion, where all the x's were shifted

                //Indicate we found another x
                count++;

                //Shift the current element to the end
                for(int j = i; j < len-1; j++){
                    tab[j] = tab[j+1];
                }
                tab[len-1] = x;
            }

            print(tab);
        }

        return count;
    }

    public void leftRotate(int arr[], int d, int n)
    {
        print(arr);
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
                //print(arr);
                j = k;
            }
            arr[j] = temp;

            print(arr);
        }

    }

    /*Function to get gcd of a and b*/
    //Greatest Common divisor
    int plus_grand_commun_diviseur(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return plus_grand_commun_diviseur(b, a % b);
    }

    public void shift(int[] tab, int d){

        System.out.print("Beginning: ");


        int len = tab.length;
        if(len == 0) return;

        int i = 0, j = 0;
        int navette = tab[0];
        for(int k = 1; k < len; k++){
            print(tab);
            if(i+d == len && len % 2 == 0 && d%2 == 0){
                j = 1;
                tab[i] = navette;
                navette = tab[i+1];
                //tab[i] = tab[i+1];
                i++;
                k++;
            }
            else{
                j = (i+d) % len;
            }


            tab[i] = tab[j];

            i = j;


        }

        tab[i] = navette;

        System.out.print("Result: ");
        print(tab);
    }

    public void print(int[] tab){
        for(int i = 0; i < tab.length; i++){
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }
}
