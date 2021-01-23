package com.falardeau.structures;

import java.util.Stack;

public class DoubleStackQueue {

    Stack E;
    Stack S;

    public DoubleStackQueue() {
        E = new Stack();
        S = new Stack();
    }

    public void enqueue(Object o){

        E.push(o);

    }

    public Object dequeue(){

        int E_size = E.size();

        if(E_size == 0) return null;

        while(E_size > 1){
            S.push(E.pop());
            E_size--;
        }

        Object temp = E.pop();

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
            str1 += E.get(i)+", ";
        }

        String str2 = "<-";

        for(int j = S.size()-1; j >= 0; j--){
            str2 = S.get(j)+ ", " + str2;
        }

        return str2 + str1;
    }


}
