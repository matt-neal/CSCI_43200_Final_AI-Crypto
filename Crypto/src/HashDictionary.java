import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.Hashtable;

class HashDictionary {
    // List of words
    private Hashtable<String, String> words = new Hashtable<>();

        HashDictionary (File dict) throws FileNotFoundException {
            try {
                FileReader fr = new FileReader(dict);
                BufferedReader br = new BufferedReader(fr);
                String word;

                // Populate list of words.
                while ((word = br.readLine()) != null) {
                    words.put(word, word);
                }

                br.close();
                fr.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Hash search.
        boolean contains(String word) {
            Enumeration<String> words = this.words.keys();

            while (words.hasMoreElements()) {
                if (word.equals(words.nextElement())) {
                    return true;
                }
            }
            return false;
        }

}
