package com.falardeau.structures.array;

import java.util.Stack;

public class DoubleStackQueue<T> {

    Stack<T> E;
    Stack<T> S;

    public DoubleStackQueue() {
        E = new Stack<T>();
        S = new Stack<T>();
    }

    public void enqueue(T o){

        E.push(o);
    }

    public T dequeue(){

        int E_size = E.size();

        if(E_size == 0) return null;

        while(E_size > 1){
            S.push(E.pop());
            E_size--;
        }

        T temp = E.pop();

        int S_size = S.size();

        while(S_size > 0){
            E.push(S.pop());
            S_size--;
        }

        return temp;


    }

    @Override
    public String toString(){
        String str1 = "->";

        for(int i = 0; i < E.size(); i++){
            str1 += E.get(i) +", ";
        }

        String str2 = "<-";

        for(int j = S.size()-1; j >= 0; j--){
            str2 = S.get(j)+ ", " + str2;
        }

        return str2 + str1;
    }


}
