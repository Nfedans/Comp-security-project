package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class decryptionFile
{
    public static void main(String[] args) throws IOException
    {
        String text = "";
        String text2 = "";


        Scanner input = new Scanner(new File("cipher.txt"));

        while(input.hasNext())
        {
            text = input.nextLine().toLowerCase();
            text2 = input.nextLine().toLowerCase();

        }
        System.out.println("Ciphertext 1 : " + text );
        System.out.println("Ciphertext 2 : " + text2);

        char[] decryption = text.toCharArray();
        System.out.println();
        System.out.println("Cipher text 1 : ");
        System.out.print(decryption);


        System.out.println("\n\nPlain text 1 : ");
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
            System.out.print(cipher);

        }
        char[] decryption2 = text2.toCharArray();
        System.out.println();
        System.out.println();
        System.out.println("\nCipher text 2 : ");
        System.out.println(decryption2);

        System.out.println("\nPlain text 2 : ");
        for(char cipher2: decryption2)
        {
            if(cipher2 =='x' || cipher2=='y' || cipher2 =='z' ||cipher2 =='w' || cipher2=='s' || cipher2 =='t' || cipher2=='v' || cipher2=='u')
            {
                cipher2 -=19;

            }
            else if(cipher2 !=' ')
            {
                cipher2 +=7;
            }
            System.out.print(cipher2);
        }

    }




}
