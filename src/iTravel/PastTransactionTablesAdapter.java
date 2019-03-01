package iTravel;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PastTransactionTablesAdapter {
    Connection connection;

    public PastTransactionTablesAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE PastTransactionTable");
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE PastTransactionTable ("
                        + "FlightNumber CHAR(15) NOT NULL PRIMARY KEY, "
                        + "FarePaid CHAR(15),"
                        + "DiscountApplied CHAR(15)" + ")");
                System.out.print("PastTransactionTable Tables Created");
                System.out.println();
            }
        }
    }

    public ResultSet getTable() throws SQLException {
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM PastTransactionTable");//
        return rs;
    }

    public void setFarePaid(String flightNumber, String farePaid) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE PastTransactionTable SET FarePaid = '" + farePaid + "' WHERE FlightNumber = '" + flightNumber + "'");
    }


    public void setDiscountApplied(String flightNumber, String discountApplied) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE PastTransactionTable SET DiscountApplied = '" + discountApplied + "' WHERE FlightNumber = '" + flightNumber + "'");
    }
}

