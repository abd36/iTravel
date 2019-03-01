package iTravel;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;

public class LineOfBusinessExecutives {
    private final StringProperty customer[];
    private final IntegerProperty numOfCustomerHelped;

    public LineOfBusinessExecutives(StringProperty[] customer, IntegerProperty numOfCustomerHelped) {
        this.customer = customer;
        this.numOfCustomerHelped = numOfCustomerHelped;
    }

    public StringProperty[] getCustomer() {
        return customer;
    }

    public int getNumOfCustomerHelped() {
        return numOfCustomerHelped.get();
    }

    public IntegerProperty numOfCustomerHelpedProperty() {
        return numOfCustomerHelped;
    }

    public void setNumOfCustomerHelped(int numOfCustomerHelped) {
        this.numOfCustomerHelped.set(numOfCustomerHelped);
    }





}
