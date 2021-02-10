package com.falardeau.heap;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList implements Iterable<Comparable>{

    protected class Node implements Comparable{
        Comparable data;
        Node next;
        Node previous;

        public Node(Comparable data){
            this.data = data;
        }

        @Override
        public String toString(){
            return data.toString();
        }

        @Override
        public int compareTo(Object o) {
            return data.compareTo(o);
        }
    }

    protected Node HEAD;

    public DoubleLinkedList(){
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
        for(Comparable item: this){
            str.append("->");
            str.append(item);
        }
        //Note: removes the first useless arrow
        return str.substring(2);
    }

    @Override
    public Iterator<Comparable> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<Comparable> {

        private Node current;

        public DoubleLinkedListIterator(){
            current = HEAD;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Comparable next() {
            if (!hasNext()) throw new NoSuchElementException();

            current = current.next;

            return current.data;
        }
    }
}
