package com.giulia.model.aircraft.types;

import com.giulia.model.aircraft.Aircraft;

public class PassengerAircraft extends Aircraft {
    private int seats;

    public PassengerAircraft() {
        type = "passenger";
        seats = 0;
    }

    public PassengerAircraft(String name, String aircraft_model, String description, double wingspan, double length, double max_speed, double flight_range, double fuel_consumption, double load_capacity) {
        super(name, aircraft_model, description, wingspan, length, max_speed, flight_range, fuel_consumption, load_capacity);
    }

    public PassengerAircraft(String name) {
        super(name);
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Name: "+name +"\nModel: "+aircraft_model +"\nWingspan"
                + wingspan+ "m" +"\nLength: "+length +"m" +"\nMax speed: "+max_speed +"km/h"
                +"\nFlight range: "+flight_range +"m" +"\nFuel consumption: "+fuel_consumption + "l/km"
                +"\nLoad capacity: " +load_capacity +"\nSeats: "+seats;
    }

}
