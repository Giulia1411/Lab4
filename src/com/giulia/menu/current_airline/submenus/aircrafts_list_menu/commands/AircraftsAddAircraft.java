package com.giulia.menu.current_airline.submenus.aircrafts_list_menu.commands;

import com.giulia.manage_list.AircraftsList;
import com.giulia.menu.Command;

public class AircraftsAddAircraft implements Command {
    AircraftsList aircraftsList;

    public AircraftsAddAircraft(AircraftsList aircraftsList) {
        this.aircraftsList = aircraftsList;
    }

    @Override
    public void execute() {
        aircraftsList.add_aircraft();
    }
}
