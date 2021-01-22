package com.giulia.menu.all_airlines.concrete_commands;

import com.giulia.manage_list.AirlinesList;
import com.giulia.menu.Command;

public class AirlinesLoadDatabase implements Command {
    AirlinesList airlines;

    public AirlinesLoadDatabase(AirlinesList airlines) {
        this.airlines = airlines;
    }

    @Override
    public void execute() {
        airlines.load_database();
    }
}
