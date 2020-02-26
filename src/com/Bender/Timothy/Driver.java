package com.Bender.Timothy;

import java.io.IOException;

public class Driver{

    public static void main(String[] args) throws IOException {
        HashTable ht = new HashTable();
        String[] values = ht.readFile("src/input.txt");
        for(String x:values) {
            ht.add(Integer.parseInt(x.split(" ")[0]), x.split(" ")[1]);
        }
        ht.printTable();
        ht.delete(5032);
        ht.delete(1);
        ht.delete(32055);
        ht.delete(35336);
        ht.delete(123); // Trying to delete an element that is not in the table
        ht.delete(7543);
        ht.delete(6439);
        ht.delete(3530);
        System.out.println();
        ht.printTable();
        System.out.println();
        System.out.println(ht.get(70984));
        System.out.println(ht.get(101));
    }





}
