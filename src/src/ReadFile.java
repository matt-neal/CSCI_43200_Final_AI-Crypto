import java.io.IOException;
import java.io.FileReader;

/**
 * File input class that reads in desired data to be processed by either
 * an encrypter or decrypter. Requires a file name as an input string.
 */
public class ReadFile {
    String path;

    public void readFileIn(String filePath) throws IOException {
        FileReader inputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            int c;

            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
    }

}
