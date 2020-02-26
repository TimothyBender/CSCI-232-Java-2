package com.Bender.Timothy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCurrentDate extends Thread{

    private int id;
    private boolean flag = true;
    private static Date date = new Date();
    private static DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");

    public MyCurrentDate(int x){
        this.id = x;
    }
    public void run()
    {
        String underscores = "";
            for (int i = 0; i < id+1; i++) {
                underscores += "_________";
            }

        while(this.flag)
        {
            System.out.print(underscores + this.dateFormat.format(date) + "\n");

            try{
                Thread.sleep(300);
            }catch(Exception e){}

        }
    }

    public void setFlag(boolean x){this.flag = x;}
}

