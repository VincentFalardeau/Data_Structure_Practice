package com.falardeau.tree;

public class Main6 {

    public static void main(String [] args){

        Tree t = new Tree();

        Node A = new Node(null, 'A');

        Node B = new Node(A, 'B');
        A.left = B;
        Node C = new Node(A, 'C');
        A.right = C;

        Node D = new Node(B, 'D');
        B.left = D;
        Node E = new Node(B, 'E');
        B.right = E;

        Node F = new Node(C, 'F');
        C.right = F;

        t.root = A;

        /**
         *         A
         *       /   \
         *      B      C
         *     / \    / \
         *    D   E  *   F
         *   /\  | \    / \
         *  *  * * *   *  *
         * */

        t.Exposition();

        System.out.println();
        Node res = t.ACBP(E,F);
        if(res != null){
            System.out.println(res.letter);
        }




        //System.out.println(.letter);

    }
}
