package com.Bender.Timothy;

public class Second {

    private int aNum;
    private Second next;

    public Second(int a){
        aNum = a;
    }
    public Second testMethod(Second a, Second b, Second c, Second d){
        a = b;
        Second fifth = d;
        d = this;
        b = new Second(99);
        aNum = b.getNum();
        return d;
    }
    public int getNum(){
        return aNum;
    }
}
