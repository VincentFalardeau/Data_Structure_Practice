package com.falardeau;

import com.falardeau.structures.DoubleStackQueue;
import com.falardeau.structures.ResizingArrayQueue;
import com.falardeau.structures.StackQueue;
import com.falardeau.algorithm.StackAlgorithms;
import com.falardeau.algorithm.ArrayAlgorithms;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        System.out.println("Serie d'exercices #1: ");
        System.out.println();
        System.out.println();

        System.out.println("Exercice 1.1: Renverser un tableau");
        System.out.println();
        ArrayAlgorithms tableAlgorithms = new ArrayAlgorithms();
        int tab1[] = {1,2,3,4,5};
        System.out.println(Arrays.toString(tab1));
        tableAlgorithms.reverse(tab1);
        System.out.println(Arrays.toString(tab1));
        System.out.println();

        System.out.println("Exercice 1.2: Maximum local");
        System.out.println();
        int tab2[] = {1,2,3,4,3,5,4,6,5,7};
        System.out.println(Arrays.toString(tab2));
        System.out.print("Les maximums locaux sont: ");
        int max[] = tableAlgorithms.maxLocaux(tab2);
        System.out.println(Arrays.toString(max));
        System.out.println();

        System.out.println("Exercice 1.3: Suppressions");
        System.out.println();
        int tab3[] = {3,3,5,6,7,3,6,3,3,4,3};
        System.out.println("Le tableau T: " + Arrays.toString(tab3));
        int x = 3;
        System.out.println("La valeur x a supprimer: " + x);
        int m = tableAlgorithms.delete(tab3, x);
        System.out.println("Le tableau T apres l'operation: " + Arrays.toString(tab3));
        System.out.println("Le nombre d'elements m restants: " + m);
        System.out.println();

        System.out.println("Exercice 1.4: Decalage circulaire");
        System.out.println();
        int tab4[] = {0,1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(tab4));
        int d = 3;
        System.out.println("Decaler de " + d + " vers la gauche le tableau");
        tableAlgorithms.leftRotate(tab4, d, tab4.length);
        System.out.println(Arrays.toString(tab4));

        System.out.println();
        System.out.println("----------------------------------------------------------");
        System.out.println();

        System.out.println("Serie d'exercices #2: ");
        System.out.println();
        System.out.println();

        System.out.println("Exercice 2.1: Pile impossible");
        System.out.println();
        StackAlgorithms stackAlgorithms = new StackAlgorithms();
        String s0 = "EDCBAHGFIJ";
        System.out.println(s0 + ": " + stackAlgorithms.validSequence(s0.toCharArray()));
        String s1 = "EGIHFDCJAB";
        System.out.println(s1 + ": " + stackAlgorithms.validSequence(s1.toCharArray()));
        String s2 = "CFGHEIJDBA";
        System.out.println(s2 + ": " + stackAlgorithms.validSequence(s2.toCharArray()));
        String s3 = "DCBAEFGHJI";
        System.out.println(s3 + ": " + stackAlgorithms.validSequence(s3.toCharArray()));
        System.out.println();

        System.out.println("Exercice 2.2: Demi-tour");
        System.out.println();
        ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<Integer>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);
        queue = stackAlgorithms.reverse(queue);
        System.out.println(queue);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(Arrays.toString(stack.toArray()));
        stackAlgorithms.reverse(stack);
        System.out.println(Arrays.toString(stack.toArray()));
        System.out.println();

        System.out.println("Exercice 2.3: Couper l'herbe sous le pied");
        System.out.println();
        StackQueue<Integer> stackQueue = new StackQueue();
        System.out.println("enqueue(0)");
        stackQueue.enqueue(0);
        System.out.println("enqueue(1)");
        stackQueue.enqueue(1);
        System.out.println("enqueue(2)");
        stackQueue.enqueue(2);
        System.out.println("enqueue(3)");
        stackQueue.enqueue(3);
        System.out.println(stackQueue);
        System.out.println("dequeue()");
        stackQueue.dequeue();
        System.out.println(stackQueue);
        System.out.println("enqueue(4)");
        stackQueue.enqueue(4);
        System.out.println(stackQueue);
        System.out.println();

        System.out.println("Exercice 2.4: Queue avec gestion de la taille");
        System.out.println();
        Integer tab5[] = {1,2,3,4,5};
        ResizingArrayQueue<Integer> resizingArrayQueue = new ResizingArrayQueue<Integer>();
        System.out.println("enqueue(0)");
        resizingArrayQueue.enqueue(0);
        System.out.println("enqueue(1)");
        resizingArrayQueue.enqueue(1);
        System.out.println("enqueue(2)");
        resizingArrayQueue.enqueue(2);
        System.out.println("enqueue(3)");
        resizingArrayQueue.enqueue(3);
        System.out.println(resizingArrayQueue);
        System.out.println("dequeue()");
        resizingArrayQueue.dequeue();
        System.out.println(resizingArrayQueue);
        System.out.println("enqueue(4)");
        resizingArrayQueue.enqueue(4);
        System.out.println(resizingArrayQueue);
        System.out.println();

        System.out.println("Exercice 2.5: Deux c'est mieux");
        System.out.println();
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
        System.out.println();




    }
}
