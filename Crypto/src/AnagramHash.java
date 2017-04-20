import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/** Anagram
 *  Permutes the strings of characters creating different words
 *  words are searched  within the dictionary.
 *  If the dictionary contains the word, it will be printed.
 */

class AnagramHash {
    private DecryptController DC = new DecryptController();
    private ArrayList<String> possibleWords = new ArrayList<>();
    private HashDictionary dict;

    // Recursively find permutations of given string of characters.
    private ArrayList<String> permutation(String word) {
        ArrayList<String> list = new ArrayList<>();

        if (word.length() == 1) {
            list.add(word);
            return list;
        }

        for (int i = 0; i < word.length(); i++) {
            String shorter = word.substring(0, i) + word.substring(i+1);
            ArrayList<String> sublist = permutation(shorter);
            for (String s : sublist) {
                list.add(word.charAt(i) + s);
            }
        }
        return list;
    }

    private void anagramStart() throws IOException {
        try {
            String text, filePath;
            ReadFile RF = new ReadFile();
            filePath = RF.getFileName();
            dict = new HashDictionary(new File(filePath));

            text = RF.readBlockIn(Charset.defaultCharset());
            possibleWords.addAll(permutation(text));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void solve() throws IOException{
        try {
            anagramStart();
            WriteFile WF = new WriteFile();

            for (String word : possibleWords) {
                System.out.println("Searching for: " + word);
                if (dict.contains(word)) {
                    WF.outputFile(word);
                    System.out.println("Anagram found: " + word);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void execute() throws IOException {
        try {
            this.solve();
            DC.decryptChoices();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}