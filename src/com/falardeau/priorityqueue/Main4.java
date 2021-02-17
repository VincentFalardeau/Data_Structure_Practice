package com.falardeau.priorityqueue;

import com.falardeau.algorithm.HeapAlgorithms;
import com.falardeau.priorityqueue.PQEagerLinkedList;
import com.falardeau.priorityqueue.PQLazyLinkedList;
import com.falardeau.priorityqueue.PQArray;
import com.falardeau.priorityqueue.PQBinaryHeap;

public class Main4 {

    public static void main(String[] args){

        System.out.println("Lazy Heap List:");
        System.out.println();
        PQLazyLinkedList lazy = new PQLazyLinkedList();
        Integer n1 = 1;
        Integer n2 = 2;
        Integer n3 = 3;
        lazy.insert(n1);
        lazy.insert(n3);
        lazy.insert(n2);
        lazy.insert(n1);
        lazy.insert(n2);
        System.out.println(lazy);
        System.out.println("deleteMin()->"+lazy.deleteMin());
        System.out.println(lazy);
        System.out.println("deleteMin()->"+lazy.deleteMin());
        System.out.println(lazy);
        System.out.println("deleteMin()->"+lazy.deleteMin());
        System.out.println(lazy);
        System.out.println("deleteMin()->"+lazy.deleteMin());
        System.out.println(lazy);
        System.out.println("deleteMin()->"+lazy.deleteMin());
        System.out.println(lazy);
        lazy.insert(n1);
        lazy.insert(n3);
        lazy.insert(n2);
        lazy.insert(n1);
        System.out.println(lazy);

        System.out.println();
        System.out.println("Eager Heap List:");
        System.out.println();
        PQEagerLinkedList eager = new PQEagerLinkedList();
        eager.insert(n1);
        System.out.println(eager);
        eager.insert(n3);
        System.out.println(eager);
        eager.insert(n2);
        System.out.println(eager);
        eager.insert(n1);
        System.out.println(eager);
        eager.insert(n3);
        System.out.println(eager);
        System.out.println("deleteMin()->"+eager.deleteMin());
        System.out.println(eager);
        System.out.println("deleteMin()->"+eager.deleteMin());
        System.out.println(eager);
        System.out.println("deleteMin()->"+eager.deleteMin());
        System.out.println(eager);
        System.out.println("deleteMin()->"+eager.deleteMin());
        System.out.println(eager);
        System.out.println("deleteMin()->"+eager.deleteMin());
        System.out.println(eager);
        System.out.println();

        //pq.1
        PQArray pq1 = new PQArray();
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


        PQBinaryHeap pq2 = new PQBinaryHeap();
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

        //pq.2
        int[] t = {10,16,-7,12,15,10,9,5,6,3,9,5};
        System.out.println("printSmaller(t, 9)");
        HeapAlgorithms.printSmaller(t, 9);

        //pq.3
        PQBinaryList binaryList = new PQBinaryList();
        binaryList.insert(0);
        binaryList.insert(1);
        binaryList.insert(0);
        binaryList.insert(1);
        binaryList.insert(1);
        binaryList.insert(1);
        binaryList.insert(0);
        System.out.println(binaryList);
        System.out.println("Min: " + binaryList.deleteMin());
        System.out.println(binaryList);
        System.out.println("Min: " + binaryList.deleteMin());
        System.out.println(binaryList);
        System.out.println("Min: " + binaryList.deleteMin());
        System.out.println(binaryList);
        System.out.println("Min: " + binaryList.deleteMin());
        System.out.println(binaryList);
        System.out.println("Min: " + binaryList.deleteMin());
        System.out.println(binaryList);
        System.out.println();

        //pq.4
        PQMedian pqMedian = new PQMedian();
        pqMedian.insert(1);
        pqMedian.insert(2);
        pqMedian.insert(3);
        pqMedian.insert(6);
        System.out.println(pqMedian);
        pqMedian.insert(7);
        pqMedian.insert(7);
        pqMedian.insert(7);
        pqMedian.insert(7);
        System.out.println(pqMedian);
        pqMedian.insert(1);
        pqMedian.insert(1);
        pqMedian.insert(1);
        pqMedian.insert(1);
        pqMedian.insert(1);
        System.out.println(pqMedian);


    }
}
