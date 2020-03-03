package com.Bender.Timothy;

import javax.swing.*;

@SuppressWarnings(value = "unused")
public class Turtle extends JFrame {
    
    private static Turtle inst;
    private int bearing = 0;
    private int speed = 3;
    private boolean penup = false;
    private double[] location;
    private static String name = "Alex";

    public static Turtle getInstance(int w, int h) {
        if (inst == null)
            inst = new Turtle(w, h);
        return inst;
    }

    private Turtle(int w, int h){
        setTitle("Turtle " + name);

        if(w < 200)
            w = 200;
        if(h < 200)
            h = 200;
        w += 14;
        h += 37;

        setSize(w,h);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        MyPanel mp = MyPanel.getInstance();
        this.getContentPane().add(mp);
        setVisible(true);

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.location = convertPoints(new double[]{0,0});
    }

    public void forward(int r){fd(r);}

    public void fd(int r){
        double[] polar = poleToCart(r);
        double[] toMove = new double[]{polar[0]+location[0],location[1]-polar[1]};
        if(!penup){
            MyPanel.getInstance().draw((int)location[0],(int)location[1],(int)toMove[0],(int)toMove[1],speed);
        }
        location = toMove;
    }

    public void right(int d){
        this.bearing -= d;
        this.bearing = this.bearing % 360; //prevents very large integers. Keeps the angle between 0 - 360
    }

    public void left(int d){
        this.bearing += d;
        this.bearing = this.bearing % 360; //prevents very large integers. Keeps the angle between 0 - 360
    }

    public void penup(){this.penup = true;}

    public void pendown(){this.penup = false;}

    public void home(){
        this.location = convertPoints(new double[]{0,0}); //resets the turtle's location
        this.bearing = 0;   //resets the bearing
    }

    public void goTo(int x, int y){
        double[] toMove = convertPoints(new double[]{x,y});
        if(!penup) {
            MyPanel.getInstance().draw((int)location[0],
                    (int)location[1],(int)toMove[0],(int)toMove[1],speed);
        }
        this.location = toMove;
    }

    public int xcor(){return (int)location[0];}

    public int ycor(){return (int)location[1];}

    public void setHeading(int h){
        if(h < 360 && h >= 0) {
            this.bearing = h;
        }

    }

    public void speed(int x){
        if(x > 5 || x < 0){
            System.out.println("Invalid speed (1-5)");
        }
        else {
            this.speed = x;
        }
    }

    public void pensize(int s) throws InterruptedException {MyPanel.getInstance().lineSize(s);}

    public void clear() throws InterruptedException {
        MyPanel.getInstance().resetPanel(this.speed);
        MyPanel.getInstance();
        Thread.sleep(100);
    }

    public void penColor(int r, int g, int b){
        if(r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0){
            System.out.println("Invalid color");
        }
        else{
            MyPanel.getInstance().setColor(r,g,b);
        }
    }

    public void setName(String n){
        name = n;
    }

    private double[] convertPoints(double[] point){
        return new double[]{point[0] + (MyPanel.getInstance().getWidth() >> 1),
                (MyPanel.getInstance().getHeight() >> 1) - point[1]};
    }

    private double[] poleToCart(int r /*{r,cos(theta){*/){
        return new double[]{(int) (r*Math.cos(Math.toRadians(this.bearing))),
                (int) (r*Math.sin(Math.toRadians(this.bearing)))};
    }

    public String toString(){
        return "Turtle alex";
    }

}
