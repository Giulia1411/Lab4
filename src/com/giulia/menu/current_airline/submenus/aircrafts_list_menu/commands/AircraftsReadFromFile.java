package com.giulia.menu.current_airline.submenus.aircrafts_list_menu.commands;

import com.giulia.manage_list.AircraftsList;
import com.giulia.menu.Command;

public class AircraftsReadFromFile implements Command {
    AircraftsList aircraftsList;

    public AircraftsReadFromFile(AircraftsList aircraftsList) {
        this.aircraftsList = aircraftsList;
    }

    @Override
    public void execute() {
        aircraftsList.user_read_from_path();
    }
}
