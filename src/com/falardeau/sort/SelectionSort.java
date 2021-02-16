package com.falardeau.sort;

import java.util.Arrays;

public class SelectionSort {

    //Complexity: O(n^2)

    public static void sort(int[] t) {

        System.out.println(Arrays.toString(t));

        //For every element
        for(int i = 0; i < t.length - 1; i++) {

            //Find the smallest element's index between i and length - 1
            int min = i;
            for(int j = i + 1; j < t.length; j++) {
                if(t[j] < t[min]) min = j;
            }
            //Swap i and min
            int temp = t[i];
            t[i] = t[min];
            t[min] = temp;
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

