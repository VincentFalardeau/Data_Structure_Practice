package com.falardeau.priorityqueue;

import com.falardeau.ta.DoubleLinkedListTA;
import com.falardeau.ta.Node;

public class PQEagerLinkedList extends DoubleLinkedListTA {

    /**
     * Inserts the given element making sure the list is in descending order.
     *
     * Exogenous: Nodes' content change, not the nodes themselves
     *
     * Algorithm Analysis:
     * Considering the number of iterations:
     *
     * if n = 0 -> 0
     * if n = 1
     *      -> Best 0
     *      -> Worst 1
     * if n = 2
     *      -> Best 0
     *      -> Worst 2
     * if n = n
     *      -> Best 0
     *      -> Worst n
     *      -> Average: n/2
     *
     * T(n) = n ~ n (Worst case)
     *
     * So if we insert a smaller element, we will iterate < n times.
     *
     * Time Complexity: O(n)
     * */
    public void insert(Integer elem){

        if(isEmpty()){
            HEAD.next = new Node(elem);
            return;
        }

        //Keep the list here
        Node temp = HEAD.next;
        //Make a new node, for which the next element is the list
        Node N = new Node(elem);
        N.next = temp;
        //Add the new Node at the beginning of the list
        HEAD.next = N;

        N = HEAD.next;
        Integer data = N.data;

        //Iterate and exchange current data with new data if next is greater
        while(N.next != null && N.next.data.compareTo(data)<0){// <- Iteration in the Analysis

            //Exchange next's data with curr's data
            Integer nextData = N.next.data;
            N.next.data = data;
            N.data = nextData;

            N = N.next;
            data = N.data;
        }

    }

    //O(1)
    //The minimal value is kept at the beginning of the list
    public Integer deleteMin(){

        if(isEmpty()) return null;

        //Delete first node and return its content
        Integer content = HEAD.next.data;
        HEAD.next = HEAD.next.next;
        return content;

    }

    public boolean isEmpty(){
        return HEAD.next == null;
    }


}
