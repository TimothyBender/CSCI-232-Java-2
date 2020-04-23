package com.company;

import java.util.HashSet;

public class MagicSquare {

    private static int[][] magicSquare;
    private static HashSet<Integer> used;
    private int size,len,SUM;
    private static boolean done;

    public MagicSquare(int size){
        switch (size){
            case 3:
                this.SUM = 15;
                break;
            case 5:
                this.SUM = 65;
        }
        this.len = size;
        this.size = size * size;
        magicSquare = new int[len][len];
        used = new HashSet<>();
        done = false;
        System.out.println("Finding magic square for a "+ len +"x" +len + " magic square...");
    }

    //overloaded so you don't need a starting position...
    public void solve(){solve(0);}
    public void solve(int pos) {
        int row = pos /len, col = pos %len;
        for(int i = 1; i < size+1; i++){
            if(!used.contains(i)){
                magicSquare[row][col] = i;
                used.add(i);
                if(checkRow(row)){
                    if(pos == size-1 && testMagic()){
                        System.out.println("Done!");
                        print();
                        done = true;
                        return;
                    }
                    else{
                        solve(pos + 1);
                    }
                }
                magicSquare[row][col] = 0;
                used.remove(i);
            }
            if(done){
                return;
            }
        }
    }

    //check a row function
    private boolean checkRow(int row){
        int sum = 0;
        for(int i = 0; i < len; i++){
            if(magicSquare[row][i] == 0){
                return true;
            }
            sum+=magicSquare[row][i];
        }
        return sum == this.SUM;
    }
    //check a col function
    private boolean checkCol(int col){
        int sum = 0;
        for(int[] i : magicSquare){
            sum+= i[col];
        }
        return sum == this.SUM;
    }

    //check both diagonals
    private boolean checkDiag(){
        int pos = 0,sum = 0;
        for(int[] i : magicSquare){
            sum += i[pos];
            pos++;
        }
        if(sum != this.SUM){
            return false;
        }
        pos = 2; sum = 0;
        for(int[] i : magicSquare){
            sum+= i[pos];
            pos--;
        }
        return sum == this.SUM;
    }

    //check everything function;
    private boolean testMagic(){
        for(int i = 0; i <len; i++){
            if(!checkRow(i) || !checkCol(i)){
                return false;
            }
        }
        return checkDiag();
    }
    //print the solution.
    private void print() {
        for (int[] i : magicSquare) {
            for (int t : i) {
                System.out.print(t);
            }
            System.out.println();
        }
    }
}
