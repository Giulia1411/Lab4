package com.giulia.model.aircraft;

public class Aircraft {
    protected String name;
    protected String aircraft_model;
    protected String type;
    protected double wingspan;
    protected double length;
    protected double max_speed;
    protected double flight_range;
    protected double fuel_consumption;
    protected double load_capacity;

    public Aircraft() {
        name = "unknown";
        aircraft_model = "unknown";
        type = "default";
        wingspan = 0.0;
        length = 0.0;
        max_speed = 0.0;
        flight_range = 0.0;
        fuel_consumption = 0.0;
        load_capacity = 0.0;
    }

    public Aircraft(String name, String aircraft_model, String description, double wingspan, double length, double max_speed, double flight_range, double fuel_consumption, double load_capacity) {
        this.name = name;
        this.aircraft_model = aircraft_model;
        this.type = description;
        this.wingspan = wingspan;
        this.length = length;
        this.max_speed = max_speed;
        this.flight_range = flight_range;
        this.fuel_consumption = fuel_consumption;
        this.load_capacity = load_capacity;
    }

    public Aircraft(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAircraft_model() {
        return aircraft_model;
    }

    public String getType() {
        return type;
    }

    public double getWingspan() {
        return wingspan;
    }

    public double getLength() {
        return length;
    }

    public double getMax_speed() {
        return max_speed;
    }

    public double getFlight_range() {
        return flight_range;
    }

    public double getFuel_consumption() {
        return fuel_consumption;
    }

    public double getLoad_capacity() {
        return load_capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAircraft_model(String aircraft_model) {
        this.aircraft_model = aircraft_model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setMax_speed(double max_speed) {
        this.max_speed = max_speed;
    }

    public void setFlight_range(double flight_range) {
        this.flight_range = flight_range;
    }

    public void setFuel_consumption(double fuel_consumption) {
        this.fuel_consumption = fuel_consumption;
    }

    public void setLoad_capacity(double load_capacity) {
        this.load_capacity = load_capacity;
    }

    public void setSeats(int seats)
    {
        ;
    }

    public int getSeats()
    {
        return 0;
    }
    @Override
    public String toString() {
        return "Name: "+name +"\nModel: "+aircraft_model +"\nWingspan: "
                + wingspan+ "m" +"\nLength: "+length +"m" +"\nMax speed: "+max_speed +"km/h"
                +"\nFlight range: "+flight_range +"m" +"\nFuel consumption: "+fuel_consumption + "l/km"
                +"\nLoad capacity: " +load_capacity;
    }
}
