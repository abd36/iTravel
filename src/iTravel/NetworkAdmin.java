package iTravel;

import javafx.beans.property.StringProperty;

public class NetworkAdmin {
    private final StringProperty emailAddress;
    private final StringProperty password;



    public NetworkAdmin(StringProperty emailAddress, StringProperty password) {
        this.emailAddress = emailAddress;
        this.password = password;
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
