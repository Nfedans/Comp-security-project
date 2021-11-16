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

        // get input from external file, using exception handling
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

        // this is the major while loop which houses the menu
        while (quit != true) {


            System.out.println("\n\n\n\n                   ----------     ---  The Code Breaker App™  ---     ----------");
            Scanner keyboard = new Scanner(System.in);
            String appEntry = "";
            int decipherChoice = 0;
            int menuChoice = 0;
            boolean sentinel = false;


        while (!(appEntry.equals("e")) && !(appEntry.equals("x"))) {
            System.out.println("\n\n                             Click E to enter    |    Click X to quit              ");


            appEntry = keyboard.nextLine();
            appEntry.toLowerCase();
        }

        // you will enter here if you choose to enter the app
        if (appEntry.equals("e")) {

                while(sentinel == false){

                    decipherChoice = decryptionFile.handlePlainTextOption();

                    // if you choose to view the answer to the first question you will enter here
                if(decipherChoice == 1)
                {
                        // firstQuestion() houses the algorithm for the known caesar cipher
                        System.out.println("This is the answer to the first question : " + decryptionFile.firstQuestionReDone(text));
                        // handleMenu() handles and does the exception handling for the deepest menu
                        menuChoice = decryptionFile.handleMenu();

                        if(menuChoice == 1)
                        {
                            // will simply give you the 2 options to view the deciphered code
                        }
                        else if(menuChoice == 2)
                        {
                            // will take you back to the start of the app
                            sentinel = true;
                        }
                        else
                        {
                            // will quit the app and end the program
                            sentinel = true;
                            quit = true;
                        }

                }
                // if you choose to view the answer to the second question you will enter here
                else
                {
                        // secondQuestion() houses the algorithm which brute forces the unknown caesar cipher
                        System.out.println("\nThis is the answer to the second question : " + decryptionFile.secondQuestion(text2));
                        menuChoice = decryptionFile.handleMenu();

                        if(menuChoice == 1)
                        {
                        }
                        else if(menuChoice == 2)
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
        // if you choose not to enter at the start, you will be taken here, and out of the menu system.
        else
        {
            quit = true;
        }

    }









    }

}
