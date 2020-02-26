package com.Bender.Timothy;

public class Node {

    private int key;
    private String data;

    public Node(int x,String s){
        this.key = x;
        this.data = s;
    }

    public int getKey(){return this.key;}
    public String getData(){return this.data;}

    public String toString(){
        return("Key: " + key + "  " + data);
    }

}

