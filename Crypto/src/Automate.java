import java.io.IOException;
import java.util.Scanner;

/**
 * Automate class that attempts to use statistical analysis to output
 * assumed solutions.
 */
class Automate {
    private DecryptController DC = new DecryptController();

    private void run() throws IOException {
        try {
            Shift s = new Shift();
            int key;

            /*
            * This block of code to be replaced by database call for
            * Most common, then average, then high, then low.
             */
            Scanner keyScan = new Scanner(System.in);
            key = Integer.parseInt(keyScan.next());

            s.automateShift(key);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void execute() throws IOException {
        try {
            this.run();
            DC.decryptChoices();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
