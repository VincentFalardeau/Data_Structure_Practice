package com.falardeau.sort;

import java.util.Arrays;

public class Quicksort { //Also called "tri par pivot"

    public static void sort(int[] t) {
        System.out.println(Arrays.toString(t));
        sort(t, 0, t.length - 1);
        System.out.println(Arrays.toString(t));
    }

    public static void sortIter(int[] t) {
        System.out.println(Arrays.toString(t));
        sort_iter(t, 0, t.length - 1);
        System.out.println(Arrays.toString(t));
    }

    /**
     * Quicksort
     * @param A, the array
     * @param l, the left index
     * @param r, the right ind
     *
     * @Analysis
     * If we suppose that the pivot is always the element in the middle, the time is O(n(log n))
     * */
    private static void sort(int[] A, int l, int r) {

        //If t still has to be sorted
        if(l < r) {

            int pivot = partition(A, l, r);

            sort(A, l, pivot - 1);
            sort(A, pivot + 1, r);
        }
    }

    private static void sort_iter(int[] A, int l, int r){

        while(r - l > 0){
            int pivot = partition(A, l, r);
            sort_iter(A, l, pivot);
            l = pivot + 1;

            //Note: r stays as it was passed as a parameter
            //So the second call after doing: l = pivot + 1;
            //is equivalent to: sort_iter(A, pivot + 1, r);
        }
    }

    /**
     * @param A	The array to partition
     * @param l The beginning of the partition
     * @param r The end of the partition
     * @return The sorted position of pivot
     *
     * @Analysis
     * Time is O(n)
     */
    private static int partition(int[] A, int l, int r) {

        int pivot = l;

        int i = l;
        int j = r;

        while(i < j){

            //Increment i until you find an element greater or equal to pivot
            do{
                i++;
            } while(i < r && A[i] < A[pivot]);

            //Decrement j until you find an element smaller than pivot
            while(j >= i && A[j] >= A[pivot]){
                j--;
            }

            if(j < i) break;

            swap(A, i, j);
        }

        swap(A, j, l);

        return j;
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

