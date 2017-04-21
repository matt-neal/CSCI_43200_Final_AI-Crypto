import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;

/**
 * Automate class that attempts to use statistical analysis to output
 * assumed solutions.
 *
 * RETURNS ALL CURRENT STATISTICS IN DATABASE WHEN RAN
 * (entered sample data into DB)
 * (could store these 4 variables for use in decrypt method)
 * MOST COMMONLY USED KEY
 * AVG OF USE KEYS
 * HIGHEST KEY
 * LOWEST KEY
 */

class Automate {
    private DecryptController DC = new DecryptController();
    private DatabaseController DBC = new DatabaseController();
    private AutoController AC = new AutoController();
    private Shift s = new Shift();
    private ReadFile RF = new ReadFile();

    private int highestFrequencyShift(Connection conn) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String queryString = "select shiftkey from [shift] where uses = ( select max(uses) from [shift]);";
            ResultSet rs = statement.executeQuery(queryString);
            rs.next();
            return Integer.parseInt(rs.getString(1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return NULL;
    }

    private int averageShift(Connection conn) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String queryString = "select shiftkey from [shift] where shiftkey = (select SUM(USES)/COUNT(USES) from [shift] WHERE USES != '0');";
            ResultSet rs = statement.executeQuery(queryString);
            rs.next();
            return Integer.parseInt(rs.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NULL;
    }

    private int highestShift(Connection conn) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String queryString = "select shiftkey from [shift] where shiftkey = '25';";
            ResultSet rs = statement.executeQuery(queryString);
            rs.next();
            return Integer.parseInt(rs.getString(1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return NULL;
    }

    private int lowestShift(Connection conn) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String queryString = "select shiftkey from [shift] where shiftkey = '1';";
            ResultSet rs = statement.executeQuery(queryString);
            rs.next();
            return Integer.parseInt(rs.getString(1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return NULL;
}

    private void run() throws IOException {
        try {
            String text = RF.readBlockIn(Charset.defaultCharset());
            Connection conn = DBC.dbConnect();
            int hfKey = highestFrequencyShift(conn);
            int avgKey = averageShift(conn);
            int hKey = highestShift(conn);
            int lKey = lowestShift(conn);
            int[] keys = {hfKey,avgKey,hKey,lKey};
            int i = 0;
            String decrypt = s.automateShift(text, keys[i]);

            while (AC.autoChoices(decrypt, keys[i])) {
                ++i;
                if (i > keys.length) {
                    throw new Exception();
                }
                decrypt = s.automateShift(text, keys[i]);
            }
        }
        catch (Exception e) {
            System.out.println("Automation failed, please proceed manually.");
            s.execute();
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