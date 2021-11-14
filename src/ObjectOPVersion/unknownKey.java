package ObjectOPVersion;

import static com.company.decryptionFile.linearSearch;

public class unknownKey extends shiftCipher {

    private static int key;

    public unknownKey(String[] Alphabet) {
        super(Alphabet);

        this.key = key;
    }

    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        unknownKey.key = key;
    }

    public String secondQuestion(String text2)
    {
        char[] decryption2 = text2.toCharArray();
        System.out.println("\n\nQ2 : ");


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


                int position = linearSearch(getAlphabet(), x);

                forwardShift = shift;
                backwardShift = (getAlphabet().length - 1) - shift;


                if(position >= backwardShift)
                {
                    String s = getAlphabet()[position - backwardShift];
                    plainText2 = plainText2 + s;
                }
                else if (temp != ' ')
                {
                    String s = getAlphabet()[position + (forwardShift + 1)];
                    plainText2 = plainText2 + s;
                }
                else
                {
                    plainText2 = plainText2 + " ";
                }
            }
            counter++;
            setKey(shift);
        }


        String result = "The shift used in this cipher is positive : " + counter +
                "\nAlternatively, The shift used in this cipher can be interpretted as negative : " + (getAlphabet().length - counter) +
                "\n\nPLAIN TEXT : " + plainText2;

        return result;
    }



}
