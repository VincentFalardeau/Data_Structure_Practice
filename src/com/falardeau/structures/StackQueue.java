package com.falardeau.structures;

import java.util.Stack;

public class StackQueue {

    Stack stack;

    public StackQueue(){
        stack = new Stack();
    }

    public Object enqueue(Object o){
        return stack.push(o);
    }

    public Object dequeue(){
        if(stack.isEmpty()) return null;
        Object o = stack.lastElement();
        remove_last_elem_from_stack(stack, 0);
        return o;
    }

    private void remove_last_elem_from_stack(Stack stack, int i){

        if(stack.isEmpty() == false){
            Object top = stack.pop();
            if(stack.isEmpty()){
                remove_last_elem_from_stack(stack, i + 1);
            }
            else{
                remove_last_elem_from_stack(stack, i + 1);
                stack.push(top);
            }


        }
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < stack.size(); i++){
            str+=stack.get(i)+", ";
        }
        return str;
    }

}
