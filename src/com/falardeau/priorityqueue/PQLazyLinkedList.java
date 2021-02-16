package com.falardeau.priorityqueue;

import com.falardeau.ta.LinkedListTA;
import com.falardeau.ta.Node;

public class PQLazyLinkedList extends LinkedListTA {

    /**
     * Inserts the given integer at the beginning of the list
     *
     * Algorithm analysis:
     * Considering the number of assignations
     *
     * if n = 0, 1
     * if n > 0, 3
     *
     * Time Complexity: O(1)
     * */
    public void insert(Integer elem){
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

    /**
     * Deletes and returns the smallest element of the list
     *
     * Endogenous: The nodes are moved/deleted, not their data
     *
     * Algorithm Analysis:
     * Considering the number of comparisons.
     *
     * if n = 0, 1
     * if n = 1, 1 + 1
     * if n = 2, 1 + 1 + 1
     * if n = 3, 1 + 1 + 2
     * if n = 4, 1 + 1 + 3
     *
     * if n = n, 1 + 1 + (n-1)
     *
     * Note that in any case, we have to check the first node, and the n-1 following nodes to find the smallest.
     *
     * So for any case: T(n) = n + 1 ~ n
     *
     * Time Complexity : O(n)
     * */
    public Integer deleteMin(){

        //If the list is empty
        if(isEmpty()) return null;

        //The first node
        Node N = HEAD.next;

        //If there only is one element
        if(N.next == null){
            //Delete it and return its value
            Integer content = N.data;
            HEAD.next = null;
            return content;
        }

        //The parent of the smallest element
        Node minParent = HEAD;

        //The smallest element
        Integer min = N.data;

        //Iterate through the list
        while(N.next != null){

            //The current node's child data
            Integer curr = N.next.data;

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
