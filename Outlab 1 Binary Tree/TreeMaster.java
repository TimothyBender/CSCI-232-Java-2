package com.Bender.Timothy;

public class TreeMaster<E extends Comparable> {

    private Node<E> root;

    public TreeMaster(E data){
        this.root = new Node<>(data);
    }

    public TreeMaster(){
        this.root = null;
    }



    public void add(Node<E> node,Node<E> localroot){

        if(this.root == null) {             //if the root of the tree is empty, set the root.
            this.root = node;      //used for the overloaded constructor
            return;
        }
        else if(node.getData().compareTo(localroot.getData()) == 0){
            System.out.println("Duplicate entry: " + node.getData());
        }
        else{
            if(node.getData().compareTo(localroot.getData()) < 0){
                if(localroot.getLeft() == null) {
                    localroot.setLeft(node);
                    return;
                }
                else if(localroot.getLeft() != null){
                    add(node, localroot.getLeft());
                }
            }
            else if(node.getData().compareTo(localroot.getData()) > 0){
                if(localroot.getRight() == null){
                    localroot.setRight(node);
                    return;
                }
                else if(localroot.getRight() != null) {
                    add(node, localroot.getRight());
                }
            }

        }

    }

    public void remove(Node<E> node,Node<E> localroot,Node<E> parent){
        if(this.root == null){                      //if the root is null the item is not in the tree
            System.out.println("Tree is empty");
            return;
        }
        if(node.getData().compareTo(localroot.getData()) < 0){      //if compareTo returns -1, go left
            remove(node, localroot.getLeft(),localroot);
        }
        else if(node.getData().compareTo(localroot.getData()) > 0){ //if compareTo return 1 go Right
            remove(node, localroot.getRight(),localroot);
        }
        else{                                       //otherwise we have found our node
            Node<E> deletedReturn = localroot;
            if(localroot.getRight() == null && localroot.getLeft() == null){  //if the localroot has no children, set the
                if(parent.getLeft() == localroot){                            //reference of the parent to be null
                    parent.setLeft(null);
                }
                else{
                    parent.setRight(null);
                }
            }
            //if localroot has only one child, then set the parent to reference the child
            else if((localroot.getLeft() != null && localroot.getRight() == null) ||(localroot.getRight() != null && localroot.getLeft() == null)){
                if(localroot.getRight() != null){ //if the node is on the right, find the side of the parent to replace
                    if(parent.getRight() == localroot){
                        parent.setRight(localroot.getRight());
                    }
                    else{
                        parent.setLeft(localroot.getLeft());
                    }

                }                                   //if the node is on the left, find the side of the parent to replace
                else if(localroot.getLeft() != null){
                    if(parent.getRight() == localroot){
                        parent.setRight(localroot.getLeft());
                    }
                    else{
                        parent.setRight(localroot.getLeft());
                    }
                }
            }
            //end of one child case
            else{  //find the inorder predecessor
                //if the left child has no right child it is the inorder predecessor
                if(localroot.getLeft().getRight() == null){
                    if(parent.getLeft() == localroot){
                        parent.setLeft(localroot.getLeft());
                    }
                    else{
                        parent.setRight(localroot.getLeft());
                    }
                }
                else{ //find the rightmost node in the right subtree of the left child
                    Node<E> dummy = localroot.getLeft();
                    Node<E> dummyParent = localroot;
                    while(dummy.getRight() != null){
                        dummyParent = dummy;
                        dummy = dummy.getRight();
                    }
                    localroot.setData(dummy.getData());
                    dummyParent.setRight(dummyParent.getLeft());
                }

            }

        }

    }
    public void printPreOrder(Node<E> node){
        if(node == null){
            return;
        }
        else{
            System.out.println(node.getData());

            printPreOrder(node.getLeft());

            printPreOrder(node.getRight());
        }


    }
    public void printInOrder(Node<E> node){
        if(node == null){
            return;
        }
        printInOrder(node.getLeft());

        System.out.println(node.getData());

        printInOrder(node.getRight());
    }

    public void printPostOrder(Node<E> node){
        if(node == null){
            return;
        }
        printPostOrder(node.getLeft());

        printPostOrder(node.getRight());

        System.out.println(node.getData());
    }

    public Node<E> getRoot(){
        return this.root;
    }
}
