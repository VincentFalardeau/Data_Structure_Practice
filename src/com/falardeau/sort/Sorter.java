package com.falardeau.sort;

import com.falardeau.priorityqueue.PQBinaryHeap;

import java.util.Arrays;

public class Sorter {

    public int quickSelect(int[] A, int k){
        return quickSelect(A, 0, A.length-1, k);
    }

    /**
     * Search for the kth smallest element in an array
     * @param A, the array
     * @param l, the left index
     * @param r, the right index
     * @param k, specifies k in: the kth smallest
     * @return the kth smallest element in A
     * */
    private int quickSelect(int[] A, int l, int r, int k){
        if(r - l <= 2){
            if(r == l + 2 && A[r-1] < A[l]) {
                swap(A, l, r-1);
                return A[k];
            }
        }
        int i = partition(A, l, r);
        if(k == i){
            return A[k];
        }
        if(k < i){
            return quickSelect(A, l, i, k);
        }
        return quickSelect(A, i+1, r, k);
    }

    /**
     * Sorts array A using quicksort method
     * @param A, array
     * */
    public void quicksort(int[] A){
        quicksort(A, 0, A.length-1);
    }

    private void quicksort(int[] A, int l, int r){

        if(l < r){

            int pivot = partition(A, l, r);

            quicksort(A, l, pivot);
            quicksort(A, pivot + 1, r);
        }
    }

    private int partition(int[] A, int l, int r){

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

    //https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem/
    public void screwAndNut(int[] S, int[] N){
        assert S.length == N.length;

        screwAndNut(S, N, 0, S.length-1);
    }

    private void screwAndNut(int[] S, int[] N, int l, int r){

        if(l < r){

            // Choose last character of bolts array for nuts partition.
            int pivot = partition(N, l, r, S[r]);

            // Now using the partition of nuts choose that for bolts partition
            partition(S, l, r, N[pivot]);

            // Recur for [left...pivot-1] & [pivot+1...right] for nuts and bolts array
            screwAndNut(N, S, l, pivot-1);
            screwAndNut(N, S, pivot+1, r);
        }
    }

    public int[] merge(int[][] lists, int n, int k){
        assert lists.length > 0;

        //Heap of size k
        PQBinaryHeap heap = new PQBinaryHeap();
        //The resulting array containing all the lists
        int[] result = new int[n];
        //The index of the current element in the result array
        int m = 0;
        //The index of the current element in the lists
        int j = 0;

        while(m < n-heap.realSize()){

            //Iterate trough the lists
            for(int i = 0; i < k; i++){

                //Make sure we have not finished to read this list and
                if(j < lists[i].length){

                    //Insert the element if the heap is not full
                    if(heap.realSize() < k){
                        heap.insert(lists[i][j]);
                    }
                    //Otherwise add the smallest element between the heap's root and the current element in result
                    else{
                        //In case the heap's root is smaller
                        if(heap.peek() < lists[i][j]){
                            result[m] = heap.deleteMin();
                            m++;
                            heap.insert(lists[i][j]);
                        }
                        //In case the current element is smaller
                        else{
                            result[m] = lists[i][j];
                            m++;
                        }
                    }
                }

            }
            j++;
        }

        while(m < n){
            result[m] = heap.deleteMin();
            m++;
        }


        return result;

//        assert M.length > 0;
//
//        PQBinaryHeap heap = new PQBinaryHeap();
//        int[] merged = new int[n];
//        int l = 0;
//
//        for(int i = 0; i < n/k; i++){
//
//            for(int j = 0; j < k; j++){
//
//                if(heap.realSize() < k){
//                    heap.insert(M[j][i]);
//                }
//                else if(heap.peek() < M[j][i]){
//                    merged[l] = heap.deleteMin();
//                    l++;
//                    heap.insert(M[j][i]);
//                }
//                else{
//                    merged[l] = M[j][i];
//                    l++;
//                }
//            }
//        }
//
//        while(l < n){
//            merged[l] = heap.deleteMin();
//            l++;
//        }
//
//        return merged;


//
//
//        PQBinaryHeap heap = new PQBinaryHeap();
//
//        int currentListIndex = 0;
//        int[] currentList = sortedLists[currentListIndex];
//        int j = 0;
//
//        for(int i = 0; i < n; i++){
//
//            //If it is time to take the next list
//            if(j == currentList.length){
//                currentListIndex++;
//                currentList = sortedLists[currentListIndex];
//                j = 0;
//            }
//
//            heap.insert(currentList[j]);
//            j++;
//        }
//
//        int[] merged = new int[n];
//        for(int i = 0; i < n; i++){// n
//            merged[i] = heap.deleteMin();// * log(k)
//        }
//
//        return merged;
    }

    /**
     * Merges sorted array A and B
     * */
    public int[] merge(int[] A, int[] B){

        int[] C = new int[A.length + B.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < A.length && j < B.length){

            if(A[i] < B[j]){
                C[k] = A[i];
                i++;
            }
            else{
                C[k] = B[j];
                j++;
            }

            k++;
        }

        if(i < A.length){
            while(k < C.length){
                C[k] = A[i];
                i++;
                k++;
            }
        }

        if(j < B.length){
            while(k < C.length){
                C[k] = B[j];
                j++;
                k++;
            }
        }

        return C;
    }

    // Similar to standard partition method. Here we pass the pivot element
    // too instead of choosing it inside the method.
    private int partition(int[] A, int l, int r, int pivot){

        int i = l;
        for (int j = l; j < r; j++)
        {
            if (A[j] < pivot){
                swap(A, i, j);
                i++;
            } else if(A[j] == pivot){
                swap(A, j, r);
                j--;
            }
        }
        swap(A, i, r);

        // Return the partition index of an array based on the pivot
        // element of other array.
        return i;
    }

    private class Index{
        int pivot, i, j;
    }

    /**
     * Sorts an array of 3 elements.
     * @param A, the array
     *
     * @Analysis
     * Number of comparisons: 3
     * Complexity:            O(1)
     * */
    public void babySort3(int[] A){
        assert A.length == 3;

       sort(A, 0,1);
       sort(A, 0,2);
       sort(A, 1,2);
    }

    /**
     * Sorts an array of 4 elements.
     * @param A, the array
     *
     * @Analysis
     * Number of comparisons: 4
     * Complexity:            O(1)
     * */
    public void babySort4(int[] A){
        assert A.length == 4;

        sort(A, 0,3);
        sort(A, 1,2);
        sort(A, 0,1);sort(A, 2,3);
        sort(A, 1,2);
    }

    /**
     * Sort the given bitonic array in ascending order
     *
     * @param A, the bitonic array
     *
     * @return A sorted in ascending order
     *
     * @Analysis
     * Number of comparisons:
     *      Best case:      n
     *      Worst case:     n
     *      Average case:   n
     * Complexity:            O(n)
     * */
    public int[] bitonicSort(int[] A){
        assert A.length > 0;

        int[] T = new int[A.length];

        int i = 0;
        int j = A.length-1;
        int k = 0;

        while(k < T.length){

            if(A[i] <= A[j]){
                T[k] = A[i];
                i++;
            }
            else if(A[i] > A[j]){
                T[k] = A[j];
                j--;
            }

            k++;
        }

        return T;
    }

    /**
     * Sorts an "almost sorted array": elements can be moved by <= delta positions and the array will be sorted.
     * @param A, the "almost sorted array"
     * @param delta, the delta
     *
     * @Analysis
     * Number of comparisons:
     *      Best case:      T(n) = delta(n)
     *      Worst case:     T(n) = (n-1)*delta = delta(n)-delta ~ delta(n)
     *      Average case:   T(n) = delta(n)
     * Complexity:           O(delta(n))
     *
     * */
    public void deltaSelectionSort(int A[], int delta){
        assert delta < A.length;

        for(int i = 0; i < A.length-1; i++){ //n-1 iterations

            int minIndex = i;
            for(int j = 1; j <= delta && i + j < A.length; j++){ //At most delta iterations

                if(A[i + j] < A[minIndex])minIndex = i + j;//Comparison
            }

            swap(A, minIndex, i);
        }
    }

    /**
     * Sorts an "almost sorted array": elements can be moved by <= delta positions and the array will be sorted.
     * @param A, the "almost sorted array"
     * @param delta, the delta
     *
     * @Analysis
     * Number of comparisons:
     *      Best case:      delta = 0       T(n) = 0
     *      Worst case:     delta = n       T(n) = O(log n) * n
     *      Average case:   delta = n/2     T(n) = O(log n/2) * n
     *      Random case:    delta = delta   T(n) = O(log delta) * n
     * Complexity:           O((log delta) * n)
     *
     *      *Note that a PQ insertion takes O(log n) time, since the PQ is implemented with a Binary Heap here.
     *      *Note that the comparisons are done in the swim algorithm of the PQ insert's method
     * */
    public void windowSort(int A[], int delta){
        assert delta < A.length;

        //Initialize the window with A[0...delta-1]
        //Note that this part is not considered in the analysis
        //We rather consider that the window is already initialized
        PQBinaryHeap window = new PQBinaryHeap();
        for(int k = 0; k <= delta; k++) {
            window.insert(A[k]);//Comparisons
        }

        //Move the window while sorting A
        int i = 0;
        int j = delta + 1;
        while(j < A.length){
            A[i] = window.deleteMin();
            window.insert(A[j]);//Comparisons
            i++; j++;
        }

        //Sort the last part of A, when the window cannot move anymore
        while(i < A.length){
            A[i] = window.deleteMin();
            i++;
        }
    }

    /**
     * Prints array A
     * @param A, the array
     * */
    public void print(int[] A){
        System.out.println(Arrays.toString(A));
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private void sort(int[] A, int i, int j){
        if(A[i] > A[j]) swap(A,i,j);
    }


}
