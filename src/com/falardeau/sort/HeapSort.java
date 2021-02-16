package com.falardeau.sort;

import com.falardeau.algorithm.HeapAlgorithms;
import com.falardeau.priorityqueue.PQBinaryHeap;

import java.util.Arrays;

public class HeapSort {


    /**
     * The trivial way.  Puts the content of A in a Priority-Queue, made with a Binary Heap.
     * Then, iterate through the P-Q and take the smallest element, and put it in A[i]
     *
     * Algorithm Analysis:
     * Considering the Heap.insert operation and the Heap.deleteMin
     *
     * For a heap of n elements, we know that the Heap.insert operation takes log(n) time.
     * For a heap of n elements, we know that the Heap.deleteMin operation takes log(n) time
     * Plus, we know iterating through the n elements of A takes n time
     *
     * -> T(n) = nlog(n) + nlog(n) = 2nlog(n) ~ nlog(n)
     * -> Time complexity: O(nlog(n)) (linearithmic)
     *
     * Now, consider the working space of this algorithm
     *
     * We need an auxiliary structure, a PQBinaryHeap, containing n nodes.
     *
     * -> S(n) = n
     * -> Space complexity: O(n)
     * */
    public static void trivialSort(int[] A) {

        System.out.println(Arrays.toString(A));

        //Put everything in a heap
        PQBinaryHeap heap = new PQBinaryHeap();
        for(int i = 0; i < A.length; i++){
            heap.insert(A[i]);// -> Considered operation in the Analysis
        }

        //Put back everything in A, then A will be ordered
        for(int i = 0; i < A.length; i++){

            A[i] = heap.deleteMin();// -> Considered operation in the Analysis
        }

        System.out.println(Arrays.toString(A));
    }

    /**
     * The classic HeapSort.
     *
     * heapify(A)-> T(n) = (n(log(n))/2 ~ nlog(n)
     *
     * Then, consider the number of times that sink is performed: n times
     * sink -> T(n) = floor(lg(n/l)) ~ log(n)
     *
     * So the execution time of sort, according to the size of the given array:
     *
     * T(n) = nlog(n) + nlog(n) ~ nlog(n)
     *
     * Time complexity: O(nlog(n))
     *
     * Space complexity: O(1)
     *
     * */
    public static void sort(int[] A){

        System.out.println(Arrays.toString(A));

        HeapAlgorithms.heapify(A);

        int n = A.length-1;
        while(n > 0){

            //root <-> last element
            int temp = A[0];
            A[0] = A[n];
            A[n] = temp;
            //Now, -> last element = smallest element, and root = last element

            //sink the root (old last element)
            //by considering an array range of n-1, because n is now the smallest element, so we keep it at the end

            HeapAlgorithms.sink(A, A[0], 0, n);
            n = n - 1;
        }

        //Now, the array is in descending order!
        System.out.println(Arrays.toString(A));
    }


}
