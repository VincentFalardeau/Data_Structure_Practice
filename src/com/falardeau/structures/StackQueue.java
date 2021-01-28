package com.falardeau.structures;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackQueue<T> {

    Stack<T> stack;

    public StackQueue(){
        stack = new Stack<T>();
    }

    //Temps constant: O(1)
    public T enqueue(T o){
        return stack.push(o);
    }

    //Cas 1: pile vide -> temps constant: O(1)
    //Cas 2: voir complexite de remove_last_elem_from_stack
    public T dequeue(){
        if(stack.isEmpty()) return null;
        T o = stack.lastElement();
        remove_last_elem_from_stack(stack);
        return o;
    }

    //Temps lineaire: O(n), si la pile a 5 elements, on a 5 iterations
    private void remove_last_elem_from_stack(Stack stack){

        Object top = stack.pop();

        //If top is not the last element
        if(!stack.isEmpty()) {

            //This will make the top element to be pushed before the rest
            remove_last_elem_from_stack(stack);
            stack.push(top);
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
