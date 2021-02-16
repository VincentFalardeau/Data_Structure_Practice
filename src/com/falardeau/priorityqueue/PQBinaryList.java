package com.falardeau.priorityqueue;

import com.falardeau.ta.PriorityQueueTA;

import java.util.Iterator;
import java.util.LinkedList;

public class PQBinaryList extends PriorityQueueTA<Integer> {

    LinkedList<Integer> L;

    //TODO: Implement resize()
    public PQBinaryList(){
        L = new LinkedList<Integer>();
    }

    @Override
    public void insert(Integer i){
        if(i == 1){
            L.addLast(i);
        }
        else if(i == 0){
            L.addFirst(i);
        }
    }

    @Override
    public Integer deleteMin() {
        return L.removeFirst();
    }

    @Override
    public int size() {
        return L.size();
    }

    @Override
    public Iterator iterator() {
        return L.iterator();
    }

    //Convert the list to string
    @Override
    public String toString(){

        //Empty string if list is empty
        if(size() == 0) return "";

        //Build a string
        StringBuilder str = new StringBuilder();
        for(Integer item: this){
            str.append("->");
            str.append(item);
        }
        //Note: removes the first useless arrow
        return str.substring(2);
    }



}
