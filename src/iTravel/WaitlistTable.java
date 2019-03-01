package iTravel;

import iTravel.Customer;
import javafx.beans.property.IntegerProperty;

public class WaitlistTable {
    private final Customer passenger;
    private final IntegerProperty waitingNumber;

    public WaitlistTable(Customer passenger, IntegerProperty waitingNumber) {
        this.passenger = passenger;
        this.waitingNumber = waitingNumber;
    }

    public Customer getPassenger() {
        return passenger;
    }

    public int getWaitingNumber() {
        return waitingNumber.get();
    }

    public IntegerProperty waitingNumberProperty() {
        return waitingNumber;
    }

    public void setWaitingNumber(int waitingNumber) {
        this.waitingNumber.set(waitingNumber);
    }
}
