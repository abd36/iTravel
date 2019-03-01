package iTravel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddFlightController implements Initializable {

    @FXML
    Button cancelBtn;

    @FXML
    Button submitBtn;

    @FXML
    TextField flightNumber;

    @FXML
    TextField origin;

    @FXML
    TextField destination;

    @FXML
    TextField aircraftType;

    @FXML
    TextField numberOfBusinessSeats;

    @FXML
    TextField numberOfExecutiveSeats;

    @FXML
    TextField priceOfBusinessSeat;

    @FXML
    TextField priceOfExecutiveSeat;

    private FlightsAdapter flightsAdapter;

    public void setModel(FlightsAdapter flights) {
        flightsAdapter = flights;
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void submit() {
        try {
            flightsAdapter.insertFlight("ActiveFlights", flightNumber.getText(), origin.getText(), destination.getText(), aircraftType.getText(), numberOfBusinessSeats.getText(), numberOfBusinessSeats.getText(), numberOfExecutiveSeats.getText(), numberOfExecutiveSeats.getText(), priceOfBusinessSeat.getText(), priceOfExecutiveSeat.getText(), "0", "Ready");
        } catch (SQLException ex) {
            System.out.print("error1: " + ex);
        }

        cancel();
    }
}
