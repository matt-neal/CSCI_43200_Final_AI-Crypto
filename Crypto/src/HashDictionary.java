/*
 * Created by Loren on 4/11/2017.
 */

//import java.awt.*;
import java.io.*;
import java.util.*;

    public class HashDictionary extends Dictionary {//not sure if Dictionary class is even needed
        File dict = new File("dict.txt");
        Hashtable words = new Hashtable();   // List of words

        public HashDictionary(File dict) throws FileNotFoundException {
            if (!dict.exists()) throw new FileNotFoundException("Error reading: " + dict.getName());
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
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Hash search.
        public boolean contains(String word) {
            Enumeration words = this.words.keys();

            //long time = System.nanoTime();

            while (words.hasMoreElements()) {
                if (word.equals(words.nextElement())) {
                    //avgLookupTime = avgLookupTime * (avgIndex-1)/avgIndex + (System.nanoTime() - time)/avgIndex;
                    //avgIndex++;
                    return true;
                }
            }
            return false;
        }

}
