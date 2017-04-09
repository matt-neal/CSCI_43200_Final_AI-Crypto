import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * File input class that reads in desired data to be processed by either
 * an encrypter or decrypter. Requires a file name as an input string.
 */
class ReadFile {
    String readBlockIn(String filePath, Charset encoding) throws IOException {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filePath));
            return new String(encoded, encoding);
        }
        catch (Exception e) {
            System.out.println("File Read Exception: " + e.getMessage());
            e.printStackTrace();
            return "Failure.";
        }
    }
}
