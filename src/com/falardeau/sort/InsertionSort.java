package com.falardeau.sort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * The insertion sort.
     *
     * Algorithm Analysis:
     * Considering the number of iterations.
     *
     * Best case (already sorted): 1 + 1 + 1 + ... + 1 = n
     * Worst case (descending order) 1 + 2 + 3 + 4 + 5 + 6 + .. + n = n(n-1)/2 ~ (n^2)/2
     * Average case 1/2 + 2/2 + 3/2 + ... + n/2 = n(n-1)/4 ~ (n^2)/4
     *
     * -> Time complexity: O(n^2)
     * */
    public static void sort(int[] A) {

        System.out.println(Arrays.toString(A));

        //For every element in A
        for(int i = 1; i < A.length; i++) {

            //Keep the current element in a variable
            int x = A[i];

            //Shift right the elements ranging from A[0] to A[i-1]
            //that are greater than x
            int j = i;
            while(j > 0 && A[j - 1] > x){
                A[j] = A[j - 1];
                j--;
            }

            //Put x back in the hole left by the shifting
            A[j] = x;
        }

        System.out.println(Arrays.toString(A));
    }

    public static void sortRecursive(int[] t) {
        System.out.println(Arrays.toString(t));

        sortRecursive(t, 0);

        System.out.println(Arrays.toString(t));
    }

    private static void sortRecursive(int[] t, int i) {

        if(i >= t.length) return;//Stop condition

        //Insert t[i] where it should be
        insert(t, i);

        //Repeat for the next i
        sortRecursive(t, i + 1);
    }

    private static void insert(int [] t, int i) {
        int curr = t[i];
        i = shiftRight(t, curr, i);
        t[i] = curr;
    }

    //Shift right the elements until an element is found to be smaller than curr
    //Return the position a the right of the smaller element
    private static int shiftRight(int[] t, int curr, int j) {

        if(j <= 0) return 0; //Stop condition, curr element shall be placed a the beginning

        if(t[j - 1] < curr) {
            //If the element right next to t[j] is smaller than curr
            //curr shall be placed at the index j
            return j;
        }
        //Shift the element
        t[j] = t[j - 1];

        return shiftRight(t, curr, j - 1);//Continue shifting right otherwise
    }



}

