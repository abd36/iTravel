package iTravel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import iTravel.Aircraft;


public class Flight {

    private final IntegerProperty flightNumber;
    private final IntegerProperty totalBusSeats;
    private final IntegerProperty totalExecSeats;
    private final IntegerProperty availableBusSeats;
    private final IntegerProperty availableExecSeats;
    private final StringProperty origin;
    private final StringProperty destination;
    private final StringProperty status;
    private final DoubleProperty fareExec;
    private final DoubleProperty fareBus;
    private final DoubleProperty revenueGenerated;
    private final Aircraft aircraft;

    public Flight(IntegerProperty flightNumber, IntegerProperty totalBusSeats, IntegerProperty totalExecSeats, IntegerProperty availableBusSeats, IntegerProperty availableExecSeats, StringProperty origin, StringProperty destination, StringProperty status, DoubleProperty fareExec, DoubleProperty fareBus, DoubleProperty revenueGenerated, Aircraft aircraft) {
        this.flightNumber = flightNumber;
        this.totalBusSeats = totalBusSeats;
        this.totalExecSeats = totalExecSeats;
        this.availableBusSeats = availableBusSeats;
        this.availableExecSeats = availableExecSeats;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
        this.fareExec = fareExec;
        this.fareBus = fareBus;
        this.revenueGenerated = revenueGenerated;
        this.aircraft = aircraft;
    }

    public int getFlightNumber() {
        return flightNumber.get();
    }

    public IntegerProperty flightNumberProperty() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber.set(flightNumber);
    }

    public int getTotalBusSeats() {
        return totalBusSeats.get();
    }

    public IntegerProperty totalBusSeatsProperty() {
        return totalBusSeats;
    }

    public void setTotalBusSeats(int totalBusSeats) {
        this.totalBusSeats.set(totalBusSeats);
    }

    public int getTotalExecSeats() {
        return totalExecSeats.get();
    }

    public IntegerProperty totalExecSeatsProperty() {
        return totalExecSeats;
    }

    public void setTotalExecSeats(int totalExecSeats) {
        this.totalExecSeats.set(totalExecSeats);
    }

    public int getAvailableBusSeats() {
        return availableBusSeats.get();
    }

    public IntegerProperty availableBusSeatsProperty() {
        return availableBusSeats;
    }

    public void setAvailableBusSeats(int availableBusSeats) {
        this.availableBusSeats.set(availableBusSeats);
    }

    public int getAvailableExecSeats() {
        return availableExecSeats.get();
    }

    public IntegerProperty availableExecSeatsProperty() {
        return availableExecSeats;
    }

    public void setAvailableExecSeats(int availableExecSeats) {
        this.availableExecSeats.set(availableExecSeats);
    }

    public String getOrigin() {
        return origin.get();
    }

    public StringProperty originProperty() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin.set(origin);
    }

    public String getDestination() {
        return destination.get();
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination.set(destination);
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

    public double getFareExec() {
        return fareExec.get();
    }

    public DoubleProperty fareExecProperty() {
        return fareExec;
    }

    public void setFareExec(double fareExec) {
        this.fareExec.set(fareExec);
    }

    public double getFareBus() {
        return fareBus.get();
    }

    public DoubleProperty fareBusProperty() {
        return fareBus;
    }

    public void setFareBus(double fareBus) {
        this.fareBus.set(fareBus);
    }

    public double getRevenueGenerated() {
        return revenueGenerated.get();
    }

    public DoubleProperty revenueGeneratedProperty() {
        return revenueGenerated;
    }

    public void setRevenueGenerated(double revenueGenerated) {
        this.revenueGenerated.set(revenueGenerated);
    }

    public Aircraft getAircraft() {
        return aircraft;
    }




}
