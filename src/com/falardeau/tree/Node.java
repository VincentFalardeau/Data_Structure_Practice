package com.falardeau.tree;

public class Node {

    Node parent;
    Node left, right;
    Character letter;

    public Node(Node parent, Character letter){
        this.parent = parent;
        this.letter = letter;
    }
}
