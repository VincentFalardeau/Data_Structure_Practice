package com.falardeau.ta;

public class Node implements Comparable<Integer>{

    public Integer data;
    public Node next;

    public Node(Integer data){
        this.data = data;
    }

    @Override
    public String toString(){
        return data.toString();
    }
    @Override
    public int compareTo(Integer integer) {
        return 0;
    }
}
