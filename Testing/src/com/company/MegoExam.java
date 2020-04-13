package com.company;

public class MegoExam {


    public static void main(String[] args){


        String A = "Buckle my shoe. ";
        String B = "Shut the door.";
        System.out.println(A + B);
        String temp = "";
        temp = A;
        A=B;
        B = temp;
        System.out.println(A + B);
    }
}
