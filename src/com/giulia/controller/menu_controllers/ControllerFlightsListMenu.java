package com.giulia.controller.menu_controllers;

import com.giulia.controller.Controller;
import com.giulia.manage_list.FlightsList;
import com.giulia.menu.current_airline.submenus.flights_list_menu.FlightsListMenu;
import com.giulia.menu.current_airline.submenus.flights_list_menu.commands.*;

public class ControllerFlightsListMenu extends Controller {
    private FlightsListMenu menu = new FlightsListMenu();
    private FlightsList flights = new FlightsList();
    private ControllerCurrentAirlineMenu prev_controller;

    public ControllerFlightsListMenu(ControllerCurrentAirlineMenu prev_controller) {
        this.prev_controller = prev_controller;
        flights.setThis_controller(this);
    }

    public FlightsList getFlights() {
        return flights;
    }

    public void setFlights(FlightsList flights) {
        this.flights = flights;
    }

    public void user() {
        int amount_commands = menu.command_list();
        int choice = user_choose(amount_commands);

        switch (choice) {
            case (1):
                menu.set_command(new FlightsShowList(flights));
                menu.execute();
                break;
            case (2):
                menu.set_command(new FlightsAddFlight(flights));
                menu.execute();
                break;
            case (3):
                menu.set_command(new FlightsDeleteFlight(flights));
                menu.execute();
                break;
            case (4):
                menu.set_command(new FlightsReadFromFile(flights));
                menu.execute();
                break;
            case (5):
                menu.set_command(new FlightsCalculate(flights));
                menu.execute();
                break;
            case (6):
                menu.set_command(new FlightsSort(flights));
                menu.execute();
                break;
            case(0):
                // go back
                prev_controller.user();
                break;
            default:
                System.out.println("Error...");
                break;
        }
    }
}
