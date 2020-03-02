package com.Bender.Timothy;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        Turtle alex = Turtle.getInstance(500,500);
        alex.speed(5);
        alex.pensize(2);

        alex.left(90);
        alex.fd(50);
        alex.right(90);
        alex.penup();
        alex.fd(50);
        alex.right(410);
        alex.pendown();
        alex.penColor(50,168,82);
        alex.fd(100);
        alex.home();
        alex.clear();
        alex.goTo(200,200);
        alex.right(180);
        alex.fd(100);
        alex.penColor(50,72,168);
        alex.goTo(250,250);
    }
}
