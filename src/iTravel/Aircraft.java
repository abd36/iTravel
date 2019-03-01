package iTravel;

import javafx.beans.property.StringProperty;

public class Aircraft {
    private final StringProperty aircraftId;
    private final StringProperty type;

    public Aircraft(StringProperty aircraftId, StringProperty type) {
        this.aircraftId = aircraftId;
        this.type = type;
    }

    public String getAircraftId() {
        return aircraftId.get();
    }

    public StringProperty aircraftIdProperty() {
        return aircraftId;
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }
}