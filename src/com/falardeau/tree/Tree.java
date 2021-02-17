package com.falardeau.tree;

import java.util.*;

public class Tree {

    /**
     * a.1.a
     * L'exposition d'un noeud "u" est la plus courte distance reliant
     * ce noeud a un noeud externe dans le sous arbre "du".
     * Note: les noeuds externes sont denotes par null.
     *
     * Donc par exemple
     *              A
     *             / \
     *            u   B
     *           / \
     *          c1 c2
     *
     * Ici, le sous-arbre "du" est
     *            u
     *           / \
     *          c1 c2
     *
     * Voici maintenant la definition recursive de cela:
     *
     * E(x) = 0                                 si x est externe
     * E(x) = 1 + min{E(x.left), E(x.right)}    sinon
     * */



    Node root;

    /**
     * a.1.b
     * Affiche l'exposition de chaque noeud en effectuant un parcours postfixe de l'arbre
     * */
    public void Exposition(){
        Exposition(root);
    }

    private int Exposition(Node N){

        //Cas de base: un noeud externe a une exposition de 0
        if(N == null){
            return 0;
        }
        else{
            int exposition = 1 + Math.min(Exposition(N.left), Exposition(N.right));
            System.out.println(N.letter + ": " + exposition);

            return exposition;
        }

    }

    //Ancetre Commun le Plus Bas
    public Node ACBP(Node N1, Node N2){

        if(N1 == null || N2 == null) return null;

        //List of the ancestors of N1
        ArrayList<Node> A1 = new ArrayList<>();

        //Put all the ancestors of N1 into the list
        A1.add(N1);
        while(N1.parent != null){
            N1 = N1.parent;
            A1.add(N1);
        }

        //List of the ancestors of N2
        ArrayList<Node> A2 = new ArrayList<>();

        //Put all the ancestors of N2 into the list
        A2.add(N2);
        while(N2.parent != null){
            N2 = N2.parent;
            A2.add(N2);
        }

        //Find the first common element in the 2 lists
        for(Node N: A1){
            if(A2.contains(N)){
                return N;
            }
        }
        return null;


    }
}
