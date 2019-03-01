package iTravel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import org.apache.derby.iapi.types.SqlXmlUtil;

public class EmployeesAdapter {
    Connection connection;

    public EmployeesAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                // We drop Matches first because it references the table Teams
                stmt.execute("DROP TABLE ActiveEmployees");
                stmt.execute("DROP TABLE DeactivatedEmployees");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of teams
                stmt.execute("CREATE TABLE ActiveEmployees ("
                        + "Id CHAR(15) NOT NULL PRIMARY KEY, "
                        + "Name CHAR(15), "
                        + "Email CHAR(15), "
                        + "Role CHAR(15), "
                        + "Username CHAR(15), "
                        + "Password Char(15)" + ")");
                stmt.execute("CREATE TABLE DeactivatedEmployees ("
                        + "Id CHAR(15) NOT NULL PRIMARY KEY, "
                        + "Name CHAR(15), "
                        + "Email CHAR(15), "
                        + "Role CHAR(15), "
                        + "Username CHAR(15), "
                        + "Password Char(15)" + ")");
                System.out.print("ActiveEmployees and DeactivatedEmployees Tables Created");
                System.out.println();
            }
        }
    }

    public void insertEmployee(String tableName, String id, String name, String email, String role, String username, String password) throws SQLException {
        Statement stmt = connection.createStatement();

        stmt.executeUpdate("INSERT INTO " + tableName + " (Id, Name, Email, Role, Username, Password) VALUES " +
                "('" + id + "'," +
                " '" + name + "'," +
                " '" + email + "'," +
                " '" + role + "'," +
                " '" + username + "'," +
                " '" + password + "')");
    }

    public void removeEmployee(String id) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs;

        rs = stmt.executeQuery("SELECT * FROM ActiveEmployees WHERE Id = '" + id + "'");
        rs.next();

        insertEmployee("DeactivatedEmployees", id, rs.getString("Name"), rs.getString("Email"), rs.getString("Role"), rs.getString("Username"), rs.getString("Password"));
        deleteEmployee(id);
    }

    public void deleteEmployee(String id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM ActiveEmployees WHERE Id = '" + id + "'");
    }

    public ObservableList<String> getIds() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM ActiveEmployees";
        rs = stmt.executeQuery(sqlStatement);

        while (rs.next()) {
            list.add(rs.getString("Id"));
        }
        return list;
    }

    public ResultSet getEmployee(String id) throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM ActiveEmployees WHERE Id = '" + id + "'";
        rs = stmt.executeQuery(sqlStatement);
        rs.next();

        return rs;
    }

}
