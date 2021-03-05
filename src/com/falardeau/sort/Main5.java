package com.falardeau.sort;

public class Main5 {

    public static void main(String[] args) {

        int[] t = {10,16,-7,12,15,10,9,5,6,3,9,5};

        int[] t1 = new int[12];
        System.out.println("Quick sort (tri par pivot)");
        System.arraycopy(t, 0, t1, 0, t.length);
        Quicksort.sort(t1);
        System.out.println();

        System.out.println("Quick sort (tri par pivot) - Iterative");
        System.arraycopy(t, 0, t1, 0, t.length);
        Quicksort.sortIter(t1);
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
        Mergesort.sort(t1);
        System.out.println();

        System.out.println("Heap sort - trivial way");
        System.arraycopy(t, 0, t1, 0, t.length);
        HeapSort.trivialSort(t1);
        System.out.println();

        System.out.println("Heap sort");
        System.arraycopy(t, 0, t1, 0, t.length);
        HeapSort.sort(t1);
        System.out.println();

        System.out.println("------------------------------------------------------");
        System.out.println("Exercices:");
        System.out.println("------------------------------------------------------");

        Sorter sorter = new Sorter();

        System.out.println("t.1 Baby sort - 3 elements");
        int A[] = {2,1,3};
        sorter.print(A);
        sorter.babySort3(A);
        sorter.print(A);
        System.out.println();
        A = new int[]{3,2,1};
        sorter.print(A);
        sorter.babySort3(A);
        sorter.print(A);
        System.out.println();
        A = new int[]{3,1,2};
        sorter.print(A);
        sorter.babySort3(A);
        sorter.print(A);
        System.out.println();
        A = new int[]{1,3,2};
        sorter.print(A);
        sorter.babySort3(A);
        sorter.print(A);
        System.out.println();

        System.out.println("t.1 Baby sort - 4 elements");
        A = new int[]{2,1,3,4};
        sorter.print(A);
        sorter.babySort4(A);
        sorter.print(A);
        System.out.println();
        A = new int[]{4,3,2,1};
        sorter.print(A);
        sorter.babySort4(A);
        sorter.print(A);
        System.out.println();
        A = new int[]{3,2,4,1};
        sorter.print(A);
        sorter.babySort4(A);
        sorter.print(A);
        System.out.println();
        A = new int[]{3,2,1,4};
        sorter.print(A);
        sorter.babySort4(A);
        sorter.print(A);
        System.out.println();

        System.out.println("t.2 Bitonic sort");
        A = new int[]{1,2,4,4,7,8,7,6,5,3,2,2,1};
        sorter.print(A);
        int[] T = sorter.bitonicSort(A);
        sorter.print(T);
        System.out.println();

        System.out.println("t.3.a Modified selection sort");
        A = new int[]{2,3,1,5,4};
        sorter.print(A);
        sorter.deltaSelectionSort(A,2);
        sorter.print(A);
        System.out.println();

        System.out.println("t.3.b Window sort");
        A = new int[]{2,3,1,5,4};
        sorter.print(A);
        sorter.windowSort(A,2);
        sorter.print(A);
        System.out.println();

        System.out.println("t.4");
        int[] S = new int[]{5,6,2,3,1,4};
        int[] N = new int[]{3,5,1,2,6,4};
        System.out.print("Screws: ");
        sorter.print(S);
        System.out.print("Nuts:   ");
        sorter.print(N);
        sorter.screwAndNut(S, N);
        System.out.print("Screws: ");
        sorter.print(S);
        System.out.print("Nuts:   ");
        sorter.print(N);
        System.out.println();

        System.out.println("t.5");
        A = new int[]{1,2,7};
        int[] B = new int[]{3,7};
        int[] C = new int[]{4,5,6};
        int[] D = new int[]{6,8,9};
        int[][] mat = new int[4][3];
        mat[0] = A;
        mat[1] = B;
        mat[2] = D;
        mat[3] = C;
        sorter.print(A);
        sorter.print(B);
        sorter.print(D);
        sorter.print(C);
        int[] merged = sorter.merge(mat, 11, 4);
        sorter.print(merged);
        System.out.println();

        A = new int[]{1,3,5,7,0,2,3,4};
        sorter.print(A);
        System.out.println(sorter.quickSelect(A, 2));






    }

}
