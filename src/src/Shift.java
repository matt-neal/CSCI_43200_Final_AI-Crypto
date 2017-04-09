import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/** Brute force Caeser shift.
 *  Each shift of cipher will be given an entropy (frequency) amount
 *  one with lowest entropy is assumed to be most similar to English
 *  therefore it is the decrypted message.
 */

class Shift {
    // This method returns entropy for a string containing some english text
    // calculated using frequencies of individual letters.
    private static double getEntropy(String str) {
        double[] freq = {0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228,
                0.02015, 0.06094, 0.06966, 0.00153, 0.00772, 0.04025,
                0.02406, 0.06749, 0.07507, 0.01929, 0.00095, 0.05987,
                0.06327, 0.09056, 0.02758, 0.00978, 0.02360, 0.00150,
                0.01974,0.00074};

        double res = 0;
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if ('a' <= ch && ch <= 'z')
                res += -Math.log(freq[ch - 'a']);
            else if ('A' <= ch && ch <= 'Z')
                res += -Math.log(freq[ch - 'A']);
            // We don't need to do anything for other characters
        }
        return res;
    }

    private void bruteShift() throws IOException {
        ReadFile RF = new ReadFile();
        WriteFile WF = new WriteFile();
        String fileName;
        String filePath;
        Scanner readIn = new Scanner(System.in);

        System.out.println("Please enter file path!");
        filePath = readIn.next();
        // Read input text using defined method
        String text = RF.readBlockIn(filePath, Charset.defaultCharset());

        // This variable stores the value of lowest entropy so far.
        // Initialize with very large value, because all entropies are positive
        // and 0 will be less than all of them.
        double lowestEntropy = Double.MAX_VALUE;

        // A string corresponding to the lowest entropy.
        String lowestEntropyString = "";

        // Try all possible keys
        for (int key = 0; key < 26; ++key) {

            double entropy = getEntropy(text);
            if (entropy < lowestEntropy) {
                lowestEntropy = entropy;
                lowestEntropyString = text;
            }
        }

        // Write output to a file
        System.out.println("Please enter a new file name!");
        fileName = readIn.next();
        WF.outputFile(lowestEntropyString, fileName);
        System.out.println(lowestEntropyString);
    }

    void execute() throws IOException {
        this.bruteShift();
    }
}