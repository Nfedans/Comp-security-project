package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
	Scanner input = new Scanner(new File("ciphertext.txt"));

        String text = "";

    while(input.hasNext())
    {
        text = input.nextLine().toLowerCase();
    }
        System.out.println(text);
        char[] cipher = text.toCharArray();


        for(char c: cipher)
        {
            if(c =='a' || c=='b' || c=='c')
            {
                c += 23;
            }
            else if(c!=' ')
            {
                c -= 3;
            }

            System.out.print(c);


        }


    }
}
