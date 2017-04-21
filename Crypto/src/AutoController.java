import java.io.IOException;
import java.sql.Connection;
import java.util.Objects;
import java.util.Scanner;

/**
 * Controller class to handle the automate Shift function.
 */
class AutoController {
    private Scanner shiftChoice = new Scanner(System.in);
    private WriteFile WF = new WriteFile();
    private StoreData SD = new StoreData();
    private DatabaseController DBC = new DatabaseController();

    boolean autoChoices(String text, int key) throws IOException {

        System.out.println(text);
        try {
            System.out.println(text);
            System.out.println("Is this correct?");
            System.out.println("1 for yes, 2 for no.");
            String in = shiftChoice.next();
            Connection conn = DBC.dbConnect();

            if (Objects.equals(in, "1")) {
                WF.outputFile(text);
                SD.databaseUpdateShift(conn, key);
                return false;
            }
            else if (Objects.equals(in, "2")) {
                return true;
            }
            else {
                System.out.println("Invalid input. Try again.");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}