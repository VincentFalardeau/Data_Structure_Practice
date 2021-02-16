package com.falardeau;

import com.falardeau.structures.LinkedList;

public class Main2 {

    public static void main(String[] args) {
        System.out.println("Exercices sur les listes chainees");
        System.out.println();
        System.out.println();

        System.out.println("L1: Echange d'elements");
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);
        System.out.println("get(0)");
        System.out.println(linkedList.get(0));
        System.out.println("get(1)");
        System.out.println(linkedList.get(1));
        System.out.println("get(2)");
        System.out.println(linkedList.get(2));
        System.out.println(linkedList);
        System.out.println("exchange(0)");
        linkedList.exchange(0);
        System.out.println(linkedList);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        System.out.println(linkedList);
        System.out.println("exchange(3)");
        linkedList.exchange(3);
        System.out.println(linkedList);
        System.out.println();
        linkedList.exchange(3);
        linkedList.exchange(0);

        System.out.println("L2: Inversion de liste");
        System.out.println();
        System.out.println(linkedList);
        System.out.println("Iterative inversion:");
        linkedList.iterativeInversion();
        System.out.println(linkedList);
        System.out.println();
        linkedList.iterativeInversion();
        System.out.println(linkedList);
        System.out.println("Recursive inversion:");
        linkedList.recursiveInversion();
        System.out.println(linkedList);
        linkedList.recursiveInversion();
        System.out.println();

        System.out.println("L3: Concatenation");
        System.out.println();

        System.out.println("L4: Move to front");
        linkedList.add(5);
        System.out.println(linkedList);
        linkedList.search(5);
        System.out.println(linkedList);

        System.out.println();

        for(int i = 11; i > 0; i/=2) System.out.print(i+" ");




    }
}
