package iTravel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RemoveFlightController implements Initializable {

    @FXML
    Button cancelBtn;

    @FXML
    Button removeBtn;

    @FXML
    ComboBox<String> flightNumberBox;

    final ObservableList<String> data = FXCollections.observableArrayList();
    private FlightsAdapter flightsAdapter;

    public void setModel(FlightsAdapter flights) {
        flightsAdapter = flights;
        buildComboBoxData();
    }

    @FXML
    public void remove() {
        try {
            flightsAdapter.removeFlight(flightNumberBox.getValue());
        } catch (SQLException ex) {
            System.out.print("error: " + ex);
        }

        cancel();
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void buildComboBoxData() {
        try {
            data.addAll(flightsAdapter.getFlightNumbers());
        } catch(SQLException ex) {
            System.out.print("error: " + ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        flightNumberBox.setItems(data);
    }
}
