package com.giulia.model.aircraft.types;

import com.giulia.model.aircraft.Aircraft;

public class CargoAircraft extends Aircraft {
    public CargoAircraft() {
        type = "cargo";
    }

    public CargoAircraft(String name, String aircraft_model, String description, double wingspan, double length, double max_speed, double flight_range, double fuel_consumption, double load_capacity) {
        super(name, aircraft_model, description, wingspan, length, max_speed, flight_range, fuel_consumption, load_capacity);
    }

    public CargoAircraft(String name) {
        super(name);
    }
}
