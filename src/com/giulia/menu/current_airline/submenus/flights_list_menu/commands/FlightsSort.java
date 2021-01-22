package com.giulia.menu.current_airline.submenus.flights_list_menu.commands;

import com.giulia.manage_list.FlightsList;
import com.giulia.menu.Command;

public class FlightsSort implements Command {
    FlightsList flightsList;

    public FlightsSort(FlightsList flightsList) {
        this.flightsList = flightsList;
    }

    @Override
    public void execute() {
        flightsList.sort();
    }
}
