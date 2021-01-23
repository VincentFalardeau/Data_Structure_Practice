package com.falardeau;

import com.falardeau.structures.DoubleStackQueue;
import com.falardeau.structures.IntegerQueue;
import com.falardeau.structures.ArrayQueue;
import com.falardeau.structures.StackQueue;
import com.falardeau.tools.PileAlgorithms;
import com.falardeau.tools.TableAlgorithms;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        TableAlgorithms ta = new TableAlgorithms();
        /*
        int tab[] = {1,2,3,4,3,5,4,6,5,3};

        ta.print(tab);
        ta.reverse(tab);
        ta.print(tab);
        System.out.println();
        ta.print(ta.maxLocaux(tab));
        System.out.println();

        //int tab2[] = {3,3,5,6,7,6,3,3,4,3};
        //int tab2[] = {5,3,3,3,3,3,3,3};
        //int tab2[] = {3,6,4,3,3,3,3,3,3,3,6};
        int tab2[] = {3,6,4,3,3,6};
        //int tab2[] = {3};

        ta.print(tab2);
        int count = ta.delete(tab2,1);
        ta.print(tab2);
        System.out.println(count);
        System.out.println();

        int tab3[] = {0,1,2,3,4,5,6,7,8};
        //ta.shift(tab3, 1);
        //ta.shift(tab3, 2);
        ta.leftRotate(tab3, 3, 9);
        */
        PileAlgorithms pa = new PileAlgorithms();
        /*

        String s0 = "EDCBAHGFIJ";
        System.out.println(pa.impossiblePile(s0.toCharArray()));
        String s1 = "EGIHFDCJAB";
        System.out.println(pa.impossiblePile(s1.toCharArray()));
        String s2 = "CFGHEIJDBA";
        System.out.println(pa.impossiblePile(s2.toCharArray()));
        String s3 = "DCBAEFGHJI";
        System.out.println(pa.impossiblePile(s3.toCharArray()));

        Set<String> strings = pa.permute(s0);
        int i = 0;
        for(String s: strings){
            if(pa.impossiblePile((s.toCharArray()))){
                i++;
            }

        }
        System.out.println(i);

         */
        /*
        int tab3[] = {1,2,3,4,5};
        IntegerQueue iq = new IntegerQueue(tab3);
        //pa.reverse(iq);

        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //pa.reverse(stack);

        StackQueue queue = new StackQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        //System.out.println((Integer)queue.dequeue());
       // System.out.println((Integer)queue.dequeue());
        //System.out.println((Integer)queue.dequeue());

        ArrayQueue qfa = new ArrayQueue(tab3);
        System.out.println(qfa);
        System.out.println(qfa.dequeue());
        System.out.println(qfa);
        */

        DoubleStackQueue doubleStackQueue = new DoubleStackQueue();
        doubleStackQueue.enqueue(1);
        doubleStackQueue.enqueue(2);
        doubleStackQueue.enqueue(3);
        doubleStackQueue.enqueue(4);
        doubleStackQueue.enqueue(5);
        doubleStackQueue.enqueue(6);
        doubleStackQueue.enqueue(7);
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.enqueue(8);
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.enqueue(9);
        System.out.println(doubleStackQueue);

        doubleStackQueue.enqueue(10);
        System.out.println(doubleStackQueue);

        doubleStackQueue.enqueue(11);
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);

        doubleStackQueue.dequeue();
        System.out.println(doubleStackQueue);



    }
}
