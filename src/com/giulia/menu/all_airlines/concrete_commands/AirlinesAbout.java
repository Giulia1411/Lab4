package com.giulia.menu.all_airlines.concrete_commands;

import com.giulia.menu.Command;
import com.giulia.manage_list.AirlinesList;

public class AirlinesAbout implements Command {
    AirlinesList airlinesList;

    public AirlinesAbout(AirlinesList airlinesList) {
        this.airlinesList = airlinesList;
    }

    public void execute()
    {
        airlinesList.about();
    }
}
