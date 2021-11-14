package ObjectOPVersion;

import ObjectOPVersion.shiftCipher;

import static com.company.decryptionFile.linearSearch;

public class knownKey extends shiftCipher {

    private static int key;

    public knownKey(String[] Alphabet) {
        super(Alphabet);

        this.key = key;
    }

    public String firstQuestion(String text)
    {
        char[] decryption = text.toCharArray();

        String result = "";
        System.out.println("\n\nQ1 : ");

        String plainText2 = "";
        int forwardShift;
        int backwardShift;

        for (int i = 0; i < decryption.length; i++)
        {

            char temp = decryption[i];
            String x = Character.toString(temp);


            int position = linearSearch(getAlphabet(), x);

            forwardShift = key;
            backwardShift = (getAlphabet().length - 1) - key;


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
        System.out.println("The result is: " + plainText2);

        return result;
    }

}
