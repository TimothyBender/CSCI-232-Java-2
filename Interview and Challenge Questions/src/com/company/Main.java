package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(zip(new String[]{"AAA","BBBB","CCC"}));
        matrix();
    }
    public static String zip(String[] strings){
        StringBuilder output = new StringBuilder();
        int i = 0,totalspace = 0;
        for (String string : strings) {
            totalspace += string.length();
        }
        do{
            for(String x : strings){
                if(x.length() > i){
                    output.append(x.charAt(i));
                }
            }
            i++;

        }while(i < totalspace);
        return output.toString();
    }

    public static void matrix(){
        int[][] data = new int[][]{{1,2,3,4},{5,2,2,2},{2,1,7,3},{7,9,8,4}};
        printMatrix(data);
        int n = data.length;
        int[][] storage = new int[n][n];
        for(int x = 0;x < n;x++){
            for(int i = 0;i < n; i++){
                storage[i][n-x-1] = data[x][i];
            }
        }
        System.out.println();
        printMatrix(storage);
    }

    public static void printMatrix(int[][] data){
        for(int[] x : data){
            for(int i : x){
                System.out.print(i);
            }
            System.out.println();
        }
    }





}
