package iTravel;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AircraftsAdapter {
    Connection connection;

    public AircraftsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE Aircrafts");//
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE Aircrafts ("//
                        + "AircraftId CHAR(15) NOT NULL PRIMARY KEY, "//
                        + "Type CHAR(15)" + ")");//
                System.out.print("Aircrafts Tables Created");//
                System.out.println();
            }
        }
    }


    public String getAircraftType(String id) throws SQLException {//
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM Aircrafts WHERE AircraftId = '" + id + "'");//
        return rs.getString("Type");//
    }

    public void setAircraftType(String id, String type) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE Aircrafts SET Type = '" + type + "' WHERE AircraftId = '" + id + "'");
    }
}
