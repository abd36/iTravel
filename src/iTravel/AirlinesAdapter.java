package iTravel;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AirlinesAdapter {
    Connection connection;

    public AirlinesAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE Airlines");
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE Airlines ("
                        + "AircraftName CHAR(15) NOT NULL PRIMARY KEY, "
                        + "NumberOfAircrafts CHAR(15)" + ")");//
                System.out.print("Airlines Tables Created");//
                System.out.println();
            }
        }
    }


    public ResultSet getTable() throws SQLException {
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM Airlines");//
        return rs;
    }

    public void setNumberOfAircrafts(String name, String NumOfAircrafts) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE Aircrafts SET NumberOfAircrafts = '" + NumOfAircrafts + "' WHERE AircraftName = '" + name + "'");
    }
}
