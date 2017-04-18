import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Controller class to handle the Anagram functions.
 */
class AnagramController {
    private Scanner shiftChoice = new Scanner(System.in);
    private WriteFile WF = new WriteFile();

    boolean anagramChoices(String text) throws IOException {
        System.out.println(text);
        System.out.println("Is this correct?");
        System.out.println("1 for yes, 2 for no.");
        String in = shiftChoice.next();

        if (Objects.equals(in, "1")) {
            WF.outputFile(text);
            System.out.println(text);
            System.out.println("Check for more?");
            System.out.println("1 for yes, 2 for no.");
            String nextIn = shiftChoice.next();
            if (Objects.equals(nextIn, "1")) {
                return true;
            }
            else if (Objects.equals(nextIn, "2")) {
                return false;
            }
            else {
                System.out.println("Invalid choice.");
            }
            return false;
        }
        else if (Objects.equals(in, "2")) {
            return true;
        }
        else {
            System.out.println("Invalid input. Try again.");
            return true;
        }
    }
}
