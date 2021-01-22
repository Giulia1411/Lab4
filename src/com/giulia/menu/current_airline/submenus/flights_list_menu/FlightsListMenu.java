package com.giulia.menu.current_airline.submenus.flights_list_menu;

import com.giulia.menu.Menu;

public class FlightsListMenu extends Menu {
    public int command_list()
    {
        System.out.println("-----Actions with flights-----");
        System.out.println("1.Show list of flights" +
                "\n2.Add flight to list" +
                "\n3.Delete flight from list" +
                "\n4.Add flights from file" +
                "\n5.Calculate" +
                "\n6.Sort" +
                "\n0.Back to manage airline");
        return 8;
    }
}
