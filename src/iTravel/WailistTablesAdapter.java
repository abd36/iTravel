package iTravel;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WailistTablesAdapter {
    Connection connection;

    public WailistTablesAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE WailistTables");
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE WailistTables ("
                        + "WaitingNumber INT(15) NOT NULL PRIMARY KEY, "
                        + "PassengerEmail CHAR(150)" + ")");
                System.out.print("WailistTable Tables Created");
                System.out.println();
            }
        }
    }


    public ResultSet getTable() throws SQLException {
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM WailistTables");//
        return rs;
    }

    public void setPassengerEmail(String waitingNumber, String passengerEmail) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE WailistTables SET PassengerEmail = '" + passengerEmail + "' WHERE WaitingNumber = '" + waitingNumber + "'");
    }
}

