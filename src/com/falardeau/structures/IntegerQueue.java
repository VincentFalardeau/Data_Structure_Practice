package com.falardeau.structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class IntegerQueue implements Queue<Integer> {

    ArrayList<Integer> list;

    public IntegerQueue(int[] arr){
        list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            this.add(arr[i]);
        }
    }

    @Override
    public boolean add(Integer o) {

        return  list.add(o);
    }

    public void enqueue(Integer o){
        list.add(0,o);
    }

    public Integer dequeue(){
        return this.remove();
    }



    @Override
    public boolean offer(Integer o) {
        return false;
    }

    @Override
    public Integer remove() {
        if(this.size()>0){
            return list.remove(this.size()-1);
        }

        return null;
    }

    @Override
    public Integer poll() {
        return null;
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < size(); i++){
            str+=list.get(i)+", ";
        }
        return str;
    }
}
