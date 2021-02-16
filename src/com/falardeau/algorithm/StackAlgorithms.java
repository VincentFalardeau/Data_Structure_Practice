package com.falardeau.algorithm;


import com.falardeau.structures.ResizingArrayQueue;

import java.util.*;

public class StackAlgorithms {


    //Tells whether a sequence of character is valid or not
    public boolean validSequence(char arr[]){
        final int n = 10;

        //The stack
        Stack<Character> stack = new Stack<>();
        //The character on top of the stack
        Character top = arr[0];

        //Initialize the stack according to the character on top
        Character c = 'A';
        while(c <= top){
            stack.push(c);
            c++;
        }

        //Validate the stack
        for(int i = 1; i < n; i++){
            //The current character of the array
            c = arr[i];

            //Add without condition if the stack is empty
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }

            //Retrieve the top element
            top = stack.peek();

            //In case the top is smaller
            if(top < c){
                //Add c, and everything missing between top and c
                while(top < c){
                    top++;
                    stack.push(top);
                }
                continue;
            }

            //In case the top is greater
            if(top > c){
                //Remove it
                stack.pop();
                //The following element should be c
                top = stack.peek();
                if(top != c){
                    return false;
                }
                continue;
            }

            //If top is c, it is not valid
            return false;
        }


        return true;
    }

    //Reverses a queue
    public ResizingArrayQueue reverse(ResizingArrayQueue queue){

        Object obj = queue.dequeue();

        if(!queue.isEmpty()){
            queue = reverse(queue);

        }
        queue.enqueue(obj);
        return queue;
    }

    //Reverses a stack
    public void reverse(Stack stack){
        if(stack.isEmpty() == false){
            Object top = stack.pop();
            reverse(stack);
            insert_at_bottom(stack, top);
        }
    }

    private void insert_at_bottom(Stack stack, Object element){
        if(stack.isEmpty()){
            stack.push(element);

        }
        else{
            Object top = stack.pop();
            insert_at_bottom(stack, element);
            stack.push(top);
        }
    }

    //Exercice 2.3


    //https://stackoverflow.com/questions/9666903/every-combination-of-character-array
    public Set<String> permute(String chars)
    {
        // Use sets to eliminate semantic duplicates (aab is still aab even if you switch the two 'a's)
        // Switch to HashSet for better performance
        Set<String> set = new TreeSet<String>();

        // Termination condition: only 1 permutation for a string of length 1
        if (chars.length() == 1)
        {
            set.add(chars);
        }
        else
        {
            // Give each character a chance to be the first in the permuted string
            for (int i=0; i<chars.length(); i++)
            {
                // Remove the character at index i from the string
                String pre = chars.substring(0, i);
                String post = chars.substring(i+1);
                String remaining = pre+post;

                // Recurse to find all the permutations of the remaining chars
                for (String permutation : permute(remaining))
                {
                    // Concatenate the first character with the permutations of the remaining chars
                    set.add(chars.charAt(i) + permutation);
                }
            }
        }
        return set;
    }
}
