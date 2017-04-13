import java.io.IOException;
import java.nio.charset.Charset;

/** Brute force Caeser shift.
 *  Each shift of cipher will be given an entropy (frequency) amount
 *  one with lowest entropy is assumed to be most similar to English
 *  therefore it is the decrypted message.
 */

class Shift {

    private String decrypt(String cipherText, int shiftKey)
    {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plainText += replaceVal;
        }
        return plainText;
    }

    private void bruteShift() throws IOException {
        int key = 1;
        String decrypt;
        ReadFile RF = new ReadFile();
        ShiftController SC = new ShiftController();

        // Read input text using defined method
        String text = RF.readBlockIn(Charset.defaultCharset());

        // Initial decrypt attempt
        decrypt = decrypt(text, key);

        // Try all possible keys, allowing the user to verify yes
        // or no on each attempt, then storing/saving the correct
        // or reverting to menu if not.
        while (SC.shiftChoices(decrypt)) {
            ++key;
            decrypt = decrypt(text, key);
        }
    }

    void execute() throws IOException {
        DecryptController DC = new DecryptController();
        this.bruteShift();
        DC.decryptChoices();
    }
}