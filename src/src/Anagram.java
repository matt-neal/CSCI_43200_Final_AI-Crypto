//BRUTE FORCE TRANSPOSITION USING
//4 COLUMN KEY AND RANDOMLY GENERATES
//PERMUTATION OF 1-4 TO CHANGE COLUMN ORDER
//SHOULD CHECK AGAINST DICTIONARY FOR CORRECT PERMUTATION ORDER

//CAN ALSO BE DONE DYNAMICALLY (EXHAUSTIVELY USING DICTIONARY ATTACK)
//BY GUESSING AT KEYWORDS IN THE DICTIONARY TEXT FILE

import java.util.*;
import java.io.*;
import java.lang.*;

class Anagram {
    static String text = new readFile().readFileContents();

    //ARRANGE STRING IN GRID FORMAT
    public static int[] arrangeKey(String key) {
        //arrange position of grid
        //i.e. if key is 4 letter word, rows are four columns long
        //String[] keys = key.split(""); //if using dynamically changing key
        String[] keys = 4;
        Arrays.sort(keys);
        int[] num = new int[key.length()];
        for (int x = 0; x < keys.length; x++) {
            for (int y = 0; y < key.length(); y++) {
                if (keys[x].equals(key.charAt(y) + "")) {
                    num[y] = x;
                    break;
                }
            }
        }

        return num;
    }

    //reorders columns according to key
    public static String decrypt(String key, String text) {
        //key = random permutation of 4
        int[] arrange = arrangeKey(key);
        int lenkey = arrange.length;
        int lentext = text.length();

        int row = (int) Math.ceil((double) lentext / lenkey);

        String regex = "(?<=\\G.{" + row + "})";
        String[] get = text.split(regex);

        char[][] grid = new char[row][lenkey];

        for (int x = 0; x < lenkey; x++) {
            for (int y = 0; y < lenkey; y++) {
                if (arrange[x] == y) {
                    for (int z = 0; z < row; z++) {
                        grid[z][y] = get[arrange[y]].charAt(z);

                        //check against dicitionary for matches
                        //if no match begin loop again
                    }
                }
            }
        }
        String dec = "";
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < lenkey; y++) {
                dec = dec + grid[x][y];
            }
        }

        return dec;
    }

    public static void execute(String[] args) {
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);

        System.out.println(decrypt(key, text));
        break;
    }
}
