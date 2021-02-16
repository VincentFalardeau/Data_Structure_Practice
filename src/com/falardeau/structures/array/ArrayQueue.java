package com.falardeau.structures.array;

//Exercice 2.4
public class ArrayQueue {

    private Object arr[];
    private int nelem;//number of element

    public ArrayQueue(){
        arr = new Integer[1];
        nelem = 0;
    }

    public ArrayQueue(int arr[]){
        this.arr = new Integer[1];
        for(int i = 0; i < arr.length; i++){
            this.enqueue(arr[i]);
        }
        nelem = arr.length;
    }

    public void enqueue(Object n){
        if(nelem == arr.length){
            extendArray();
        }
        arr[nelem] = n;
        nelem++;

    }

    public Object dequeue(){
        nelem--;
        return arr[nelem];
    }

    public boolean isEmpty(){
        return arr.length == 0;
    }

    private void extendArray(){

        Object [] newArr = new Integer[arr.length * 2];
        for(int i = 0; i < nelem; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < nelem; i++){
            if(arr[i] != null){
                str+=arr[i]+", ";
            }

        }
        return str;
    }
}
