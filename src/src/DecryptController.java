import java.util.Objects;
import java.util.Scanner;

/**
 * Decrypt controller that calls the command class for executing all methods of
 * decryption. Can easily be expanded to add new types of decryption as well.
 */
class DecryptController {
    private boolean valid = true;

    void decryptChoices(){
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
