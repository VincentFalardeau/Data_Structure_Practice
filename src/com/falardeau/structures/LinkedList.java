package com.falardeau.structures;

import javax.swing.text.html.HTMLEditorKit;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList <Item> implements Iterable<Item>{

    private class Node<Item>{
        Item data;
        Node<Item> next;

        public Node(Item data){
            this.data = data;
        }

        @Override
        public String toString(){
            return data.toString();
        }

    }

    private Node HEAD;

    public LinkedList(){
        HEAD = new Node(null);
    }

    //Adds a node containing data to the LinkedList
    public void add(Item data){

        //If it is the first node
        if(isEmpty()){
            HEAD.next = new Node(data);
        }
        //If not, append to the end
        else{
            lastNode().next = new Node(data);
        }
    }

    //Exchange the two node following the Nth node
    // ...->N->B->C->...
    public void exchange(int N){

        Node N_node = getNode(N);
        Node B = N_node.next;

        if(B == null) throw new IndexOutOfBoundsException();

        Node C = B.next;

        if(C == null) throw  new IndexOutOfBoundsException();

        Node C_next = C.next;

       N_node.next = C;
       C.next = B;
       B.next = C_next;

    }

    //Removes the following node of the given node from the list
    //Returns the removed node
    private Node removeFollowing(Node node){

        Node following = node.next;
        if(following == null) throw new IndexOutOfBoundsException();

        node.next = node.next.next;
        return following;
    }

    //Inserts an element at the beginning of the list
    private void insertFirst(Node node){

        //Just insert if list is empty
        if(isEmpty()) {
            HEAD.next = node;
            return;
        }

        //Otherwise, remove and return
        Node temp = HEAD.next;
        HEAD.next = node;
        HEAD.next.next = temp;
    }

    public void search(Item Y){

        Node node = HEAD;
        while(node.next != null){

            if(node.next.data == Y){
                moveNextNodeToFront(node);

            }
            else{
                node = node.next;
            }


        }
    }

    //Moves the node following the given node to the front
    private void moveNextNodeToFront(Node node){
        Node i = removeFollowing(node);
        insertFirst(i);
    }

    public Node removeFirst(){

        if(isEmpty()) throw new NoSuchElementException();

        return removeFollowing(HEAD);

    }

    public void iterativeInversion(){

        if(isEmpty()) return;

        //The initial beginning of the list will be moved toward the end
        //since we remove its following node and insert it to the beginning
        //of the list every iteration.
        Node navette = HEAD.next;
        while(navette.next != null){

            moveNextNodeToFront(navette);

        }

    }

    public void recursiveInversion(){
        if(isEmpty()) return;

        recursiveInversion(HEAD.next);
    }

    private void recursiveInversion(Node navette){

        if(navette.next != null){

            moveNextNodeToFront(navette);
            recursiveInversion(navette);
        }
    }

    //Gives the node at index N
    private Node<Item> getNode(int N){

        //If the list is empty
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node node = HEAD;

        //Try to get the Nth node
        int i = 0;
        while(node.next != null) {

            node = node.next;

            if(i == N){
                return node;
            }

            i++;
        }

        //If we failed to get the Nth node
        throw new NoSuchElementException();

    }

    //Get the value of the Nth node
    public Item get(int N){
        return getNode(N).data;
    }

    //Gives a reference to the last node of the LinkedList.
    private Node lastNode(){

        //Empty list
        if(isEmpty()) throw new NoSuchElementException();

        //Only one node
        Node node = HEAD.next;
        if(node.next == null) return node;

        //More than one node
        for(; node.next != null; node = node.next);

        return node;
    }

    //Tells whether the list is empty.
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
        for(Item item: this){
            str.append("->");
            str.append(item);
        }
        //Note: removes the first useless arrow
        return str.substring(2);
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {

        private Node<Item> current;

        public LinkedListIterator(){
            current = HEAD;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            current = current.next;

            return current.data;
        }
    }
}
