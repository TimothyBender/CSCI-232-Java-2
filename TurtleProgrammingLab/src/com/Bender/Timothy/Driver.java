package com.Bender.Timothy;

public class Driver {

    public static void main(String[] args) {
        Turtle alex = Turtle.getInstance(500,500);
        alex.speed(5);
        alex.left(90);
        alex.fd(50);
        alex.right(90);
        alex.fd(50);
        alex.right(45);
        alex.fd(100);

    }
}
