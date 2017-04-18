/* Anagram
 *  Permutates the strings of characters creating different words
 *  words are searched  within the dictionary.
 *  If the dictionary contains the word, it will be printed.
 */

//import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
//import java.nio.charset.Charset;

class AnagramHash {
    private ArrayList<String> possibleWords = new ArrayList<>();
    private Dictionary dict;

    // Recursively find permutations of given string of characters.
    private ArrayList<String> permutation(String word) {
        ArrayList<String> list = new ArrayList<>();

        if (word.length() == 1) {
            list.add(word);
            return list;
        }

        for (int i=0; i<word.length(); i++) {
            String shorter = word.substring(0, i) + word.substring(i+1);

            ArrayList<String> sublist = permutation(shorter);

            for (String s : sublist) {
                list.add(word.charAt(i) + s);
            }
        }

        return list;
    }
    
    //returns text and filePath
    private void anagramSolver(String text, String filePath) throws IOException {
            dict = new HashDictionary(new File(filePath));
            ReadFile RF = new ReadFile();
            text = RF.readBlockIn(Charset.defaultCharset());
        possibleWords.addAll(permutation(text));  //changed this from for loop below
        //for (String each : permutation(text)) {possibleWords.add(each);
        //}
    }

    private String solve() throws IOException{
        //WriteFile WF = new WriteFile();
        anagramSolver(args[0], args[1]);
        for (int i=0; i<10; i++) {
            System.out.println("Anagram found: " + solve());
            //WF.outputFile(as.solve());
        }
        for (String word : possibleWords) {
            System.out.println("Searching for: " + word);
            if (dict.contains(word)) {
                //WF.outputFile(word);
                return word;
            }
        }
        return null;
    }

    private void execute () throws IOException {
        DecryptController DC = new DecryptController();
        this.solve();
        DC.decryptChoices();
    }
}