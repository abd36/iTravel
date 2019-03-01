package iTravel;

import javafx.beans.property.StringProperty;

public class Customer {

    private final StringProperty name;
    private final StringProperty emailAddress;

    //public  Customer(){}

    public Customer(StringProperty name, StringProperty emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
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

    public String getEmailAddress() {
        return emailAddress.get();
    }

    public StringProperty emailAddressProperty() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress.set(emailAddress);
    }

}
