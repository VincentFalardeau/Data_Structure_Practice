package com.falardeau.heap;

import com.falardeau.structures.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LazyHeapList  implements Iterable<Comparable>{

    private class Node implements Comparable{
        Comparable data;
        Node next;

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

    private Node HEAD;

    public LazyHeapList(){
        HEAD = new Node(null);
    }

    //O(1)
    public void insert(Comparable i){
        Node x = new Node(i);
        if(isEmpty()){
            HEAD.next = x;
        }
        else{
            Node temp = HEAD.next;
            HEAD.next = x;
            HEAD.next.next = temp;
        }
    }

    public Comparable deleteMin(){
        Node N = HEAD.next;
        Node minParent = null;
        Comparable min = null;
        while(N.next != null){
            Comparable curr = N.next.data;

            //If a smaller element is found, assign it to min
            if(min == null || curr.compareTo(min)<0){
                min = curr;
                minParent = N;
            }
            N = N.next;
        }
        minParent.next.next = minParent.next;
        return min;


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
        return new LazyHeapListIterator();
    }

    private class LazyHeapListIterator implements Iterator<Comparable> {

        private Node current;

        public LazyHeapListIterator(){
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
