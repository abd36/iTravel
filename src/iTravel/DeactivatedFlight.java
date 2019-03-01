package iTravel;

import iTravel.Flight;

public class DeactivatedFlight {
    private final Flight listOfFlights;

    public DeactivatedFlight(Flight listOfFlights) {
        this.listOfFlights = listOfFlights;
    }

    public Flight getListOfFlights() {
        return listOfFlights;
    }
}
