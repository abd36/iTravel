package iTravel;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.DoubleProperty;


public class UserAccount {
    private final StringProperty username;
    private final StringProperty password;
    private final IntegerProperty totalSeatsReserved;
    private final DoubleProperty totalFarePaid;

    public UserAccount(StringProperty username, StringProperty password, IntegerProperty totalSeatsReserved, DoubleProperty totalFarePaid) {
        this.username = username;
        this.password = password;
        this.totalSeatsReserved = totalSeatsReserved;
        this.totalFarePaid = totalFarePaid;
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

    public int getTotalSeatsReserved() {
        return totalSeatsReserved.get();
    }

    public IntegerProperty totalSeatsReservedProperty() {
        return totalSeatsReserved;
    }

    public void setTotalSeatsReserved(int totalSeatsReserved) {
        this.totalSeatsReserved.set(totalSeatsReserved);
    }

    public double getTotalFarePaid() {
        return totalFarePaid.get();
    }

    public DoubleProperty totalFarePaidProperty() {
        return totalFarePaid;
    }

    public void setTotalFarePaid(double totalFarePaid) {
        this.totalFarePaid.set(totalFarePaid);
    }
}
