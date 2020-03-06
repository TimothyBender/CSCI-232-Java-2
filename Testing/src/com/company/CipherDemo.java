package com.company;

import java.util.Scanner;

public class CipherDemo {

    public static void main(String[] args) {

        int keyWhole;
        String input;

        Scanner cipherKey = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
        Scanner message = new Scanner(System.in);
        Encryption encryptedMessage = new Encryption();

        System.out.print("Enter a 3-digit number: ");
        keyWhole = cipherKey.nextInt();

        int keyOne = keyWhole / 100;
        int keyTwo = (keyWhole / 10) % 10;
        int keyThree = keyWhole % 10;

        System.out.println("Your key is: " + keyOne + "-" + keyTwo +"-" + keyThree);

        System.out.print("E or 1 for encrypt, D or 2 for decrypt: ");

        input = choice.next();


        if (input.equals("E") || input.equals("e") || input.equals("1")) {
            System.out.println("Enter message to Encrypt: ");
            input = message.nextLine();
        }

        else if (input.equals("D") || input.equals("d") || input.equals("2")) {
            System.out.println("Enter message to Decrypt: ");
            input = message.nextLine();
        }

        else {

            while(true) { System.out.println("Please enter a valid input.");
                input = choice.next();

                if (input.equals("E") || input.equals("e") || input.equals("1")) {
                    System.out.println("Enter message to Encrypt: ");
                    input = message.nextLine();
                    break;
                }

                if (input.equals("D") || input.equals("d") || input.equals("2")) {
                    System.out.println("Enter message to Decrypt: ");
                    input = message.nextLine();
                    break;
                }

            }
        }



        //System.out.println("Your message is : " + input);

        System.out.println(encryptedMessage.encrypt(input, keyOne, keyTwo, keyThree));




        cipherKey.close();
        choice.close();
        message.close();


    }

}

