package com.giulia.menu.all_airlines.concrete_commands;

import com.giulia.menu.Command;
import com.giulia.manage_list.AirlinesList;

public class AirlinesShowList implements Command {
    AirlinesList airlines;

    public AirlinesShowList(AirlinesList airlines) {
        this.airlines = airlines;
    }

    @Override
    public void execute() {
        airlines.show_list();
    }
}
