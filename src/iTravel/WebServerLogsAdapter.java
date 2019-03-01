package iTravel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WebServerLogsAdapter {
    Connection connection;

    public WebServerLogsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE WebServerLogs");
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE WebServerLogs ("
                        + "Time CHAR(15) NOT NULL PRIMARY KEY, "
                        + "Data CHAR(150)" + ")");
                System.out.print("WebServerLogs Tables Created");
                System.out.println();
            }
        }
    }


    public ResultSet getTable() throws SQLException {
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM WebServerLogs");//
        return rs;
    }


    public void setData(String time, String data) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE WebServerLogs SET Data = '" + data + "' WHERE Time = '" + time + "'");
    }
}
