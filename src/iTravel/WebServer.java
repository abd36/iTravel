package iTravel;

import javafx.beans.property.StringProperty;
import java.sql.Time;

public class WebServer {
    private final Time time;
    private final StringProperty webData;

    public Time getTime() {
        return time;
    }

    public String getWebData() {
        return webData.get();
    }

    public StringProperty webDataProperty() {
        return webData;
    }

    public void setWebData(String webData) {
        this.webData.set(webData);
    }

    public WebServer(Time time, StringProperty webData) {
        this.time = time;
        this.webData = webData;
    }



}
