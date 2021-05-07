package com.example.senyakapro;

public class Insert {

    String id;
    String name;
    String passenger;
    String trans;
    String place;

    public Insert() {
    }

    public Insert(String id, String name, String passenger, String trans, String place) {
        this.id = id;
        this.name = name;
        this.passenger = passenger;
        this.trans = trans;
        this.place = place;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
