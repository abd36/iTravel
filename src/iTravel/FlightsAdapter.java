package iTravel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightsAdapter {
    Connection connection;

    public FlightsAdapter(Connection conn, Boolean reset) throws SQLException {
        connection = conn;

        if (reset) {
            Statement stmt = connection.createStatement();

            try {
                // Remove tables if database tables have been created.
                // This will throw an exception if the tables do not exist
                // We drop Matches first because it references the table Teams
                stmt.execute("DROP TABLE ActiveFlights");
                stmt.execute("DROP TABLE DeactivatedFlights");
                // then do finally
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
                // do finally to create it
            } finally {
                // Create the table of teams
                stmt.execute("CREATE TABLE ActiveFlights ("
                        + "FlightNumber CHAR(15) NOT NULL PRIMARY KEY, "
                        + "Origin CHAR(15), "
                        + "Destination CHAR(15), "
                        + "AircraftType CHAR(15), "
                        + "NumberOfBusinessSeats INT, "
                        + "AvailableBusinessSeats INT, "
                        + "NumberOfExecutiveSeats INT, "
                        + "AvailableExecutiveSeats INT, "
                        + "PriceOfBusinessSeat INT, "
                        + "PriceOfExecutiveSeat INT, "
                        + "RevenueGenerated DOUBLE, "
                        + "Status CHAR(15)" + ")");
                stmt.execute("CREATE TABLE DeactivatedFlights ("
                        + "FlightNumber CHAR(15) NOT NULL PRIMARY KEY, "
                        + "Origin CHAR(15), "
                        + "Destination CHAR(15), "
                        + "AircraftType CHAR(15), "
                        + "NumberOfBusinessSeats INT, "
                        + "AvailableBusinessSeats INT, "
                        + "NumberOfExecutiveSeats INT, "
                        + "AvailableExecutiveSeats INT, "
                        + "PriceOfBusinessSeat INT, "
                        + "PriceOfExecutiveSeat INT, "
                        + "RevenueGenerated DOUBLE, "
                        + "Status CHAR(15)" + ")");
                System.out.print("ActiveFlights and DeactivatedFlights Tables Created");
                System.out.println();
            }
        }
    }

    public void insertFlight(String tableName, String flightNumber, String origin, String destination, String aircraftType, String numberOfBusinessSeats, String availableBusinessSeats, String numberOfExecutiveSeats, String availableExecutiveSeats, String priceOfBusinessSeat, String priceOfExecutiveSeat, String revenueGenerated, String status) throws SQLException {
        Statement stmt = connection.createStatement();

        stmt.executeUpdate("INSERT INTO " + tableName + " (FlightNumber, Origin, Destination, AircraftType, NumberOfBusinessSeats, AvailableBusinessSeats, NumberOfExecutiveSeats, AvailableExecutiveSeats, PriceOfBusinessSeat, PriceOfExecutiveSeat, RevenueGenerated, Status) VALUES " +
                "('" + flightNumber + "'," +
                " '" + origin + "'," +
                " '" + destination + "'," +
                " '" + aircraftType + "'," +
                " " + numberOfBusinessSeats + "," +
                " " + availableBusinessSeats + "," +
                " " + numberOfExecutiveSeats + "," +
                " " + availableExecutiveSeats + "," +
                " " + priceOfBusinessSeat + "," +
                " " + priceOfExecutiveSeat + ", " +
                " " + revenueGenerated +", " +
                " '" + status + "')");
    }

    public void removeFlight(String flightNumber) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs;

        rs = stmt.executeQuery("SELECT * FROM ActiveFlights WHERE FlightNumber = '" + flightNumber + "'");
        rs.next();

        insertFlight("DeactivatedFlights", flightNumber, rs.getString("Origin"), rs.getString("Destination"), rs.getString("AircraftType"), rs.getString("NumberOfBusinessSeats"), rs.getString("AvailableBusinessSeats"), rs.getString("NumberOfExecutiveSeats"), rs.getString("AvailableExecutiveSeats"), rs.getString("PriceOfBusinessSeat"), rs.getString("PriceOfExecutiveSeat"), rs.getString("RevenueGenerated"), rs.getString("Status"));
        stmt.execute("DELETE FROM ActiveFlights WHERE FlightNumber = '" + flightNumber + "'");
    }

    public ObservableList<String> getFlightNumbers() throws SQLException {
        ObservableList<String> list = FXCollections.observableArrayList();
        ResultSet rs;

        Statement stmt = connection.createStatement();
        String sqlStatement = "SELECT * FROM ActiveFlights";
        rs = stmt.executeQuery(sqlStatement);

        while (rs.next()) {
            list.add(rs.getString("FlightNumber"));
        }
        return list;
    }
}