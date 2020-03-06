package com.company;

public class Encryption {

    //private char[] =

    public Encryption(){

    }

    public String encrypt(String msg, int shift, int shiftTwo, int shiftThree) {

        String newMessage = "";
        String space = " ";
        String punctuation = ",.!?'";

        for(int i = 0; i < msg.length(); i++) {
            if(i % 3 == 0) {
                char c = (char)(msg.charAt(i) + shift);
                if (c > 'z')
                    newMessage += (char)(msg.charAt(i) - (26-shift));
                else
                    newMessage += (char)(msg.charAt(i) + shift);
            }


            if(i % 3 ==1) {
                char c = (char)(msg.charAt(i) + shiftTwo);
                if (c > 'z')
                    newMessage += (char)(msg.charAt(i) - (26-shiftTwo));
                else
                    newMessage += (char)(msg.charAt(i) + shiftTwo);
            }


            if(i % 3 == 2) {
                char c = (char)(msg.charAt(i) + shiftThree);
                if (c > 'z')
                    newMessage += (char)(msg.charAt(i) - (26-shiftThree));
                else
                    newMessage += (char)(msg.charAt(i) + shiftThree);
            }


        }



        return "Encoded Message: " + newMessage;
    }

}
