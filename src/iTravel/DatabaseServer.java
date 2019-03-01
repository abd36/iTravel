package iTravel;

import javafx.beans.property.StringProperty;
import java.sql.Time;

public class DatabaseServer {
    private final Time time;
    private final StringProperty databaseServer;

    public DatabaseServer(Time time, StringProperty databaseServer) {
        this.time = time;
        this.databaseServer = databaseServer;
    }

    public Time getTime() {
        return time;
    }

    public String getDatabaseServer() {
        return databaseServer.get();
    }

    public StringProperty databaseServerProperty() {
        return databaseServer;
    }

    public void setDatabaseServer(String databaseServer) {
        this.databaseServer.set(databaseServer);
    }





}

