/** Anagram
 *  Permutates the strings of characters creating different words
 *  words are searched  within the dictionary.
 *  If the dictionary contains the word, it will be printed.
 */

//import java.awt.*;
import java.io.*;
import java.util.*;

class AnagramHash {
    private ArrayList<String> possibleWords = new ArrayList<>();
    private Dictionary dict;

    // Recursively find permutations of given string of characters.
    private ArrayList<String> permutations(String word) {
        ArrayList<String> list = new ArrayList<>();

        if (word.length() == 1) {
            list.add(word);
            return list;
        }

        for (int i=0; i<word.length(); i++) {
            String shorter = word.substring(0, i) + word.substring(i+1);

            ArrayList<String> sublist = permutations(shorter);

            for (String s : sublist) {
                list.add(word.charAt(i) + s);
            }
        }

        return list;
    }
    //its already returning text and filePath
    public AnagramSolver(String text, String filePath) throws FileNotFoundException {
            dict = new HashDictionary(new File(filePath));
        for (String each : permutations(text)) {
            possibleWords.add(each);
        }
    }

    public String solve() {
        for (String word : possibleWords) {
            System.out.println("Searching for: " + word);
            if (dict.contains(word)) {
                //System.out.println(dict.getAverageLookupTime());
                return word;
            }
        }
        return null;
    }

    public static void execute (String[] args) throws FileNotFoundException {
        WriteFile WF = new WriteFile();

        // Read input text using defined method
        String text = RF.readBlockIn();//(Charset.defaultCharset());
        ReadFile RF = new ReadFile();

        AnagramSolver as = new AnagramSolver(args[0], args[1]);//(String anagram, String pathToFile)
        for (int i=0; i<10; i++) {
            System.out.println("Anagram found: " + as.solve());
            WF.outputFile(as.solve());
        }

        //write to file after choosing correct anagram
        //WF.outputFile(as.solve());
    }
}