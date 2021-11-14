package ObjectOPVersion;

import java.util.Arrays;

public class shiftCipher {

        private String[] Alphabet;
        private String id;



    public shiftCipher(String [] Alphabet)
    {
        this.Alphabet = Alphabet;

    }

    public String[] getAlphabet() {
        return Alphabet;
    }

    public void setAlphabet(String[] alphabet) {
        Alphabet = alphabet;
    }

    @Override
    public String toString() {
        return "shiftCipher{" +
                "Alphabet=" + Arrays.toString(Alphabet) +
                '}';
    }
}
