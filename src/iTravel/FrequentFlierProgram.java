package iTravel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.DoubleProperty;
import java.util.Date;


public class FrequentFlierProgram {
    private final IntegerProperty numOfTimesTravelled;
    private final DoubleProperty farePaid;
    private final DoubleProperty discount;
    private final Date expired;

    public FrequentFlierProgram(IntegerProperty numOfTimesTravelled, DoubleProperty farePaid, DoubleProperty discount, Date expired) {
        this.numOfTimesTravelled = numOfTimesTravelled;
        this.farePaid = farePaid;
        this.discount = discount;
        this.expired = expired;
    }

    public int getNumOfTimesTravelled() {
        return numOfTimesTravelled.get();
    }

    public IntegerProperty numOfTimesTravelledProperty() {
        return numOfTimesTravelled;
    }

    public void setNumOfTimesTravelled(int numOfTimesTravelled) {
        this.numOfTimesTravelled.set(numOfTimesTravelled);
    }

    public double getFarePaid() {
        return farePaid.get();
    }

    public DoubleProperty farePaidProperty() {
        return farePaid;
    }

    public void setFarePaid(double farePaid) {
        this.farePaid.set(farePaid);
    }

    public double getDiscount() {
        return discount.get();
    }

    public DoubleProperty discountProperty() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount.set(discount);
    }

    public Date getExpired() {
        return expired;
    }

}
