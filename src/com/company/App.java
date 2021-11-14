package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        String text = "";
        String text2 = "";

        try (
                Scanner input = new Scanner(new File("cipher.txt"));
        ) {

            while (input.hasNext()) {
                text = input.nextLine().toLowerCase();
                text2 = input.nextLine().toLowerCase();

            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, but we couldn't find a file to run this app");
        } catch (InputMismatchException e) {
            System.out.println("Sorry, we could not read a number from the file");
        }



        boolean quit = false;

        // Greeting and entry screen

        while (quit != true) {

            System.out.println("\n\n\n\n                   ----------     ---  The Code Breaker App™  ---     ----------");
            Scanner keyboard = new Scanner(System.in);
            String action = "";
            int method = 0;
            int endChoice = 0;
            boolean sentinel = false;


        while (!(action.equals("e")) && !(action.equals("x"))) {
            System.out.println("\n\n                             Click E to enter    |    Click X to quit              ");


            action = keyboard.nextLine();
            action.toLowerCase();
        }

        if (action.equals("e")) {

            while(sentinel == false){
            while(method != 1 && method != 2) {
                System.out.println("\nPlease enter 1 to view how ciphertext with a key of 3 is cracked");

                System.out.println("\nPlease enter 2 to view how ciphertext without a know key, was cracked using bruteforce");

                method = keyboard.nextInt();


            }


            if(method == 1) {
                System.out.println("This is the answer to the first question : " + decryptionFile.firstQuestion(text));

                while(endChoice != 1 && endChoice!= 2 && endChoice!= 3) {
                    System.out.println("\nPlease enter 1 to return to options");

                    System.out.println("\nPlease enter 2 to return to start");

                    System.out.println("\nPlease enter 3 to quit the application");



                    try{endChoice = keyboard.nextInt();}
                    catch (InputMismatchException e) {
                        System.out.println("Please enter a valid choice");
                        endChoice = 0;
                    }


                }
                if(endChoice == 1)
                {
                    endChoice = 0;
                    method = 0;
                }
                else if(endChoice == 2)
                {
                    sentinel = true;
                }
                else
                {
                    sentinel = true;
                    quit = true;
                }

            }
            else {
                System.out.println("\nThis is the answer to the second question : " + decryptionFile.secondQuestion(text2));

                while(endChoice != 1 && endChoice!= 2 && endChoice!= 3) {
                    System.out.println("\nPlease enter 1 to return to options");

                    System.out.println("\nPlease enter 2 to return to start");

                    System.out.println("\nPlease enter 3 to quit the application");

                    try{endChoice = keyboard.nextInt();}
                    catch (InputMismatchException e) {
                        System.out.println("Please enter a valid choice");
                        endChoice = 0;
                    }

                }
                if(endChoice == 1)
                {
                    endChoice = 0;
                    method = 0;
                }
                else if(endChoice == 2)
                {
                    sentinel = true;
                }
                else
                {
                    sentinel = true;
                    quit = true;
                }

            }
            }

        }
        else
        {
            quit = true;
        }

    }









    }

}
