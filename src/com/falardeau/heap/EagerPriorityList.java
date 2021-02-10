package com.falardeau.heap;

public class EagerPriorityList extends DoubleLinkedList{

    //O(n) worst case
    //Exogene: ce sont les donnees qui seront decalees et non les noeuds.
    public void insert(Comparable elem){

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
        Comparable data = N.data;

        //Iterate and exchange current data with new data if next is greater
        while(N.next != null && N.next.data.compareTo(data)<0){

            //Exchange next's data with curr's data
            Comparable nextData = N.next.data;
            N.next.data = data;
            N.data = nextData;

            N = N.next;
            data = N.data;
        }

    }

    //O(1)
    //The minimal value is kept at the beginning of the list
    public Comparable deleteMin(){

        if(isEmpty()) return null;

        //Delete first node and return its content
        Comparable content = HEAD.next.data;
        HEAD.next = HEAD.next.next;
        return content;

    }

    public boolean isEmpty(){
        return HEAD.next == null;
    }


}
