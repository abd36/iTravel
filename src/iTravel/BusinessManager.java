package iTravel;

import javafx.beans.property.IntegerProperty;
import iTravel.FrequentFlierProgram;

public class BusinessManager {
    private final IntegerProperty numOfFlightsCreated;
    private final IntegerProperty numOfFFPCreated;
    private final FrequentFlierProgram listOfFFP[];

    public BusinessManager(IntegerProperty numOfFlightsCreated, IntegerProperty numOfFFPCreated, FrequentFlierProgram[] listOfFFP) {
        this.numOfFlightsCreated = numOfFlightsCreated;
        this.numOfFFPCreated = numOfFFPCreated;
        this.listOfFFP = listOfFFP;
    }


    public int getNumOfFlightsCreated() {
        return numOfFlightsCreated.get();
    }

    public IntegerProperty numOfFlightsCreatedProperty() {
        return numOfFlightsCreated;
    }

    public void setNumOfFlightsCreated(int numOfFlightsCreated) {
        this.numOfFlightsCreated.set(numOfFlightsCreated);
    }

    public int getNumOfFFPCreated() {
        return numOfFFPCreated.get();
    }

    public IntegerProperty numOfFFPCreatedProperty() {
        return numOfFFPCreated;
    }

    public void setNumOfFFPCreated(int numOfFFPCreated) {
        this.numOfFFPCreated.set(numOfFFPCreated);
    }

    public FrequentFlierProgram[] getListOfFFP() {
        return listOfFFP;
    }

;

}
