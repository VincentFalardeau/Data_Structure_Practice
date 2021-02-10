package com.falardeau.heap;

public class Main {

    public static void main(String[] args){
        LazyHeapList lazy = new LazyHeapList();
        Integer n1 = 1;
        Integer n2 = 2;
        Integer n3 = 3;
        lazy.insert(n1);
        lazy.insert(n3);
        lazy.insert(n2);
        lazy.insert(n1);
        lazy.insert(n2);
        System.out.println(lazy);
        System.out.println(lazy.deleteMin());
        System.out.println(lazy);
    }

}
