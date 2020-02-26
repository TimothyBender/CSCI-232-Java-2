package com.Bender.Timothy;
import java.io.*;
import java.util.Arrays;

public class HashTable {
    private String filename;
    private Node[] hashTable;
    private double slotsFilled;
    private double percentFilled;

    HashTable(){
        filename = "Null";
        hashTable = new Node[5];
        slotsFilled = 0.0;
        percentFilled = 0.0;
    }

    public void add(int key, String data){
            if (percentFilled >= .8) {
                this.growTable();
            }
            int position = hash(key);
            if (hashTable[position] == null || hashTable[position].getData().equals(data)) {
                hashTable[position] = new Node(key,data);
                this.slotsFilled++;
                percentFilled = slotsFilled / (double) this.hashTable.length;
            } else {
                position = 0;
                while (position < hashTable.length) {
                    if (hashTable[position] == null || hashTable[position].getData().equals(data)) {
                        hashTable[position] = new Node(key,data);
                        this.slotsFilled++;
                        percentFilled = slotsFilled / (double) this.hashTable.length;
                        break;
                    }
                    position++;
                }
            }
    }

    public String get(int key){
        int position = hash(key);
        if(hashTable[position] != null) {
            if (hashTable[position].getKey() == key) {
                return hashTable[position].getData();
            }
        }
        position = 0;
        while(position != hashTable.length) {
            if (hashTable[position] != null) {
                if (hashTable[position].getKey() == key) {
                    return (hashTable[position].getData());
                    }
                }
                position++;
            }

        return("Key not found");
    }

    public void delete(int key){
        int position = key % hashTable.length;
        if(hashTable[position] != null) {
            if (hashTable[position].getKey() == key) {
                System.out.println("Removed " + hashTable[position]);
                hashTable[position] = null;
                reHashTable();
                return;
            }
        }
        else{
            position = 0;
            while(position != hashTable.length){
                if(hashTable[position] != null) {
                    if (hashTable[position].getKey() == key) {
                        System.out.println("Removed " + hashTable[position] + " at index " + position);
                        hashTable[position] = null;
                        reHashTable();
                        return;
                    }
                    position++;
                }
            }
        }
        System.out.println("Key " + key + " not found");
    }

    public int hash(int key){
        return key % this.hashTable.length;
    }
    public void reHashTable(){
        Node[] storage = hashTable.clone();
        Arrays.fill(hashTable,null);
        this.slotsFilled = 0.0;
        this.percentFilled = 0.0;
        for (Node node : storage) {
            if (node != null)
                this.add(node.getKey(), node.getData());
        }
    }
    public void printTable(){
        for(int x = 0; x<hashTable.length;x++){
            if(hashTable[x] != null)
            System.out.println(x + " " + hashTable[x]);
        }
    }

    public void growTable(){
        Node[] newTable = new Node[this.hashTable.length * 2];
        System.arraycopy(this.hashTable, 0, newTable, 0, this.hashTable.length);
        this.hashTable = newTable.clone();
        this.percentFilled = slotsFilled / (double)hashTable.length;
        this.reHashTable();
    }

    public String[] readFile(String name) throws IOException {
        this.filename = name;
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int fileSize = 0;
        while(reader.readLine() != null){
            fileSize ++;
        }
        reader = new BufferedReader(new FileReader(file));

        String[] fileContent = new String[fileSize];
        int counter = 0;
        String st;
        while((st = reader.readLine()) != null){
            fileContent[counter] = st;
            counter ++;
        }
        return fileContent;
    }
}
