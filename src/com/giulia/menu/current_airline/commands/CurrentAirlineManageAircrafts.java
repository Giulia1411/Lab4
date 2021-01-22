package com.giulia.menu.current_airline.commands;

import com.giulia.menu.Command;
import com.giulia.model.Airline;

public class CurrentAirlineManageAircrafts implements Command {
    Airline airline;

    public CurrentAirlineManageAircrafts(Airline airline) {
        this.airline = airline;
    }

    @Override
    public void execute() {
        airline.manage_aircrafts();
    }
}
