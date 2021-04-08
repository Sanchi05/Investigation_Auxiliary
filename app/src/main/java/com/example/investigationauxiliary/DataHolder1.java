package com.example.investigationauxiliary;

public class DataHolder1 {

    String location_c, time_c,c_name;
    public DataHolder1(String time, String location, String name) {
        time_c = time;
        location_c = location;
        c_name = name;
    }

    public String getTime() {
        return time_c;
    }

    public void setTime(String time) {
        time_c = time;
    }

    public String getLocation() {
        return location_c;
    }

    public void setLocation(String location) {
        location_c = location;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
}



