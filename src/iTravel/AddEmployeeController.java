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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddEmployeeController implements Initializable {
    @FXML
    Button cancelBtn;

    @FXML
    Button submitBtn;

    @FXML
    TextField idText;

    @FXML
    TextField nameText;

    @FXML
    TextField emailText;

    @FXML
    TextField roleText;

    @FXML
    TextField usernameText;

    @FXML
    PasswordField passwordText;

    private EmployeesAdapter employeesAdapter;

    public void setModel(EmployeesAdapter employees) { employeesAdapter = employees; }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void submit() {
        try {
            employeesAdapter.insertEmployee("ActiveEmployees", idText.getText(), nameText.getText(), emailText.getText(), roleText.getText(), usernameText.getText(), passwordText.getText());
        } catch (SQLException ex) {
            System.out.print("error: " + ex);
        }

        cancel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
