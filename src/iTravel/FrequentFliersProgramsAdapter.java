package iTravel;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FrequentFliersProgramsAdapter {
    Connection connection;

    public FrequentFliersProgramsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                stmt.execute("DROP TABLE FrequentFliersPrograms");
            } catch (SQLException ex) {

            } finally {
                stmt.execute("CREATE TABLE FrequentFliersPrograms ("
                        + "Discount CHAR(15) NOT NULL PRIMARY KEY, "
                        + "FarePaid CHAR(15),"
                        + "NumberOfTimesTravelled CHAR(15),"
                        + "Expired BIT"+ ")");
                System.out.print("FrequentFliersPrograms Tables Created");
                System.out.println();
            }
        }
    }

    public ResultSet getTable() throws SQLException {
        ResultSet rs;
        Statement stmt = connection.createStatement();

        rs = stmt.executeQuery("SELECT * FROM FrequentFliersPrograms");//
        return rs;
    }
    public void setFarePaid(String discount, String farePaid) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE FrequentFliersPrograms SET FarePaid = '" + farePaid + "' WHERE Discount = '" + discount + "'");
    }

    public void setNumberOfTimesTravelled(String discount, String numberOfTimesTravelled) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE FrequentFliersPrograms SET NumberOfTimesTravelled = '" + numberOfTimesTravelled + "' WHERE Discount = '" + discount + "'");
    }

    public void setExpired(String discount, boolean expired) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE FrequentFliersPrograms SET Expired = '" + expired + "' WHERE Discount = '" + discount + "'");
    }
}



