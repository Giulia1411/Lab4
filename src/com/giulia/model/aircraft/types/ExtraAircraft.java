package com.giulia.model.aircraft.types;

import com.giulia.model.aircraft.Aircraft;

public class ExtraAircraft extends Aircraft {
    public ExtraAircraft() {
        type = "extra";
    }

    public ExtraAircraft(String name, String aircraft_model, String description, double wingspan, double length, double max_speed, double flight_range, double fuel_consumption, double load_capacity) {
        super(name, aircraft_model, description, wingspan, length, max_speed, flight_range, fuel_consumption, load_capacity);
    }

    public ExtraAircraft(String name) {
        super(name);
    }
}
