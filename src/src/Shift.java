//BRUTE FORCE CAESAR SHIFT
//EACH SHIFT OF CIPHER WILL BE GIVEN AN ENTROPY (FREQUENCY) AMOUNT
//ONE WITH LOWEST ENTROPY IS ASSUMED TO BE MOST SIMILAR TO ENGLISH
//THEREFORE IT IS THE DECRYPTED MESSAGE

import ReadFile;
import java.util.Scanner;
import java.io.*;

public class Shift {
    // Method that reads all text from a file with the given name
    static String input = new readFile().readFileContents();
    String res = "";
        while (input.hasNextLine()) {
        res += input.nextLine();
    }
        return res;

    // This method returns entropy for a string containing some english text
    // calculated using frequencies of individual letters.
    public static double getEntropy(String str) {
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

    public static void execute(String[] args){

        // Read input text using defined method
        String text = readTextFromFile(args[0]);

        // This variable stores the value of lowest entropy so far.
        // Initialize with very large value, because all entropies are positive
        // and 0 will be less than all of them.
        double lowestEntropy = Double.MAX_VALUE;
        // A string corresponding to the lowest entropy.
        String lowestEntropyString = "";

        // Try all possible keys
        for (int key = 0; key < 26; ++key) {
            // We pass -key, because our method shifts characters to the right,
            // so we pass negative value to make it shift to the left.
            String decodedText = encodeCaesar(text, -key);
            double entropy = getEntropy(decodedText);
            if (entropy < lowestEntropy) {
                lowestEntropy = entropy;
                lowestEntropyString = decodedText;
            }
        }

        // Write output to a file
        System.out.println(lowestEntropyString);
        File outputFile = new File(args[1]);
        BufferedWriter outputWriter =
                new BufferedWriter(new FileWriter(outputFile.getAbsoluteFile()));
        outputWriter.write(lowestEntropyString);
        outputWriter.close();
    }
}
