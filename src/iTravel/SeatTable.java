package iTravel;

import iTravel.Customer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;


public class SeatTable  {

    private final StringProperty classOfSeat;
    private final StringProperty seatNumber;
    private final StringProperty ticketNumber;
    private final StringProperty status;
    private final DoubleProperty fare;
    private final Customer passenger;


    public SeatTable(StringProperty classOfSeat, StringProperty seatNumber, StringProperty ticketNumber, StringProperty status, DoubleProperty fare, Customer passenger) {
        this.classOfSeat = classOfSeat;
        this.seatNumber = seatNumber;
        this.ticketNumber = ticketNumber;
        this.status = status;
        this.fare = fare;
        this.passenger = passenger;
    }

    public String getClassOfSeat() {
        return classOfSeat.get();
    }

    public StringProperty classOfSeatProperty() {
        return classOfSeat;
    }

    public void setClassOfSeat(String classOfSeat) {
        this.classOfSeat.set(classOfSeat);
    }

    public String getSeatNumber() {
        return seatNumber.get();
    }

    public StringProperty seatNumberProperty() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber.set(seatNumber);
    }

    public String getTicketNumber() {
        return ticketNumber.get();
    }

    public StringProperty ticketNumberProperty() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber.set(ticketNumber);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public double getFare() {
        return fare.get();
    }

    public DoubleProperty fareProperty() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare.set(fare);
    }

    public Customer getPassenger() {
        return passenger;
    }


}
