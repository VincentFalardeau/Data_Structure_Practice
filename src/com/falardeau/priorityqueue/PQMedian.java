package com.falardeau.priorityqueue;

import com.falardeau.ta.PriorityQueueTA;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Priority Queue, but the element with the highest priority is the median
 * */
public class PQMedian {

    //Max Heap of the numbers smaller than median
    //Note that smallerMaxHeap is implemented with a Min Heap,
    //but we simulate a Max Heap by storing a number n like this: -1*n
    PQBinaryHeap smallerMaxHeap;
    //Min Heap of the numbers greater than median
    PQBinaryHeap greaterMinHeap;
    //The median
    Integer median;

    public PQMedian(){
        smallerMaxHeap = new PQBinaryHeap();
        greaterMinHeap = new PQBinaryHeap();
    }

    /**
     * Algorithm Analysis
     *
     * */
    public void insert(Integer x) {

       //Empty queue:
        if(median == null){
            median = x;
        }
        else{

            //If x is smaller than the median, x goes into smallerMaxHeap
            if(x < median){
                smallerMaxHeap.insert(-1*x);
            }
            //If is is greater or equal to the median, x goes into greaterMinHeap
            else{
                greaterMinHeap.insert(x);
            }

            //Median adjustement
            if(greaterMinHeap.size() > smallerMaxHeap.size()){
                Integer temp = median;
                median = greaterMinHeap.deleteMin();
                smallerMaxHeap.insert(-1*temp);
            }
            else if(greaterMinHeap.size() < smallerMaxHeap.size()){
                Integer temp = median;
                median = -1*smallerMaxHeap.deleteMin();
                greaterMinHeap.insert(temp);
            }
        }



    }

    public Integer deleteMedian(){
        Integer med = this.median;
        if(greaterMinHeap.size() > smallerMaxHeap.size()){
            median = greaterMinHeap.deleteMin();
        }
        else{
            median = -1*smallerMaxHeap.deleteMin();
        }
        return med;
    }

    public int size() {
        return greaterMinHeap.size() + smallerMaxHeap.size();
    }

    @Override
    public String toString(){
        String s = "Greater than the median: \n";

        Iterator it = greaterMinHeap.iterator();
        it.next();//Jump the empty first cell
        while(it.hasNext()){
            s += it.next() + ", ";
        }

        s += "\nThe median: " + median;

        s += "\nSmaller than the median: \n";

        it = smallerMaxHeap.iterator();
        it.next();//Jump the empty first cell
        while(it.hasNext()){
            s += -1*(Integer)it.next() + ", ";
        }

        return s;
    }
}
