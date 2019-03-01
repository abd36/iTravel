package iTravel;

import javafx.beans.property.StringProperty;
import java.sql.Time;

public class ApplicationServer {
    private final Time time;
    private final StringProperty applicationData;

    public ApplicationServer(Time time, StringProperty applicationData) {
        this.time = time;
        this.applicationData = applicationData;
    }

    public Time getTime() {
        return time;
    }

    public String getApplicationData() {
        return applicationData.get();
    }

    public StringProperty applicationDataProperty() {
        return applicationData;
    }

    public void setApplicationData(String applicationData) {
        this.applicationData.set(applicationData);
    }



}
