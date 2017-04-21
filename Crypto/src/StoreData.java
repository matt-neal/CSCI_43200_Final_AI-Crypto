import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class that handles updates/inserts to
 * database as necessary for Automate.
 */
class StoreData {

    void databaseUpdateShift(Connection conn, int shiftKey) throws SQLException{
        try {
            Statement statement = conn.createStatement();
            String queryString = "update [shift] set uses = uses + 1 where shiftkey = '" + shiftKey + "';";
            statement.executeUpdate(queryString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
