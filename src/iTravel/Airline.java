package iTravel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import iTravel.Aircraft;

public class Airline {
    private final IntegerProperty numberOfAircrafts;
    private final StringProperty name;
    private final Aircraft listOfAircrafts[];

    public Airline(IntegerProperty numberOfAircrafts, StringProperty name, Aircraft[] listOfAircrafts) {
        this.numberOfAircrafts = numberOfAircrafts;
        this.name = name;
        this.listOfAircrafts = listOfAircrafts;
    }

    public int getNumberOfAircrafts() {
        return numberOfAircrafts.get();
    }

    public IntegerProperty numberOfAircraftsProperty() {
        return numberOfAircrafts;
    }

    public void setNumberOfAircrafts(int numberOfAircrafts) {
        this.numberOfAircrafts.set(numberOfAircrafts);
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

    public Aircraft[] getListOfAircrafts() {
        return listOfAircrafts;
    }








}
