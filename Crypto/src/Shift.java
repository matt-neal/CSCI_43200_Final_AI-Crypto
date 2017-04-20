import java.io.IOException;
import java.nio.charset.Charset;

/** Brute force Caeser shift.
 *  Each shift of cipher will be given an entropy (frequency) amount
 *  one with lowest entropy is assumed to be most similar to English
 *  therefore it is the decrypted message.
 */

class Shift {
    private DecryptController DC = new DecryptController();
    private ShiftController SC = new ShiftController();

    private String decrypt(String cipherText, int shiftKey)
    {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        cipherText = cipherText.toLowerCase();
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText.append(replaceVal);
        }
        return plainText.toString();
    }

    private void bruteShift() throws IOException {
        try {
            int key = 1;
            String decoded;
            ReadFile RF = new ReadFile();

            // Read input text using defined method
            String text = RF.readBlockIn(Charset.defaultCharset());

            // Initial decrypt attempt
            decoded = decrypt(text, key);

            // Try all possible keys, allowing the user to verify yes
            // or no on each attempt, then storing/saving the correct
            // or reverting to menu if not.
            while (SC.shiftChoices(decoded)) {
                ++key;
                decoded = decrypt(text, key);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void execute() throws IOException {
        try {
            this.bruteShift();
            DC.decryptChoices();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}