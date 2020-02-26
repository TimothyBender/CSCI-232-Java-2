package com.Bender.Timothy;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class MyPanel extends JPanel {
    private static MyPanel inst;
    private BufferedImage image;
    private Graphics2D g2;

    public static MyPanel getInstance(){
        if(inst == null)
            inst = new MyPanel();
        return inst;
    }

    private MyPanel(){
        setBackground(Color.LIGHT_GRAY);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Inside paint compeonent");
        if (image == null) {
            image = (BufferedImage)createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
        }
        g.drawImage(image, 0, 0, null);
    }
    public void draw(){
        Random rd = new Random();
        int startY = rd.nextInt(getInstance().getHeight());
        int endY = rd.nextInt(getInstance().getWidth());
        g2.setColor(Color.black);
        g2.drawLine(0,startY,500,endY);
        repaint();
    }

}
