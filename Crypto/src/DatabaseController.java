import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Database controller that creates connection and passes
* that connection to required calls.
*/

/*
 * DB Info
 * IN-CSCI-ASPNET l7642jon lonjones
 */

class DatabaseController {

    Connection dbConnect() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbConn = "jdbc:sqlserver://IN-CSCI-ASPNET";
            String dbID = "lonjones";
            String dbPassword = "l7642jon";
            return DriverManager.getConnection(dbConn,
                    dbID, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
