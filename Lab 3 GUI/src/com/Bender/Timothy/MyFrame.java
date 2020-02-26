package com.Bender.Timothy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private static MyFrame inst;

    public static MyFrame getInstance(){
        if(inst == null)
            inst = new MyFrame();
        return inst;
    }

    public static void main(String[] args){
        MyFrame.getInstance();
    }

    private MyFrame(){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        MyPanel.getInstance().draw();
    }
}
