package com.falardeau.sort;

import java.util.Arrays;

public class InsertionSort {

    //Complexity: O(n^2)

    public static void sort(int[] t) {
        System.out.println(Arrays.toString(t));

        for(int i = 1; i < t.length; i++) {

            int curr = t[i];//The current element

            int j;
            //From i - 1 to 0, shift right the elements
            for(j = i; j > 0; j--) {
                //Until t[j - 1] is smaller than curr
                if(t[j - 1] < curr) {
                    break;
                }
                t[j] = t[j - 1];
            }
            //Insert curr at j, the index to the right the smaller element
            t[j] = curr;
        }

        System.out.println(Arrays.toString(t));
    }

    public static void sortRecursive(int[] t) {
        System.out.println(Arrays.toString(t));

        sortRecursive(t, 0);

        System.out.println(Arrays.toString(t));
    }

    private static void sortRecursive(int[] t, int i) {

        if(i >= t.length) return;//Stop condition

        //Insert t[i] where it should be
        insert(t, i);

        //Repeat for the next i
        sortRecursive(t, i + 1);
    }

    private static void insert(int [] t, int i) {
        int curr = t[i];
        i = shiftRight(t, curr, i);
        t[i] = curr;
    }

    //Shift right the elements until an element is found to be smaller than curr
    //Return the position a the right of the smaller element
    private static int shiftRight(int[] t, int curr, int j) {

        if(j <= 0) return 0; //Stop condition, curr element shall be placed a the beginning

        if(t[j - 1] < curr) {
            //If the element right next to t[j] is smaller than curr
            //curr shall be placed at the index j
            return j;
        }
        //Shift the element
        t[j] = t[j - 1];

        return shiftRight(t, curr, j - 1);//Continue shifting right otherwise
    }



}

