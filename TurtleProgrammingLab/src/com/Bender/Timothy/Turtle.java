package com.Bender.Timothy;

import javax.swing.*;

public class Turtle extends JFrame {
    private static Turtle inst;
    private int bearing = 0;
    private int width;
    private int height;
    private int speed = 3;
    private boolean penup = false;
    private double[] location;

    public static Turtle getInstance(int w, int h) {
        if (inst == null)
            inst = new Turtle(w, h);
        return inst;
    }
    /*
    TO DO
    Fix polar coordinate system
    fix fd
     */
    private Turtle(int w, int h){
        setTitle("Turtle");
        if(w < 200)
            w = 200;
        if(h < 200)
            h = 200;
        w += 14;
        h += 37;
        setSize(w,h);
        //14, 37
        this.width = w;
        this.height = h;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

    public void right(double d){
        this.bearing -= d;
        if(bearing < 0){
            bearing = 360 - bearing;
        }
    }
    public void left(int d){
        this.bearing += d;
        if(bearing > 360){
            bearing = bearing - 360;
        }
    }

    public void penup(){
        this.penup = true;
    }
    public void pendown(){
        this.penup = false;
    }
    public void home(){
        this.location = convertPoints(new double[]{0,0});
        this.bearing = 0;
    }

    public void goTo(int x, int y){
        double[] toMove = convertPoints(new double[]{x,y});
        if(penup != true) {
            MyPanel.getInstance().draw((int)location[0],(int)location[1],(int)toMove[0],(int)toMove[1],speed);
        }
        this.location = toMove;
    }
    public void forward(int r){
        fd(r);
    }
    public void fd(int r){
        double[] cartPoints = poleToCart(r);
        System.out.println("X: " + cartPoints[0]);
        System.out.println("Y : " + cartPoints[1]);
        if(penup != true){
            MyPanel.getInstance().draw((int)location[0],(int)location[1],(int)cartPoints[0],(int)cartPoints[1],speed);
        }
        location = cartPoints;
    }

    private double[] convertPoints(double[] point){
        double x = point[0] + MyPanel.getInstance().getWidth()/2;
        double y = MyPanel.getInstance().getHeight()/2 - point[1];
        return new double[]{x,y};
    }
    public int xcor(){return (int)location[0];}
    public int ycor(){return (int)location[1];}
    public void setHeading(int h){this.bearing = h;}

    public void speed(int x){
        if(x > 5 || x<1){
            System.out.println("Invalid speed (1-5)");
        }
        else {
            this.speed = x;
        }
    }

    public void clear(){
        MyPanel.getInstance().resetPanel(this.speed);
        MyPanel.getInstance();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private double[] poleToCart(int r /*{r,cos(theta){*/){
        double x = r*Math.cos(Math.toRadians(this.bearing));
        double y = r*Math.sin(Math.toRadians(this.bearing));
        return convertPoints(new double[]{x,y});
    }

    public String toString(){
        return "Turtle alex";
    }

    public void penColor(int r, int g, int b){
        if(r > 250 || r < 0 || g > 250 || g < 0 || b > 250 || b < 0){
            System.out.println("Invalid color");
        }
        else{
            MyPanel.getInstance().setColor(r,g,b);
        }
    }
}
