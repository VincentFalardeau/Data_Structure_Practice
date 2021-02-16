package com.falardeau.sort;

import java.util.Arrays;

public class SelectionSort {


    /**
     * The selection sort.
     *
     * Algorithm analysis:
     * Considering the number of comparisons
     * Best case (sorted): 1 + 1 + 1 + ... + 1 = n
     * Worst case (descending order): n + (n - 1) + ... + 1 = n(n-1)/2 ~ (n^2)/2
     * Average case: ~ (n^2)/4
     * -> C(n) ~ n^2
     *
     * Considering the number of assignations
     * Best case (sorted): 0
     * Worst case (descending order): n
     * Average case: n / 2
     * -> E(n) ~ n
     *
     * -> Time complexity: O(n) = n^2
     *
     * */
    public static void sort(int[] t) {

        System.out.println(Arrays.toString(t));

        //For every element
        for(int i = 0; i < t.length - 1; i++) {

            //Find the smallest element's index between i and length - 1
            int minIndex = i;
            for(int j = i + 1; j < t.length; j++) {
                if(t[j] < t[minIndex]) minIndex = j; //-> Comparisons in Analysis
            }

            //Swap i and min
            int temp = t[i]; //-> Assignations in Analysis
            t[i] = t[minIndex];
            t[minIndex] = temp;
        }

        System.out.println(Arrays.toString(t));
    }

    public static void sortRecursive(int[] t) {

        System.out.println(Arrays.toString(t));

        sortRecursive(t, 0);

        System.out.println(Arrays.toString(t));
    }

    private static void sortRecursive(int[] t, int i) {

        if(i >= t.length - 1) return;//Stop condition

        //Find the smallest element's index between i and length - 1
        int min = min(t, i, i + 1);

        //Swap i and min
        int temp = t[i];
        t[i] = t[min];
        t[min] = temp;

        //Repeat for next i
        sortRecursive(t, i + 1);
    }

    private static int min(int [] t, int min, int j) {

        if(j >= t.length) return min;

        if(t[j] < t[min]) min = j;

        return min(t, min, j + 1);

    }
}

