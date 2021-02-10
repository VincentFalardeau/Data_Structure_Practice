package com.falardeau.heap;

public class Main {

    public static void main(String[] args){

        System.out.println("Lazy Heap List:");
        System.out.println();
        LazyPriorityList lazy = new LazyPriorityList();
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
        EagerPriorityList eager = new EagerPriorityList();
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
    }

}
