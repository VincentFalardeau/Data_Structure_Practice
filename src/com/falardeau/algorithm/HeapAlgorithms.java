package com.falardeau.algorithm;

public class HeapAlgorithms {

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
    public static void heapify(int[] A){
        int n = A.length;
        for(int i = n/2; i >= 0; i--){
            sink(A, A[i], i, n);
        }
    }

    public static void sink(int[] A, int x, int i, int n){

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
    public static int minChild(int [] A, int i, int n){

        int c1 = (2 * i) + 1;
        int c2 = (2 * i) + 2;
        int minChild = -1;

        if(c1 < n) minChild = c1;
        if(c2 < n && A[c2] < A[c1]) minChild = c2;

        return minChild;
    }


    /**
     * Prints all the elements that are smaller than k among the the array A
     * @param A, array
     * @param k, the upper bound
     * */
    public static void printSmaller(int[] A, int k){

        heapify(A);

        printSmaller(A, k, A.length, 0);

    }

    /**
     * Prints all the elements that are smaller than k among the heapified array, A
     * @param A, heapified array (will be heapified anyway)
     * @param k, the upper bound
     * @param n, the number of elements in A
     * @param i, the index of the current element
     *
     *           Note that we are doing a prefix route here
     * */
    private static void printSmaller(int[] A, int k, int n, int i){

        if(i < n && A[i] < k) {
            System.out.print(A[i] + " ");

            //For left child
            printSmaller(A, k, n, (2*i)+1);

            //For right child
            printSmaller(A, k, n, (2*i)+2);
        }
    }
}
