package com.giulia.menu.current_airline.commands;

import com.giulia.menu.Command;
import com.giulia.model.Airline;

public class CurrentAirlineShowFlightsList implements Command {
    Airline airline;

    public CurrentAirlineShowFlightsList(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        airline.flights_list();
    }
}
