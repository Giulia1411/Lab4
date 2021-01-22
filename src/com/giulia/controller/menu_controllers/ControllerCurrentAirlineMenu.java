package com.giulia.controller.menu_controllers;

import com.giulia.controller.Controller;
import com.giulia.menu.current_airline.CurrentAirlineMenu;
import com.giulia.menu.current_airline.commands.*;
import com.giulia.model.Airline;


public class ControllerCurrentAirlineMenu extends Controller {
    private Airline airline;
    private CurrentAirlineMenu menu;
    private ControllerAirlinesListMenu prev_controller;

    public ControllerCurrentAirlineMenu(Airline airline, ControllerAirlinesListMenu prev_controller) {
        this.airline = airline;
        this.prev_controller = prev_controller;
        menu = new CurrentAirlineMenu(airline);
        airline.set_this_controller(this);
    }

    public void user() {

        int amount_commands = menu.command_list();
        int choice = user_choose(amount_commands);

        switch (choice) {
            case (1):
                menu.set_command(new CurrentAirlineShowFlightsList(airline));
                menu.execute();
                break;
            case (2):
                menu.set_command(new CurrentAirlineShowAircraftsList(airline));
                menu.execute();
                break;
            case (3):
                menu.set_command(new CurrentAirlineManageFlights(airline));
                menu.execute();
                break;
            case (4):
                menu.set_command(new CurrentAirlineManageAircrafts(airline));
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
