package com.company;

public class VendingMachine {

    private double moneyinputed;
    private char input;
    private int input2;
    private final double[][] prices;

    public VendingMachine(){
        this.moneyinputed = 0.0;
        this.input = '~';
        this.input2 = -1;
        this.prices = new double[12][12];
    }

    public void addMoney(double x){
        this.moneyinputed+= x;
    }

    public void input(char c){
        this.input = c;
    }
    public void input2(int x){
        this.input2 = x;
        //if
    }

    private void dispenseItem(int x, int y){

    }
    private void change(int spent){
        //dispense change price- spent
    }
    public void resetMachine(){
        this.moneyinputed = 0.0;
        this.input = '~';
        this.input2 = -1;

    }









}
