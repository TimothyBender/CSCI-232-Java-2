package com.Bender.Timothy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Turtle extends JFrame implements ActionListener {
    private static Turtle inst;
    private int bearing = 0;
    private boolean penup = false;
    private double[] location = convertPoints(new double[]{0,0});
    public static Turtle getInstance(){
        if(inst == null)
            inst = new Turtle();
        return inst;
    }

    private Turtle(){
        setTitle("Print Random Lines");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button = new JButton("Click Here!");
        button.addActionListener(this);
        MyPanel mp = MyPanel.getInstance();
        mp.add(button);
        this.getContentPane().add(mp);
        setVisible(true);

    }

    public void right(double d){
        this.bearing -= d;
        if(this.bearing < 0){
            this.bearing = 360 - this.bearing;
        }
    }
    public void left(int d){
        this.bearing += d;
        if(this.bearing >= 360){
            this.bearing = this.bearing - 360;
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
    }

    public void goTo(int x, int y){
        double[] toMove = convertPoints(new double[]{x,y});
        if(penup != true) {

        }
        this.location = convertPoints(new double[]{x,y});
    }

    public double[] convertPoints(double[] point){
        double x = point[0] + this.getSize().width/2;
        double y = point[1] + this.getSize().width/2;
        return new double[]{x,y};
    }

    public double[] poleToCart(double[] point /*{r,cos(theta){*/){
        double x = point[0]*Math.cos(point[1]);
        double y = point[0]*Math.sin(point[1]);
        return new double[]{x,y};
    }

    public String toString(){
        return "Turtle alex";
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MyPanel.getInstance().draw();
    }
}
