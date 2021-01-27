package com.falardeau.structures;

import java.util.Stack;

public class StackQueue<T> {

    Stack<T> stack;

    public StackQueue(){
        stack = new Stack<T>();
    }

    //Temps de calcul: O(1)
    public T enqueue(T o){
        return stack.push(o);
    }

    //
    public T dequeue(){
        if(stack.isEmpty()) return null;
        T o = stack.lastElement();
        remove_last_elem_from_stack(stack, 0);
        return o;
    }

    private void remove_last_elem_from_stack(Stack stack, int i){

        if(stack.isEmpty() == false){
            Object top = stack.pop();

            if(stack.isEmpty()) {
                remove_last_elem_from_stack(stack, i + 1);
            }
            else{
                remove_last_elem_from_stack(stack, i + 1);
                stack.push(top);
            }


        }
    }


    @Override
    public String toString(){

        if(stack.size() == 0) return "[]";

        String str = "";

        for(T i: stack){
            str += ", ";
            str += i;
        }
        //Remove the first comma and frame
        str = "[" + str.substring(2) + "]";
        return str;
    }

}
