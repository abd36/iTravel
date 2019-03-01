package iTravel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAccountsAdapter {
    Connection connection;

    public UserAccountsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE UserAccounts");//
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE UserAccounts ("//
                        + "Username CHAR(15) NOT NULL PRIMARY KEY, "//
                        + "Password CHAR(15), "
                        + "TotalSeatsRes INT, "
                        + "TotalFarePaid DOUBLE"+ ")");//
                System.out.print("UserAccounts Tables Created");//
                System.out.println();
            }
        }
    }


    public ResultSet getFarePaid(String username) throws SQLException {//
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM UserAccounts");//
        return rs;
    }

    public void setSeatsReserved(String username, int seatsRes) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE UserAccounts SET TotalSeatsRes = " + seatsRes + " WHERE Username = '" + username + "'");
    }
}