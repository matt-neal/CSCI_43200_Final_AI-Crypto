import java.util.Objects;
import java.util.Scanner;

/**
 * Decrypt controller that calls the command class for executing all methods of
 * decryption. Can easily be expanded to add new types of decryption as well.
 */
class DecryptController {
    private boolean valid = true;
    private CommandFactory CF = new CommandFactory();

    void decryptChoices(){
        Scanner landingChoice = new Scanner(System.in);

        /*
          while loop that allows the user to attempt to repeat login, rather than
          only having one attempt. Valid is initially true.
          Once the user selects valid inputs, loop exits and functionality moves on.
         */
        while (valid) {
            System.out.println("Choose an option.");
            System.out.println("1 for anagram.");
            System.out.println("2 for shift.");
            System.out.println("3 for automation.");
            System.out.println("4 to quit.");
            String in = landingChoice.next();

            if (Objects.equals(in, "1")) {
                valid = false;
                try {
                    CF.anagram();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (Objects.equals(in, "2")) {
                valid = false;
                try {
                    CF.shift();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (Objects.equals(in, "3")) {
                valid = false;
                try {
                    CF.automate();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (Objects.equals(in, "4")) {
                valid = false;
                try {
                    System.exit(0);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Invalid entry, try again.");
            }
        }
    }
}