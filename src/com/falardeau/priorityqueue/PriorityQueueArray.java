package com.falardeau.priorityqueue;

import com.falardeau.ta.PriorityQueueTA;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Priority Queue implemented with a sorted array of Integer.
 * */
public class PriorityQueueArray extends PriorityQueueTA<Integer> {

    /**
     * Algorithm analysis:
     *
     * Analyse the execution time considering the number of comparisons.
     * Not considering the impact of resize()
     *
     * if n = 0: 1
     * n = 1: 1 + 1 + 1  = 3
     * n = 2: 1 + 1 + 2 = 4
     * n = 4: 1 + 1 + 4 = 6
     *
     * For any n: T(n) = 1 + 1 + n ~ n
     *
     * Linear time complexity
     * */
    @Override
    public void insert(Integer x) {

        n++;

        //First element special case
        if(n == 1){
            queue[0] = x;
            return;
        }

        //Resize if needed
        if(n == queue.length) resize();

        //Find the right index for x
        int i = 0;
        while(x < queue[i]) i++;

        //Shift queue's content to the right
        int j = n-1;
        while(j > i){
            queue[j] = queue[j - 1];
            j--;
        }

        //Insert x
        queue[i] = x;
    }

    /**
     * Algorithm analysis:
     *
     * Analyse the execution time considering the number of assignations.
     *
     * For any n: T(n) = 1 + 1 + 1 = 3
     *
     * Constant time complexity
     * */
    @Override
    public Integer deleteMin() {
        if(n == 0) return null;

        n--;

        Integer min = queue[n];
        queue[n] = null;

        return min;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PriorityQueueIterator();
    }

    @Override
    public String toString(){

        if(n == 0) return "[]";

        String str = "";

        for(Integer i: this){
            str += ", ";
            str += i;
        }

        str = "[" + str.substring(2) + "]";
        return str;
    }

    public PriorityQueueArray(){
        queue = new Integer[DEFAULT_SIZE];
        n = 0;
    }

    private final int DEFAULT_SIZE = 8;
    private Integer[] queue;
    //Keeps hold of the number of elements in queue
    private int n;

    //Resizes the queue
    private void resize() {

        if(n < queue.length)return;

        //Make a copy with twice the size
        Integer[] copy = new Integer[queue.length * 2];

        //Copy the elements
        for (int i = 0; i < n; i++) {
            copy[i] = queue[i];
        }
        queue = copy;
    }

    private class PriorityQueueIterator implements Iterator<Integer> {
        private int i = 0;
        public boolean hasNext()  {
            return i < n;
        }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            Integer next = queue[i];
            i++;
            return next;
        }
    }


}
