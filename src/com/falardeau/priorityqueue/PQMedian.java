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

        if(median == null){
            median = x;
        }
        //If we have to insert in greaterMinTas next
        else if(greaterMinHeap.size() < smallerMaxHeap.size()){

            //If the current element is smaller than the current median, the median should go on top of the greaterMinTas
            if(x < median){
                greaterMinHeap.insert(median);
                median = x;
            }
            //If the current element is greater than the current median, the current element should got in the greaterMinTas
            else{
                greaterMinHeap.insert(x);

            }
        }
        //If we have to insert in smallerMaxTas
        else{

            //If the current element is greater than the current median, the median should go on top of the smallerMaxTas
            if(x > median){
                smallerMaxHeap.insert(-1*median);
                median = x;
            }
            //If the current element is smaller than the current median, the current element should go in the smallerMaxTas
            else{
                smallerMaxHeap.insert(-1*x);
            }

        }

        //Median adjustements if needed
        if(median > greaterMinHeap.peek()){
            Integer temp = greaterMinHeap.deleteMin();
            greaterMinHeap.insert(median);
            median = temp;
        }
        else if(x < -1*smallerMaxHeap.peek()){
            Integer temp = -1*smallerMaxHeap.deleteMin();
            smallerMaxHeap.insert(-1*median);
            median = temp;
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
