package com.Bender.Timothy;

/*
* Timothy Bender -02515767
* Outlab 1
* 01/28/2020
* CSCI 232
*/

public class Driver {
@SuppressWarnings("All")
    public static void main(String[] args){
        /*
        Breed: Sheppard, Bulldog, Labrador, Mutt
        Color: Brown, Black, Golden, Mixed
        Name: Distinct
         */

        //Arrays containing the breeds colors and names
        String[] breeds = {"Sheppard","Bulldog","Retriever","Labrador","Sheppard","Retriever","Mutt","Bulldog","Labrador","Sheppard"};
        String[] colors = {"Brown","Brown","Mixed","Golden","Mixed","Black","Brown","Mixed","Black","Golden"};
        String[] names = {"Bodie","Sweetie","Felicity","Sparkles","Tim","Mego","Steven","Matt","Deborah","Mr Peanut"};

        //Create the treeMaster
        //please note there are two ways to begin the tree. You may also pass in a root dog as well.
        // Otherwise the first dog added will become the root.
        TreeMaster treeMaster = new TreeMaster();

        //fill the tree with 10 dogs
        for(int x = 0; x < breeds.length;x++){
            treeMaster.add(new Node(new Dog(breeds[x],colors[x],names[x])),treeMaster.getRoot());
        }

        //print the tree using preorder
        treeMaster.printPreOrder(treeMaster.getRoot());
        System.out.println("");

        //remove a dog we know is in there.
        treeMaster.remove(new Node<>(new Dog("Sheppard","Golden","Mr Peanut")), treeMaster.getRoot(),null);


        //perform all 3 prints. "Mr Peanut" should be removed from above
        treeMaster.printPreOrder(treeMaster.getRoot());
        System.out.println("");
        treeMaster.printInOrder(treeMaster.getRoot());
        System.out.println("");
        treeMaster.printPostOrder(treeMaster.getRoot());

    }
}
