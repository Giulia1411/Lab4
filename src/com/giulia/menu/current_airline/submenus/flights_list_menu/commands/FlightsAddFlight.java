package com.giulia.menu.current_airline.submenus.flights_list_menu.commands;

import com.giulia.manage_list.FlightsList;
import com.giulia.menu.Command;

public class FlightsAddFlight implements Command {
    FlightsList flightsList;

    public FlightsAddFlight(FlightsList flightsList) {
        this.flightsList = flightsList;
    }

    @Override
    public void execute() {
        flightsList.add_flight();
    }
}
