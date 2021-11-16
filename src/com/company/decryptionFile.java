package com.company;


import java.util.InputMismatchException;
import java.util.Scanner;

public class decryptionFile {

    public static int linearSearch(String[] arr, String key)
    {
        // This method returns the index of a given letter, from alphabet array
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(key)){
                return i;
            }
        }
        return -1;
    }


/*    public static String firstQuestion (String text)
    {
        char[] decryption = text.toCharArray();

        String result = "";
        System.out.println("\n\nQ1 : ");
        for(char cipher: decryption)
        {
            if(cipher =='a' || cipher == 'b' || cipher =='c')
            {
                cipher +=23;

            }
            else if(cipher !=' ')
            {
                cipher -=3;
            }
            result = result + Character.toString(cipher);
        }

        return result;
    }*/

    public static String firstQuestionReDone (String text)
    {
        // reuses code from secondQuestion(), for details, look at secondQuestion()
        char[] decryption = text.toCharArray();
        System.out.println("\n\nQ1 : ");

        String[] Alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        // This algorithm searches from a-z, 23 shift forward = 3 shifts back
        int shift = 23;
        String plainText = "";
        int forwardShift;
        int backwardShift;

        for (int i = 0; i < decryption.length; i++)
        {

            char valAtIndex = decryption[i];
            String indexStringValue = Character.toString(valAtIndex);
            int alphabetArrPosition = linearSearch(Alphabet, indexStringValue);
            forwardShift = shift;
            backwardShift = Alphabet.length - shift;
            String nextLetter = "";

            if(alphabetArrPosition >= backwardShift)
            {
                nextLetter = Alphabet[alphabetArrPosition - backwardShift];
                plainText = plainText + nextLetter;
            }
            else if (valAtIndex != ' ')
            {
                nextLetter = Alphabet[alphabetArrPosition + forwardShift];
                plainText = plainText + nextLetter;
            }
            else
            {
                plainText = plainText + " ";
            }
        }
        String result = "PLAIN TEXT : " + plainText;
        return result;
    }




    public static String secondQuestion (String text2)
    {
        // turns the ciphertext into a character array
        char[] decryption2 = text2.toCharArray();
        System.out.println("\n\nQ2 : ");

        String[] Alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        int counter = 1;
        int shift = 1;
        String plainText2 = "";
        int forwardShift;
        int backwardShift;
        String nextLetter = "";
        String result = "";

        // while loop which closes once the "done" keyword is found, or if the entire alphabet is iterated unsuccessfully
        while( !(plainText2.contains("done")) && counter < 26)
        {
            plainText2 = "";

            // This for loop processes the ciphertext
            for (int i = 0; i < decryption2.length; i++)
            {
                // here we are plucking out a letter from the ciphertext and turning it to a string
                char valAtIndex = decryption2[i];
                String indexStringValue = Character.toString(valAtIndex);

                // here we are finding the index position of the letter in the alphabet array
                int alphabetArrPosition = linearSearch(Alphabet, indexStringValue);

                // forward shift -> A->Z shifting  /  backward shift -> Z->A shifting
                forwardShift = shift;
                backwardShift = (Alphabet.length - 1) - shift;

                // if we're shifting a letter for example 20 times forward, but the letter is z
                // we instead are going to use backwardShift (26 - # of forward shift)
                //to stay within the confines of the alphabet array
                if(alphabetArrPosition >= backwardShift)
                {
                    nextLetter = Alphabet[alphabetArrPosition - backwardShift];
                    plainText2 = plainText2 + nextLetter;
                }
                // if the shifting will not cause a letter to go out of bounds in the alphabet array
                // and it is indeed a letter and not an empty space, it will be shifted A->Z
                else if (valAtIndex != ' ')
                {
                    nextLetter = Alphabet[alphabetArrPosition + (forwardShift + 1)];
                    plainText2 = plainText2 + nextLetter;
                }
                // This leaves blank spaces alone
                else
                {
                    plainText2 = plainText2 + " ";
                }
            }
            shift = shift + 1;
            counter++;
        }

        // if the whole array was iterated unsuccessfully, this error message will return
        if(counter == 26)
        {
            result = "\n\nSorry, we couldn't find what you were looking for :( ";
            return result;
        }
        // This is the successful return message
        else {
             result = "\n\n\nPLAIN TEXT : " + plainText2 +
                    "\nThe Key, if moving from A->Z :  " + counter +
                    "\nThe Key, if moving from Z->A: " + (Alphabet.length - counter) +
                    "\n";
            return result;
        }

    }

    public static int handleMenu ()
    {

        int menuChoice = 0;
        

        while(menuChoice != 1 && menuChoice!= 2 && menuChoice!= 3) {

            printMenuOptions();
            Scanner keyboard = new Scanner(System.in);
            try{menuChoice = keyboard.nextInt();}
            catch (InputMismatchException e) {
                System.out.println();
                keyboard.next();
            }

        }
        return menuChoice;
    }

    public static void printMenuOptions()
    {
        System.out.println("\nPlease enter 1 to return to options");
        System.out.println("Please enter 2 to return to start");
        System.out.println("Please enter 3 to quit the application\n");
    }

    public static void printPlainTextOptions()
    {
            System.out.println("\nPlease enter 1 to view how ciphertext with a key of 3 is cracked");
            System.out.println("Please enter 2 to view how ciphertext without a known key, was cracked using bruteforce\n");
    }

    public static int handlePlainTextOption()
    {
        int decipherChoice = 0;
        Scanner keyboard = new Scanner(System.in);

        while (decipherChoice != 1 && decipherChoice != 2) {
            printPlainTextOptions();
            try {
                decipherChoice = keyboard.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println();
                keyboard.next();
            }
        }
        return decipherChoice;
    }



    }





