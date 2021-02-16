package com.falardeau.priorityqueue;

import com.falardeau.ta.PriorityQueueTA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Priority Queue implemented with a binary heap
 * */
public class PQBinaryHeap extends PriorityQueueTA<Integer> {

    //The heap
    List<Integer> H;

    public PQBinaryHeap(){
        H = new LinkedList<>();
        H.add(-1);//Index 0 contains nothing
    }

    /**
     * Algorithm Analysis
     *
     * Analyse the execution time considering the number of assignations.
     *
     * v is at level 0: (for n = 1)
     *      Best: 0
     *      Worst: 0
     * v is at level 1: (for n = 2,3)
     *      Best: 0
     *      Worst: 1
     * v is at level 2: (for n = 4,5,6,7)
     *      Best: 0
     *      Worst: 2
     *      Average: 1
     * v is at level 3: (for n = 8,9,10,11,12,13,14,15)
     *      Best: 0
     *      Worst: 3
     *      Average: 1 or 2
     *
     * v is at level l: (for n = 2^l, ..., 2^(i+l) - 1)
     *      Best: T(n) = 0
     *      Worst: T(n) = floor(lg(n)) ~ lg(n)
     *      Average: T(n) = floor(lg(n)/2) ~ lg(n)
     *
     * Time Complexity: O(log(n)) (logarithmic)
     * */
    private void swim(Integer v, int i){

        //The parent's index
        //Notice: automatic floor with Integer
        int pIndex = i/2;

        //While not up to the root, and while parent is greater than v
        while(pIndex > 0 && H.get(pIndex) > v){

            //Exchange the parent with the current node
            H.set(i, H.get(pIndex));// <- Assignation in the Analysis

            //Current node = its parent
            i = pIndex;

            //Parent = next parent
            pIndex = i/2;
        }

        //We found the place for v!
        H.set(i, v);
    }

    /**
     * Algorithm Analysis
     *
     * Analyse the execution time considering the number of assignations.
     *
     * v is at height l, and the Heap has n nodes
     *
     * -> So the size of the sub tree for which v is root is floor(n/l)
     * -> So the greatest possible level is floor(lg(n/l)) for that sub-tree
     *
     *      Best: T(n) = 0
     *      Worst: T(n) = floor(lg(n/l)) ~ lg(n)
     *      Average: T(n) = floor(lg(n)/2) ~ lg(n)
     *
     * Time Complexity: O(log(n)) (logarithmic)
     * */
    private void sink(Integer v, int i){

        //The smallest child index
        int cIndex = minChild(i);

        //While a smallest child can be found, and while it is smaller than v
        while(cIndex > 0 && H.get(cIndex) < v){

            //Exchange the parent with its smallest children
            H.set(i, H.get(cIndex));// <- Assignation in the Analysis

            //Parent = its smallest children
            i = cIndex;

            //Smallest children of Parent
            cIndex = minChild(i);
        }

        //We found the place for v!
        H.set(i, v);


    }

    //Gives the index of the smallest child
    private int minChild(int i){

        int c1 = 2 * i;
        int c2 = (2 * i) + 1;
        int minChild = 0;

        if(c1 < size()) minChild = c1;
        if(c2 < size() && H.get(c2) < H.get(c1)) minChild = c2;

        return minChild;
    }

    @Override
    public void insert(Integer x) {
        H.add(x);
        swim(x, size()-1);
    }

    @Override
    public Integer deleteMin() {

        if(size() == 1) return null;

        if(size() == 2){
            //Keep the a backup of the root (minimal element)
            Integer min = H.get(1);

            H.remove(1);

            return min;
        }

        //Keep the a backup of the root (minimal element)
        Integer min = H.get(1);

        //Sink (with the removed last element)
        Integer v = H.remove(size()-1);
        sink(v, 1);

        return min;
    }

    @Override
    public int size() {
        return H.size();
    }

    public Integer peek() {
        return H.get(1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return H.iterator();
    }

    @Override
    public String toString(){

        String s = "";

        int i = 1;
        int j = 1;
        while(i < size()){

            s += H.get(i);
            s += ",";

            if(i == j){
                j = j * 2 + 1;
                s += "\n";
            }

            i++;
        }

        return s;

    }
}
