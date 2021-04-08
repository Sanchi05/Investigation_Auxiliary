package com.example.investigationauxiliary;

public class DataHolder {

    String Time, Location, Name1;

    public DataHolder(String time, String location, String name) {
        Time = time;
        Location = location;
        Name1 = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }
}
