package com.falardeau.sort;

public class Main5 {

    public static void main(String[] args) {

        int[] t = {10,16,-7,12,15,10,9,5,6,3,9,5};

        int[] t1 = new int[12];
        System.out.println("Quick sort (tri par pivot)");
        System.arraycopy(t, 0, t1, 0, t.length);
        QuickSort.sort(t1);
        System.out.println();

        System.out.println("Selection sort");
        System.arraycopy(t, 0, t1, 0, t.length);
        SelectionSort.sort(t1);
        System.out.println();

        System.out.println("Selection sort - recursive");
        System.arraycopy(t, 0, t1, 0, t.length);
        SelectionSort.sortRecursive(t1);
        System.out.println();

        System.out.println("Insertion sort");
        System.arraycopy(t, 0, t1, 0, t.length);
        InsertionSort.sort(t1);
        System.out.println();

        System.out.println("Insertion sort - recursive");
        System.arraycopy(t, 0, t1, 0, t.length);
        InsertionSort.sortRecursive(t1);
        System.out.println();

        System.out.println("Merge sort");
        System.arraycopy(t, 0, t1, 0, t.length);
        MergeSort.sort(t1);
        System.out.println();

        System.out.println("Heap sort - trivial way");
        System.arraycopy(t, 0, t1, 0, t.length);
        HeapSort.trivialSort(t1);
        System.out.println();

        System.out.println("Heap sort");
        System.arraycopy(t, 0, t1, 0, t.length);
        HeapSort.sort(t1);
        System.out.println();


    }

}
