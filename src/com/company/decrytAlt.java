package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class decrytAlt
{
    public static void main(String[] args)throws IOException
    {
        Scanner input= new Scanner (new File("cipher.txt"));
        String text ="";
        String text2 = "";
        char c = ' ';


        while(input.hasNext())
        {
            text = input.nextLine().toLowerCase();
            text2 = input.nextLine().toLowerCase();
        }

        System.out.println(text);
        char[] decrpyt = text.toCharArray();

        for(int i = 0; i<decrpyt.length; i++)
        {
            if(decrpyt[i] == 'a' || decrpyt[i] =='b' || decrpyt[i] =='c')
            {
                decrpyt[i] = (char) (decrpyt[i]+23);

            }
            else if(decrpyt[i]!= ' ')
            {
                decrpyt[i] = (char) (decrpyt[i]-3);
            }



        }

        System.out.print(decrpyt);

        System.out.println("\n");

        System.out.println(text2);
        char[] decrpytion2 = text2.toCharArray();
        for(int i = 0; i<decrpytion2.length; i++)
        {
            if(decrpytion2[i] =='t'|| decrpytion2[i] =='s'|| decrpytion2[i] =='u'|| decrpytion2[i] =='v'  || decrpytion2[i] =='w'|| decrpytion2[i] =='x' || decrpytion2[i] =='y'|| decrpytion2[i] =='z')
            {
                decrpytion2[i] = (char) (decrpytion2[i]-19);
            }
            else if(decrpytion2[i]!= ' ')
            {
              decrpytion2[i] = (char)(decrpytion2[i] + 7);
            }
        }
        System.out.println(decrpytion2);


    }

}
