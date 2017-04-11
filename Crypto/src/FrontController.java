import java.util.Objects;
import java.util.Scanner;

/**
 * Front Controller to manage functionality and give the user options.
 * Designed so that if any additional functionality is added at a later date,
 * Refactoring is not particularly necessary.
 */
class FrontController {
    private boolean valid = true;
    private DecryptController DC = new DecryptController();

    void landingPage() {
        Scanner landingChoice = new Scanner(System.in);

        /*
          while loop that allows the user to attempt to repeat login, rather than
          only having one attempt. Valid is initially true.
          Once the user selects valid inputs, loop exits and functionality moves on.
         */
        while (valid) {
            System.out.println("Choose an option.");
            System.out.println("1 for decryption.");
            String in = landingChoice.next();

            if (Objects.equals(in, "1")) {
                valid = false;
                DC.decryptChoices();
            }
            else {
                System.out.println("Invalid entry, try again.");
            }
        }
    }
}