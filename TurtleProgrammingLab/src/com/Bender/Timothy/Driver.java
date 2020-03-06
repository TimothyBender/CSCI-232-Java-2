package com.Bender.Timothy;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        Turtle alex = Turtle.getInstance(600,600);
        drawhex(alex,360);
        alex.clear();
        alex.home();
        drawcolorhex(alex);
    }

    public static void drawhex(Turtle alex, int n) throws InterruptedException {
        alex.speed(0);
        int[] extraHex = new int[8];
        for(int x = 0; x < n; x++){
            alex.pensize(x / 100 + 1);
            alex.forward(x);
            alex.left(91);
        }
        Thread.sleep(500);
    }
    public static void drawcolorhex(Turtle alex) throws InterruptedException {
        alex.speed(0);
        int[][] colors = new int[][]{{255,0,0},{128,128,0},{0,0,255},{0,255,0},{255,140,0},{0,255,255}};
        for(int x = 0; x < 360; x++){
            alex.penColor(colors[x % 6][0],colors[x%6][1],colors[x%6][2]);
            alex.pensize(x/100 + 1);
            alex.forward(x);
            alex.left(91);
        }
    }
}
