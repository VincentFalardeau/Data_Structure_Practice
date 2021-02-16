package com.falardeau.sort;

import java.util.Arrays;

public class MergeSort {

    //Complexity: O(nlog(n))

    public static void sort(int[] t) {
        System.out.println(Arrays.toString(t));
        t = mergeSort(t);
        System.out.println(Arrays.toString(t));
    }

    private static int[] mergeSort(int[] t) {

        if(t.length <= 1) return t; //If we have 1 or less element, we consider the array is sorted

        int[] l, r; //Left and right array

        //Left array
        int[] l1 = new int[t.length / 2];
        System.arraycopy(t, 0, l1, 0, l1.length);

        //Right array
        int[] r1 = new int[t.length - l1.length];
        System.arraycopy(t, l1.length, r1, 0, r1.length);

        //Sort them
        l = mergeSort(l1);
        r = mergeSort(r1);

        //Merge
        return merge(l, r);

    }

    /**
     * Combine two sorted lists into a single sorted list
     * @param l For left array
     * @param r For right array
     * @return The sorted merge of the two arrays
     */
    private static int[] merge(int[] l, int[] r) {

        int[] result = new int[l.length + r.length];

        int i = 0, j = 0, k = 0;//counters for respectively l, r, result

        while(i < l.length && j < r.length) {

            //If the next element of l is smaller than the next element of r, add it to result
            if(l[i] < r[j]) {
                result[k] = l[i];//on l'ajouter a t
                i++;
            }
            else {//Else the next element of r should be added to result
                result[k] = r[j];
                j++;
            }
            k++;
        }

        //Copy what is remaining in l or r
        if(i < l.length) System.arraycopy(l, i, result, k, l.length - i);
        if(j < r.length) System.arraycopy(r, j, result, k, r.length - j);

        System.out.println(Arrays.toString(result));

        return result;
    }

}

