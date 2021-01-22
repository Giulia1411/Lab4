package com.giulia.menu.current_airline;

import com.giulia.menu.Menu;
import com.giulia.model.Airline;

public class CurrentAirlineMenu extends Menu {
    private Airline airline;

    public CurrentAirlineMenu(Airline airline) {
        this.airline = airline;
    }

    public int command_list()
    {
        System.out.println("-----"+airline.getName()+"-----");
        System.out.println("1.Show list of flights" +
                "\n2.Show list of aircrafts" +
                "\n3.Manage flights " +
                "\n4.Manage aircrafts" +
                "\n0.Back");
        return 5;
    }
}
