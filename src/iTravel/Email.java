package iTravel;

import javafx.beans.property.StringProperty;

public class Email {
    private final StringProperty from;
    private final StringProperty to;
    private final StringProperty username;
    private final StringProperty role;

    public Email(StringProperty from, StringProperty to, StringProperty username, StringProperty role) {
        this.from = from;
        this.to = to;
        this.username = username;
        this.role = role;
    }

    public String getFrom() {
        return from.get();
    }

    public StringProperty fromProperty() {
        return from;
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public String getTo() {
        return to.get();
    }

    public StringProperty toProperty() {
        return to;
    }

    public void setTo(String to) {
        this.to.set(to);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }


}
