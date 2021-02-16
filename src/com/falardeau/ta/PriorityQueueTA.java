package com.falardeau.ta;

/**
 * Priority Queue Abstract Type
 * */
public abstract class PriorityQueueTA<T> implements Iterable<T>{

    /**
     * Inserts t in the queue
     * @param t, the object to insert
     * */
    public abstract void insert(T t);

    /**
     * Deletes the minimal value and returns it
     * @return the queue's minimal value object
     * */
    public abstract T deleteMin();

    /**
     * Gives the number of element in the queue
     * @return the queue's size
     * */
    public abstract int size();
}
