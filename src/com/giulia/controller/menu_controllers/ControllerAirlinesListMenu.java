package com.giulia.controller.menu_controllers;

import com.giulia.controller.Controller;
import com.giulia.menu.all_airlines.AllAirlinesMenu;
import com.giulia.menu.all_airlines.concrete_commands.*;
import com.giulia.manage_list.AirlinesList;


public class ControllerAirlinesListMenu extends Controller {
    private AirlinesList airlines_list = new AirlinesList(this);
    private AllAirlinesMenu menu = new AllAirlinesMenu();
    public void user() {


        int amount_commands = menu.command_list();
        int choice = user_choose(amount_commands);

        switch (choice) {
            case (1):
                menu.set_command(new AirlinesAbout(airlines_list));
                menu.execute();
                break;
            case (2):
                menu.set_command(new AirlinesShowList(airlines_list));
                menu.execute();
                break;
            case (3):
                menu.set_command(new AirlinesCreateAirline(airlines_list));
                menu.execute();
                break;
            case (4):
                menu.set_command(new AirlinesDeleteAirline(airlines_list));
                menu.execute();
                break;
            case (5):
                menu.set_command(new AirlinesSelectAirline(airlines_list));
                menu.execute();
                break;
            case(6):
                menu.set_command(new AirlinesLoadDatabase(airlines_list));
                menu.execute();
                break;
            case(0):
                // exit
                System.out.println("Exit program...");
                System.exit(0);
                break;
            default:
                System.out.println("Error...");
                break;
        }
    }
}