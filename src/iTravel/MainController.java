/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iTravel;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.Connection;

/**
 *
 * @author Abdelkader
 */
public class MainController implements Initializable {

    private FlightsAdapter flights;
    private EmployeesAdapter employees;
    private AircraftsAdapter aircrafts;
    private Connection conn;

    @FXML
    private MenuBar mainMenu;

    @FXML
    public void resetDB() {
        try {
            flights = new FlightsAdapter(conn, true);
            employees = new EmployeesAdapter(conn, true);
            //aircrafts = new AircraftsAdapter(conn, true);
        } catch (SQLException ex) {
            System.out.print("error: " + ex);
        }
    }

    public void showAbout() throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("About.fxml"));
        Parent About = (Parent) fxmlLoader.load();

        Scene scene = new Scene(About);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:src/iTravel/WesternLogo.png"));
        stage.setTitle("About Us");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void addEmployee() throws Exception {

        employees = new EmployeesAdapter(conn,false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddEmployee.fxml"));
        Parent addEmployee = (Parent) fxmlLoader.load();
        AddEmployeeController addEmployeeController = (AddEmployeeController) fxmlLoader.getController();
        addEmployeeController.setModel(employees);

        Scene scene = new Scene(addEmployee);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Add New Employee");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    @FXML
    public void modifyEmployee() throws Exception {

        employees = new EmployeesAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModifyEmployee.fxml"));
        Parent modifyEmployee = (Parent) fxmlLoader.load();
        ModifyEmployeeController modifyEmployeeController = (ModifyEmployeeController) fxmlLoader.getController();
        modifyEmployeeController.setModel(employees);

        Scene scene = new Scene(modifyEmployee);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Modify Employee");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    @FXML
    public void removeEmployee() throws Exception {

        employees = new EmployeesAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveEmployee.fxml"));
        Parent removeEmployee = (Parent) fxmlLoader.load();
        RemoveEmployeeController removeEmployeeController = (RemoveEmployeeController) fxmlLoader.getController();
        removeEmployeeController.setModel(employees);

        Scene scene = new Scene(removeEmployee);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Remove Employee");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    @FXML
    public void addFlight() throws Exception {

        // create Flight model
        flights = new FlightsAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddFlight.fxml"));
        Parent addFlight = (Parent) fxmlLoader.load();
        AddFlightController addFlightController = (AddFlightController) fxmlLoader.getController();
        addFlightController.setModel(flights);

        Scene scene = new Scene(addFlight);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Add New Flight");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    @FXML
    public void removeFlight() throws Exception {

        // create Flight model
        flights = new FlightsAdapter(conn, false);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RemoveFlight.fxml"));
        Parent removeFlight = (Parent) fxmlLoader.load();
        RemoveFlightController removeFlightController = (RemoveFlightController) fxmlLoader.getController();
        removeFlightController.setModel(flights);

        Scene scene = new Scene(removeFlight);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Remove Flight");
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.show();
    }

    public void exit() {

        Stage stage = (Stage) mainMenu.getScene().getWindow();
        stage.close();
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            // Create a named constant for the URL
            // NOTE: This value is specific for Java DB
            String DB_URL = "jdbc:derby:TeamDB;create=true";
            // Create a connection to the database
            conn = DriverManager.getConnection(DB_URL);

        } catch (SQLException ex) {

        }

    }

}

