package iTravel;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;


public class EmployeeAccount {
    private final StringProperty name;
    private final IntegerProperty employeeNum;
    private final StringProperty emailAddress;
    private final StringProperty role;
    private final StringProperty username;
    private final StringProperty password;

    public EmployeeAccount(StringProperty name, IntegerProperty employeeNum, StringProperty emailAddress, StringProperty role, StringProperty username, StringProperty password) {
        this.name = name;
        this.employeeNum = employeeNum;
        this.emailAddress = emailAddress;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }


    public int getEmployeeNum() {
        return employeeNum.get();
    }

    public IntegerProperty employeeNumProperty() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum.set(employeeNum);
    }



    public String getEmailAddress() {
        return emailAddress.get();
    }

    public StringProperty emailAddressProperty() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }



    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }



    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }



    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }





}
