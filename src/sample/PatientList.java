package sample;

import javafx.beans.property.SimpleStringProperty;

public class PatientList {
    private SimpleStringProperty name;
    private SimpleStringProperty room;
    private SimpleStringProperty id;

    PatientList(String name, String room, String id) {
        this.name = new SimpleStringProperty(name);
        this.room = new SimpleStringProperty(room);
        this.id = new SimpleStringProperty(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getRoom() {
        return room.get();
    }

    public SimpleStringProperty roomProperty() {
        return room;
    }

    public void setRoom(String room) {
        this.room.set(room);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }
}
