package com.giulia.menu.all_airlines.concrete_commands;

import com.giulia.menu.Command;
import com.giulia.manage_list.AirlinesList;

public class AirlinesSelectAirline implements Command {
    AirlinesList airlinesList;

    public AirlinesSelectAirline(AirlinesList airlinesList) {
        this.airlinesList = airlinesList;
    }

    @Override
    public void execute() {
        airlinesList.select_airline();
    }
}
