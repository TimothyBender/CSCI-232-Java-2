package com.Bender.Timothy;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MyPanel extends JPanel {
    private static MyPanel inst;
    private BufferedImage image;
    private Graphics2D g2;
    private int[] color = new int[]{0,0,0};

    public static MyPanel getInstance(){
        if(inst == null)
            inst = new MyPanel();
        return inst;
    }

    private MyPanel(){

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) {
            image = (BufferedImage)createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
        }
        g.drawImage(image, 0, 0, null);
    }
    public void draw(int startX, int startY, int endX, int endY, int s){
        g2.setColor(new Color(this.color[0],this.color[1],this.color[2]));
        g2.drawLine(startX,startY,endX,endY);
        try {
            Thread.sleep(250 * s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public void resetPanel(int s){
        try {
            Thread.sleep(200*s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.paintComponent(g2);
        repaint();

    }

    public void setColor(int r, int g, int b){
        color[0] = r;
        color[1] = g;
        color[2] = b;
    }

}
