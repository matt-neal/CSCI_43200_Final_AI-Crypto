import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**BRUTE FORCE TRANSPOSITION USING
 * 4 COLUMN KEY AND RANDOMLY GENERATES
 * PERMUTATION OF 1-4 TO CHANGE COLUMN ORDER
 * SHOULD CHECK AGAINST DICTIONARY FOR CORRECT PERMUTATION ORDER

 * CAN ALSO BE DONE DYNAMICALLY (EXHAUSTIVELY USING DICTIONARY ATTACK)
 * BY GUESSING AT KEYWORDS IN THE DICTIONARY TEXT FILE
 */

class Anagram {
    //ARRANGE STRING IN GRID FORMAT
    private int[] arrangeKey(String key) {
        //arrange position of grid
        //i.e. if key is 4 letter word, rows are four columns long
        //String[] keys = key.split(""); //if using dynamically changing key
        String [] keys = new String[4];
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
    private String decrypt(String key) throws IOException{
        ReadFile RF = new ReadFile();
        WriteFile WF = new WriteFile();

        // Read input text using defined method
        String text = RF.readBlockIn(Charset.defaultCharset());

        //key = random permutation of 4
        int[] arrange = arrangeKey(key);
        int lenkey = arrange.length;
        int lentext = text.length();

        int row = (int) Math.ceil((double) lentext / lenkey);

        String regex = "(?<=\\G.{" + row + "})";
        String[] get = text.split(regex);

        char[][] grid = new char[row][lenkey];

        for (int anArrange : arrange) {
            for (int y = 0; y < lenkey; y++) {
                if (anArrange == y) {
                    for (int z = 0; z < row; z++) {
                        grid[z][y] = get[arrange[y]].charAt(z);

                        //check against dictionary for matches
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

    void execute(String key) throws IOException {
        this.decrypt(key);
    }
}
//    String line = System.getProperty("line.separator");
//        scan.useDelimiter(line);
//
//                System.out.println(decrypt(key, text));