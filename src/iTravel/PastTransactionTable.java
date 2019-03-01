package iTravel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class PastTransactionTable {
    private final IntegerProperty flight;
    private final IntegerProperty farePaid;
    private final StringProperty discountApplied;

    public PastTransactionTable(IntegerProperty flight, IntegerProperty farePaid, StringProperty discountApplied) {
        this.flight = flight;
        this.farePaid = farePaid;
        this.discountApplied = discountApplied;
    }

    public int getFlight() {
        return flight.get();
    }

    public IntegerProperty flightProperty() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight.set(flight);
    }

    public int getFarePaid() {
        return farePaid.get();
    }

    public IntegerProperty farePaidProperty() {
        return farePaid;
    }

    public void setFarePaid(int farePaid) {
        this.farePaid.set(farePaid);
    }

    public String getDiscountApplied() {
        return discountApplied.get();
    }

    public StringProperty discountAppliedProperty() {
        return discountApplied;
    }

    public void setDiscountApplied(String discountApplied) {
        this.discountApplied.set(discountApplied);
    }


}
