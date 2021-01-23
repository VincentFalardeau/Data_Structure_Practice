package com.falardeau.tools;

import com.falardeau.structures.IntegerQueue;

import java.util.*;

public class PileAlgorithms {


    //Exercice 2.1
    public boolean impossiblePile(char arr[]){
        final int n = 10;

        Stack<Character> stack = new Stack<Character>();
        Character top = arr[0];//The character on top of the pile
        Character c = 'A';//To hold character temporarily

        //Initialize the pile
        while(c<=top){
            stack.push(c);
            c++;
        }

        //Validate the pile
        for(int i = 1; i < n; i++){
            //System.out.println(Arrays.toString(stack.toArray()));
            c = arr[i];//The current character of the array
            if(stack.size() == 0){
                stack.push(c);
                continue;
            }
            top = stack.peek();//Retrieve the top element



            if(top < c){
                while(top < c){
                    top++;
                    stack.push(top);
                }
                continue;
            }
            else if(top > c){
                stack.pop();
                top = stack.peek();//Retrieve the new top element
                if(top != c){
                    return false;
                }
            }
            else{
                return false;
            }


        }


        return true;



//        Character c1 = 'A';
//        Character c2 = 'B';
//        //c1++;
//        //c1++;
//        return c1 < c2;

        //Fill the pile according to the first element


    }

    //Exercice 2.2 a
    public void reverse(IntegerQueue queue){
        System.out.println(queue);

        queue= reverse_algo(queue);
        System.out.println(queue);

    }

    private IntegerQueue reverse_algo(IntegerQueue queue){

        Integer lastElement = queue.dequeue();

        if(queue.isEmpty()){
            int[] arr = {lastElement};
            return new IntegerQueue(arr);
        }
        queue = reverse_algo(queue);
        queue.enqueue(lastElement);
        return queue;
    }

    //Exercice 2.2 b
    public void reverse(Stack stack){
        System.out.println(stack);
        reverse_algo(stack);
        System.out.println(stack);

    }

    private void reverse_algo(Stack stack){
        if(stack.isEmpty() == false){
            Object top = stack.pop();
            reverse_algo(stack);
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
