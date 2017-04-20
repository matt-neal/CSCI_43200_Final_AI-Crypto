import java.util.Objects;
import java.util.Scanner;

/**
 * Encrypt controller that calls the command class for executing all methods of
 * Encryption. Can easily be expanded to add new types of Encryption as well.
 */
class EncryptController {
    private boolean valid = true;
    private CommandFactory CF = new CommandFactory();

    void EncryptChoices(){
        Scanner landingChoice = new Scanner(System.in);

        /*
          while loop that allows the user to attempt to repeat login, rather than
          only having one attempt. Valid is initially true.
          Once the user selects valid inputs, loop exits and functionality moves on.
         */
        while (valid) {
            System.out.println("Choose an option.");
            System.out.println("1 for shift.");
            System.out.println("2 to quit.");
            String in = landingChoice.next();

            if (Objects.equals(in, "1")) {
                valid = false;
                try {
                    CF.shift();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if (Objects.equals(in, "2")) {
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