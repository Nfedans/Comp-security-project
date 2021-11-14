package com.company;


public class decryptionFile {

    public static int linearSearch(String[] arr, String key){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(key)){
                return i;
            }
        }
        return -1;
    }


    public static String firstQuestion (String text)
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
    }


    public static String secondQuestion (String text2)
    {
        char[] decryption2 = text2.toCharArray();
        System.out.println("\n\nQ2 : ");

        String[] Alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        int counter = 1;
        int shift = 0;
        String plainText2 = "";
        int forwardShift;
        int backwardShift;


        while( !(plainText2.contains("done")) && counter < 25)
        {

            shift++;
            plainText2 = "";

            for (int i = 0; i < decryption2.length; i++)
            {

                char temp = decryption2[i];
                String x = Character.toString(temp);

                int position = linearSearch(Alphabet, x);

                forwardShift = shift;
                backwardShift = (Alphabet.length - 1) - shift;


                if(position >= backwardShift)
                {
                    String s = Alphabet[position - backwardShift];
                    plainText2 = plainText2 + s;
                }
                else if (temp != ' ')
                {
                    String s = Alphabet[position + (forwardShift + 1)];
                    plainText2 = plainText2 + s;
                }
                else
                {
                    plainText2 = plainText2 + " ";
                }
            }
            counter++;
        }


        String result = "The shift used in this cipher is positive : " + counter +
                "\nAlternatively, The shift used in this cipher can be interpretted as negative : " + (Alphabet.length - counter) +
                "\n\nPLAIN TEXT : " + plainText2;

        return result;
    }


}


