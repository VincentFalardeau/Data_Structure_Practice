package com.falardeau.sort;

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
     * The classic HeapSort
     *
     * */
    public static void sort(int[] A){

        heapify(A);

        int n = A.length-1;
        while(n > 0){

            //root <-> last element
            int temp = A[0];
            A[0] = A[n];
            A[n] = temp;
            //Now, -> last element = smallest element, and root = last element

            //sink the root (old last element)
            //by considering an array range of n-1, because n is now the smallest element, so we keep it at the end

            sink(A, A[0], 0, n);
            n = n - 1;
        }

        //Now, the array is in descending order!

        System.out.println(Arrays.toString(A));
    }

    /**
     * Take all the nodes at level 2, because they possibly have children.
     * We have n/2 of them.
     * Then, sink their root through their child.
     * So for
     *        B
     *       / \
     *      A   C
     * You get:
     *        A
     *       / \
     *      B   C
     * Then, do this recursively, for each parent of the nodes at level 2.
     *
     * Recursive definition
     *  1. Sink the level n nodes
     *  2. Sink their parent at level n+1
     *  ...
     *  3. Sink the root at level h, h = height of the tree -> the root of the tree
     *
     *  Algorithm Analysis:
     *  Consider the sink(A, A[i], i) operation.
     *
     *  As we know from our analysis in the PQBinaryHeap class, the time of sink is log(n) (worst case)
     *  And we do sink n/2 times in heapify
     *
     *  -> T(n) = (n(log(n))/2 ~ nlog(n)
     *
     *  Time Complexity: O(nlog(n)) (linearithmic)
     * */
    private static void heapify(int[] A){
        int n = A.length;
        for(int i = n/2; i >= 0; i--){
            sink(A, A[i], i, n);
        }
    }

    private static void sink(int[] A, int x, int i, int n){

        //The smallest child index
        int cIndex = minChild(A, i, n);

        //While a smallest child can be found, and while it is smaller than v
        while(cIndex >= 0 && A[cIndex] < x){

            //Exchange the parent with its smallest children
            A[i] = A[cIndex];

            //Parent = its smallest children
            i = cIndex;

            //Smallest children of Parent
            cIndex = minChild(A, i, n);
        }

        //We found the place for v!
        A[i] = x;
    }

    //Gives the index of the smallest child
    private static int minChild(int [] A, int i, int n){

        int c1 = (2 * i) + 1;
        int c2 = (2 * i) + 2;
        int minChild = -1;

        if(c1 < n) minChild = c1;
        if(c2 < n && A[c2] < A[c1]) minChild = c2;

        return minChild;
    }
}
