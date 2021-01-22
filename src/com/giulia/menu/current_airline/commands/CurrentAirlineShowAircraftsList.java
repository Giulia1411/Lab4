package com.giulia.menu.current_airline.commands;

import com.giulia.menu.Command;
import com.giulia.model.Airline;

public class CurrentAirlineShowAircraftsList implements Command {
    Airline airline;

    public CurrentAirlineShowAircraftsList(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        airline.aircrafts_list();
    }
}
