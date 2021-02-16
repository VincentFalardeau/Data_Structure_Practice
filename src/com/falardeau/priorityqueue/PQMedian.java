package com.falardeau.priorityqueue;

import com.falardeau.ta.PriorityQueueTA;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Priority Queue, but the element with the highest priority is the median
 * */
public class PQMedian {

    //Note that a number of smallerMaxTas is stored as -1*number, to simulate the max tas effect
    PQBinaryHeap smallerMaxTas;
    PQBinaryHeap greaterMinTas;
    Integer median;

    public PQMedian(){
        smallerMaxTas = new PQBinaryHeap();
        greaterMinTas = new PQBinaryHeap();
    }

    public void insert(Integer x) {

        if(median == null){
            median = x;
        }
        //If we have to insert in greaterMinTas next
        else if(greaterMinTas.size() < smallerMaxTas.size()){

            //If the current element is smaller than the current median, the median should go on top of the greaterMinTas
            if(x < median){
                greaterMinTas.insert(median);
                median = x;
            }
            //If the current element is greater than the current median, the current element should got in the greaterMinTas
            else{
                greaterMinTas.insert(x);

            }
        }
        //If we have to insert in smallerMaxTas
        else{

            //If the current element is greater than the current median, the median should go on top of the smallerMaxTas
            if(x > median){
                smallerMaxTas.insert(-1*median);
                median = x;
            }
            //If the current element is smaller than the current median, the current element should go in the smallerMaxTas
            else{
                smallerMaxTas.insert(-1*x);
            }

        }

        if(median > greaterMinTas.peek()){
            Integer temp = greaterMinTas.deleteMin();
            greaterMinTas.insert(median);
            median = temp;
        }
        else if(x<-1*smallerMaxTas.peek()){
            Integer temp = -1*smallerMaxTas.deleteMin();
            smallerMaxTas.insert(-1*median);
            median = temp;
        }

    }

    public Integer deleteMedian(){
        Integer med = this.median;
        if(greaterMinTas.size() > smallerMaxTas.size()){
            median = greaterMinTas.deleteMin();
        }
        else{
            median = -1*smallerMaxTas.deleteMin();
        }
        return med;
    }

    public int size() {
        return greaterMinTas.size() + smallerMaxTas.size();
    }

    @Override
    public String toString(){
        String s = "Greater than the median: \n";
        for(Integer i: greaterMinTas){
            s+= i + ", ";
        }

        s += "\nThe median: " + median;

        s += "\nSmaller than the median: \n";
        for(Integer i: smallerMaxTas){
            s+= -1*i + ", ";
        }

        return s;
    }
}
