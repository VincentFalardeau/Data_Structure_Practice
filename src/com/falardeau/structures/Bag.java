package com.falardeau.structures;

import java.util.Iterator;

public class Bag implements Iterable
{
    private Object[] elements;
    private int nelem; // sac couvre elements[0..nelem-1]
    private static final int CAPACITE_DEFAUT = 1; // capacité par défaut
    public Bag(){this(CAPACITE_DEFAUT);}
    public Bag(int capacite){ elements = new Object[capacite]; nelem=0;}
    public void add(Object o)
    {
        if (nelem == elements.length) reallocation(2*nelem); // doubler
        elements[nelem++] = o;
    }
    private void reallocation(int capacite)
    {
        Object[] T = new Object[capacite]; // nouveau tableau
        for (int i=0; i<nelem; ++i) T[i]=elements[i];
        elements = T; // remplacer l’ancien tableau
    }
    /**
     * @Override
     */
    public Iterator iterator()
    {
        class Iter implements Iterator
        {
            private int pos=0;
            public boolean hasNext(){ return pos<nelem;}
            public Object next(){ return elements[pos++];}
        }
        return new Iter();
    }
}
