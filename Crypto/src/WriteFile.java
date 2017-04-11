import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Class that writes from an input String to a .txt file
 * so to better track correct and incorrect attempts, as
 * well as adding to the dictionary of keywords.
 */
class WriteFile {
    void outputFile(String inputString) throws IOException {
        String fileName;
        Scanner readIn = new Scanner(System.in);
        try {
            System.out.println("Please enter file name!");
            fileName = System.getProperty("user.dir") + "\\" + readIn.next();
            List<String> lines = Collections.singletonList(inputString);
            Path file = Paths.get(fileName);
            Files.write(file, lines, Charset.defaultCharset());
        } catch (Exception e) {
            System.out.println("File Write Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}