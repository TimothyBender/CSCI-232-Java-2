package com.Bender.Timothy;

public class Main {

    public static void main(String[] args) {
	    Second one = new Second(1);
	    Second two;
	    two = new Second(2);
	    Second three = new Second(3);
	    Second four = one.testMethod(one,two,three,new Second(4));
        System.out.println(four == one);
		System.out.println(one.getNum());
		System.out.println(two.getNum());
		System.out.println(three.getNum());
    }
}
