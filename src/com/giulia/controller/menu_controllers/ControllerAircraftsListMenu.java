package com.giulia.controller.menu_controllers;

import com.giulia.controller.Controller;
import com.giulia.manage_list.AircraftsList;
import com.giulia.menu.current_airline.submenus.aircrafts_list_menu.AircraftsListMenu;
import com.giulia.menu.current_airline.submenus.aircrafts_list_menu.commands.*;


public class ControllerAircraftsListMenu extends Controller {
    private AircraftsListMenu menu = new AircraftsListMenu();
    private AircraftsList aircrafts = new AircraftsList();
    private ControllerCurrentAirlineMenu prev_controller;

    public ControllerAircraftsListMenu(ControllerCurrentAirlineMenu controller) {
        prev_controller = controller;
        aircrafts.setThis_controller(this);
    }

    public void setAircrafts(AircraftsList aircrafts) {
        this.aircrafts = aircrafts;
    }

    public AircraftsList getAircrafts() {
        return aircrafts;
    }

    public void user() {
        //FileHandler logger = new FileHandler("log.txt");
        int amount_commands = menu.command_list();
        int choice = user_choose(amount_commands);

        switch (choice) {
            case (1):
                menu.set_command(new AircraftsShowList(aircrafts));
                menu.execute();
                break;
            case (2):
                menu.set_command(new AircraftsAddAircraft(aircrafts));
                menu.execute();
                break;
            case (3):
                menu.set_command(new AircraftsDeleteAircraft(aircrafts));
                menu.execute();
                break;
            case (4):
                menu.set_command(new AircraftsReadFromFile(aircrafts));
                menu.execute();
                break;
            case (5):
                menu.set_command(new AircraftsCalculate(aircrafts));
                menu.execute();
                break;
            case (6):
                menu.set_command(new AircraftsSort(aircrafts));
                menu.execute();
                break;
            case (7):
                menu.set_command(new AircraftsFilter(aircrafts));
                menu.execute();
                break;
            case(0):
                prev_controller.user();
                break;
            default:
                System.out.println("Error...");
                break;
        }
    }
}
