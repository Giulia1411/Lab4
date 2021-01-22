package com.giulia.manage_list;
import com.giulia.controller.menu_controllers.ControllerAircraftsListMenu;
import com.giulia.controller.menu_controllers.ControllerAirlinesListMenu;
import com.giulia.controller.menu_controllers.ControllerCurrentAirlineMenu;
import com.giulia.controller.menu_controllers.ControllerFlightsListMenu;
import com.giulia.model.Airline;
import com.giulia.scanner.SaveScanner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Receiver
public class AirlinesList {
    private List<Airline> airlines = new ArrayList<>();
    private ControllerAirlinesListMenu this_controller;
    private SaveScanner in = new SaveScanner();

    public AirlinesList(ControllerAirlinesListMenu this_controller) {
        this.this_controller = this_controller;
    }

    public void about()
    {
        System.out.println("Program by Kalyniuk Giulia (CS-205 ASU)" +
                "\n This programm created for manage one or more airlines. " +
                "\nFor do something add airline and choose option Action");
        this_controller.user();
    }

    // print list
    private void list()
    {
        for (int i = 0; i < airlines.size(); i++)
        {
            System.out.println((i+1)+". "+airlines.get(i).getName());
        }
    }

    public void show_list()
    {
        System.out.println("-----List of airlines-----");
        list();
        System.out.println();
        this_controller.user();
    }

    public void select_airline()
    {
        if(airlines.size() == 0)
        {
            System.out.println("List is empty!");
            this_controller.user();
        }
        System.out.println("Change airline from list: ");
        list();
        int number = in.scan_int() - 1;
        while(number < 0 || number > airlines.size()-1)
        {
            System.out.print("Retry: ");
            number = in.scan_int() - 1;
        }
        new ControllerCurrentAirlineMenu(airlines.get(number), this_controller).user();
    }

    public void new_airline()
    {
        System.out.print("Airline name: ");
        String name = in.scan_line();
        airlines.add(new Airline(name));
        System.out.println("Airline created successfully!");
        System.out.println("One more? 1 - Yes. 2 - No.");
        int choice = in.scan_int();
        while(choice < 1 || choice > 2)
        {
            System.out.println("Retry: ");
            choice = in.scan_int();
        }
        if(choice == 1)
            new_airline();
        else {
            this_controller.user();
        }
    }

    public void delete_airline()
    {
        System.out.println("-------List of airlines----- ");
        list();
        System.out.print("Delete: ");
        int num = in.scan_int()-1;
        while(num < 1 || num > airlines.size())
        {
            System.out.print("Retry: ");
            num = in.scan_int()-1;
        }
        airlines.remove(num);
        System.out.println("Airline deleted!");
        System.out.println("One more? 1 - Yes. 2 - No.");
        int choice = in.scan_int();
        while(choice < 1 || choice > 2)
        {
            System.out.println("Retry: ");
            choice = in.scan_int();
        }
        if(choice == 1)
            delete_airline();
        else {
            this_controller.user();
        }
    }

    public void load_database()
    {
        System.out.print("Path to database: ");
        String folder_name = in.scan_line();
        File folder = new File(folder_name);
        while(!folder.isDirectory() || !folder.exists())
        {
            System.out.println("Retry: ");
            folder_name = in.scan_line();
            folder = new File(folder_name);
        }

        for (File file: folder.listFiles())
        {
            if(file.exists() && file.isDirectory())
            {
                Airline airline = new Airline(file.getName());
                airlines.add(airline);

                AircraftsList aircraftsList = new AircraftsList();
                FlightsList flightsList = new FlightsList();

                ControllerCurrentAirlineMenu current_airline = new ControllerCurrentAirlineMenu(airline, this_controller);
                ControllerAircraftsListMenu airline_aircrafts = new ControllerAircraftsListMenu(current_airline);
                ControllerFlightsListMenu airline_flights = new ControllerFlightsListMenu(current_airline);
                airline.setController_aircrafts(airline_aircrafts);
                airline.setController_flights(airline_flights);

                File aircrafts_path = new File(file.getPath()+"/aircrafts");
                if(aircrafts_path.exists() && aircrafts_path.isDirectory())
                {
                    airline_aircrafts.setAircrafts(aircraftsList);
                    aircraftsList.setThis_controller(airline_aircrafts);
                    aircraftsList.read_from_path(aircrafts_path);
                    airline.setAircrafts(aircraftsList);
                }
                else {
                    System.out.println("Error...");
                    this_controller.user();
                }


                File flights_path = new File(file.getPath()+"/flights");
                if(flights_path.exists() && flights_path.isDirectory())
                {
                    airline_flights.setFlights(flightsList);
                    flightsList.setThis_controller(airline_flights);
                    flightsList.set_air_list(aircraftsList);
                    flightsList.read_from_path(flights_path);
                    airline.setFlights(flightsList);
                }
                else {
                    System.out.println("Error...");
                    this_controller.user();
                }

            }
            else
            {
                System.out.println("Error reading database.");
                this_controller.user();
            }
        }
        System.out.println("Data base was loaded!");
        this_controller.user();
    }
}
