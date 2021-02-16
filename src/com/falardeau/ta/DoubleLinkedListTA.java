package com.falardeau.ta;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class DoubleLinkedListTA implements Iterable<Integer>{


    public Node HEAD;

    public DoubleLinkedListTA(){
        HEAD = new Node(null);
    }

    public boolean isEmpty(){
        return HEAD.next == null;
    }

    //Convert the list to string
    @Override
    public String toString(){

        //Empty string if list is empty
        if(isEmpty()) return "";

        //Build a string
        StringBuilder str = new StringBuilder();
        for(Integer item: this){
            str.append("->");
            str.append(item);
        }
        //Note: removes the first useless arrow
        return str.substring(2);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<Integer> {

        private Node current;

        public DoubleLinkedListIterator(){
            current = HEAD;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();

            current = current.next;

            return current.data;
        }
    }
}
