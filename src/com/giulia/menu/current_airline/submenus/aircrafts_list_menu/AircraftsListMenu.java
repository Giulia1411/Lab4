package com.giulia.menu.current_airline.submenus.aircrafts_list_menu;

import com.giulia.menu.Menu;


public class AircraftsListMenu extends Menu {

    public int command_list()
    {
        System.out.println("-----Actions with aircrafts-----");
        System.out.println("1.Show list of aircrafts" +
                "\n2.Add aircraft to list" +
                "\n3.Delete aircraft from list" +
                "\n4.Add aircrafts from file" +
                "\n5.Calculate" +
                "\n6.Sort" +
                "\n7.Filter" +
                "\n0.Back to manage airline");
        return 8;
    }
}
