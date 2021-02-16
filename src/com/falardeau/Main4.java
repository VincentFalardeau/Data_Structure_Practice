package com.falardeau;

import com.falardeau.priorityqueue.PriorityQueueArray;
import com.falardeau.priorityqueue.PriorityQueueBinaryHeap;

public class Main4 {

    public static void main(String[] args){
        //pq.1
        PriorityQueueArray pq1 = new PriorityQueueArray();
        pq1.insert(1);
        pq1.insert(2);
        pq1.insert(6);
        pq1.insert(5);
        pq1.insert(4);
        pq1.insert(3);
        System.out.println(pq1);
        System.out.println("Size: " + pq1.size());
        System.out.println("Min: " + pq1.deleteMin());
        System.out.println("Size: " + pq1.size());
        System.out.println(pq1);
        System.out.println();

        //pq.2
        PriorityQueueBinaryHeap pq2 = new PriorityQueueBinaryHeap();
        pq2.insert(1);
        pq2.insert(2);
        pq2.insert(6);
        pq2.insert(5);
        pq2.insert(4);
        pq2.insert(3);
        System.out.println(pq2);
        System.out.println("Min: " + pq2.deleteMin());
        System.out.println(pq2);
        System.out.println("Min: " + pq2.deleteMin());
        System.out.println(pq2);
        System.out.println("Min: " + pq2.deleteMin());
        System.out.println(pq2);
        System.out.println("Min: " + pq2.deleteMin());
        System.out.println(pq2);
        System.out.println("Min: " + pq2.deleteMin());
        System.out.println(pq2);
        System.out.println("Min: " + pq2.deleteMin());
        System.out.println(pq2);

    }
}
