package com.falardeau.heap;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LazyPriorityList extends LinkedList {

    //O(1)
    //Inserts as first element
    public void insert(Comparable elem){
        Node x = new Node(elem);
        if(isEmpty()){
            //Is the first node if the list is empty
            HEAD.next = x;
        }
        else{
            //Keep the list here
            Node temp = HEAD.next;
            //The new node becomes the first
            HEAD.next = x;
            //Put back the list after the node
            HEAD.next.next = temp;
        }
    }

    //O(n)
    //Deletes and returns the smallest element
    //Endogene, ce sont les noeuds qui sont bouges et non leurs donnees
    public Comparable deleteMin(){

        //If the list is empty
        if(isEmpty()) return null;

        //The first node
        Node N = HEAD.next;

        //If there only is one element
        if(N.next == null){
            //Delete it and return its value
            Comparable content = N.data;
            HEAD.next = null;
            return content;
        }

        //The parent of the smallest element
        Node minParent = HEAD;

        //The smallest element
        Comparable min = N.data;

        //Iterate through the list
        while(N.next != null){

            //The current node's child data
            Comparable curr = N.next.data;

            //If it is smaller than the current minimum
            if(curr.compareTo(min)<0){

                //It becomes the new minimum
                min = curr;
                //And its parent is the new minParent
                minParent = N;
            }

            N = N.next;
        }
        //Erase minParent's child node, the smallest node
        Node temp = minParent.next.next;
        minParent.next = temp;

        //Return its value
        return min;


    }






}
