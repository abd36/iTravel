package iTravel;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyEmployeeController implements Initializable {

    @FXML
    ComboBox<String> idBox;

    @FXML
    Button cancelBtn;

    @FXML
    Button modifyBtn;

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

    final ObservableList<String> activeEmployeeIds = FXCollections.observableArrayList();
    private EmployeesAdapter employeesAdapter;

    public void setModel(EmployeesAdapter employees) {
        employeesAdapter = employees;
        buildComboBoxData();
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void modify() throws SQLException {
        employeesAdapter.insertEmployee("ActiveEmployees", idText.getText(), nameText.getText(), emailText.getText(), roleText.getText(), usernameText.getText(), passwordText.getText());
        employeesAdapter.deleteEmployee(idBox.getValue());

        cancel();
    }

    @FXML
    public void updatePrompts() throws SQLException {
        ResultSet rs = employeesAdapter.getEmployee(idBox.getValue());

        idText.setPromptText(rs.getString("Id"));
        nameText.setPromptText(rs.getString("Name"));
        emailText.setPromptText(rs.getString("Email"));
        roleText.setPromptText(rs.getString("Role"));
        usernameText.setPromptText(rs.getString("Username"));
    }

    public void buildComboBoxData() {
        try {
            activeEmployeeIds.addAll(employeesAdapter.getIds());
        } catch (SQLException ex) {
            System.out.print("error: " + ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idBox.setItems(activeEmployeeIds);
    }
}
