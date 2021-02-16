package com.falardeau.sort;

import java.util.Arrays;

public class QuickSort { //Also called "tri par pivot"

    public static void sort(int[] t) {
        System.out.println(Arrays.toString(t));
        sort(t, 0, t.length - 1);
        System.out.println(Arrays.toString(t));
    }

    private static void sort(int[] t, int beginning, int end) {

        //If t still has to be sorted
        if(beginning < end) {

            int pivot = partition(t, beginning, end); //Complexite : n (parcours lineaire de la liste)

            sort(t, beginning, pivot - 1); //Complexite : log(n) avec la base 2 (chaque fois on subdivise par 2)
            sort(t, pivot + 1, end);

            //Donc la complexite est de O(nlog(n)), supposant que la partition se fait toujours au milieu de la liste

        }
    }

    /**
     * @param t	The array to partition
     * @param beginning The beginning of the partition
     * @param end The end of the partition
     * @return The sorted position of pivot
     */
    private static int partition(int[] t, int beginning, int end) {

        int pivot = t[beginning];

        int i = beginning;
        int j = end;

        //While i is smaller than j
        while(i < j) {
            //Increment i until you find an element greater than pivot
            while(t[i] <= pivot) {
                i++;
            }
            //Decrement j until you find an element smaller than pivot (or equal to it)
            while(t[j] > pivot) {
                j--;
            }
            if(i < j) {
                //Exchange them
                int temp = t[i];
                t[i] = t[j];
                t[j] = temp;
            }

        }
        //j becomes the position of pivot, so interchange j and pivot
        t[beginning] = t[j];
        t[j] = pivot;

        //Return the position of the pivot
        return j;

    }
}

