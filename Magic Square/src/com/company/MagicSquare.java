package com.company;

import java.util.HashSet;

public class MagicSquare {
    static int[][] test;
    static int[][] magicsquare;
    static HashSet<Integer> used;
    int size,len;
    static boolean done;
    public MagicSquare(int x){
        len = x;
        size = x * x;
        //magicsquare = new int[][]{{2,7,6},
        //                          {9,5,1},
        //                          {4,3,8}};
        magicsquare = new int[len][len];
        used = new HashSet<Integer>();
        done = false;
    }


    /*public void solve2(int pos){
        testMagic();
    }

     */
    public void solve2(int pos) {
        System.out.println("Pos: " + pos);
        int row = pos /3;
        int col = pos %3;
        System.out.println("Row: " + row);
        System.out.println("Col: " +col);
        print();
        for(int i = 1; i < 10; i++){
            if(!used.contains(i)){
                magicsquare[row][col] = i;
                used.add(i);
                if(checkrow(row)){
                    if(pos == 8 && testMagic()){
                        System.out.println("Done!");
                        print();
                        done = true;
                        return;
                    }
                    else{
                        System.out.println("Entering recursion");
                        solve2(pos + 1);
                    }
                }
                magicsquare[row][col] = 0;
                used.remove(i);
            }
            if(done == true){
                return;
            }
        }
    }

    //check a row function
    public boolean checkrow(int row){
        int sum = 0;
        for(int i = 0; i < 3; i++){
            //System.out.println("adding" + magicsquare[row][i]);
            if(magicsquare[row][i] == 0){
                return true;
            }
            sum+=magicsquare[row][i];
        }
        //System.out.println(sum);
        if(sum != 15){
            System.out.println(false);
            return false;
        }
        //System.out.println(true);
        return true;
    }
    //check a col function
    public boolean checkcol(int col){
        int sum = 0;
        for(int[] i : magicsquare){
            //System.out.println("adding " + i[col]);
            sum+= i[col];
        }
        if(sum != 15){
            //System.out.println(false);
            return false;
        }
        //System.out.println(true);
        return true;
    }
    //check diagonal's function
    public boolean checkdiag(){
        int pos = 0,sum = 0;
        for(int[] i : magicsquare){
            sum += i[pos];
            pos++;
        }
        if(sum != 15){
            //System.out.println(false);
            return false;
        }
        pos = 2; sum = 0;
        for(int[] i : magicsquare){
            sum+= i[pos];
            pos--;
        }
        if(sum != 15){
            //System.out.println(false);
            return false;
        }
        //System.out.println(true);
        return true;
    }

    //check everything function;
    public boolean testMagic(){
        for(int i = 0; i <3; i++){
            if(checkrow(i) == false || checkcol(i) == false){
                return false;
            }
        }
        System.out.println(checkdiag());
        return checkdiag();
    }


    public void print() {
        for (int[] i : magicsquare) {
            for (int t : i) {
                System.out.print(t);
            }
            System.out.println();
        }
    }

}
