package iTravel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmailsAdapter {
    Connection connection;

    public EmailsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE Emails");//
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE Emails ("//
                        + "Username CHAR(15) NOT NULL PRIMARY KEY, "
                        + "From CHAR(15)"
                        + "To CHAR(15)"//
                        + "Role CHAR(15)" + ")");//
                System.out.print("Emails Tables Created");//
                System.out.println();
            }
        }
    }

    public String getRole(String username) throws SQLException {//
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM Emails WHERE Username = '" + username + "'");//
        return rs.getString("Role");//
    }

    public void setRole(String username, String role) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE Emails SET Role = '" + role + "' WHERE Username = '" + username + "'");
    }
}
