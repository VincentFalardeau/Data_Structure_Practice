package com.falardeau.sort;

import java.util.Arrays;

public class Mergesort {

    //Complexity: O(nlog(n))

    public static void sort(int[] t) {
        System.out.println(Arrays.toString(t));
        t = mergesort(t);
        System.out.println(Arrays.toString(t));
    }

    /**
     * Mergesort
     *
     * */
    private static int[] mergesort(int[] t) {

        //If we have 1 or less element, we consider the array is sorted
        if(t.length <= 1) return t;

        //Left array
        int[] l = new int[t.length / 2];
        System.arraycopy(t, 0, l, 0, l.length);

        //Right array
        int[] r = new int[t.length - l.length];
        System.arraycopy(t, l.length, r, 0, r.length);

        //Sort them
        l = mergesort(l);
        r = mergesort(r);

        //Merge them
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

        //counters for respectively l, r, result
        int i = 0, j = 0, k = 0;

        while(i < l.length && j < r.length) {

            //If the next element of l is smaller than the next element of r, add it to result
            if(l[i] < r[j]) {
                result[k] = l[i];
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

