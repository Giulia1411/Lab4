package com.giulia.manage_list;

import com.giulia.controller.menu_controllers.ControllerFlightsListMenu;
import com.giulia.model.aircraft.Aircraft;
import com.giulia.model.flight.Flight;
import com.giulia.scanner.SaveScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;

public class FlightsList {
    private List<Flight> flights = new ArrayList<>();
    private AircraftsList air_list;
    private ControllerFlightsListMenu this_controller;
    private SaveScanner in = new SaveScanner();

//    public FlightsList(ControllerFlightsListMenu this_controller) {
//        this.this_controller = this_controller;
//    }

    public void setThis_controller(ControllerFlightsListMenu this_controller) {
        this.this_controller = this_controller;
    }

    public void set_air_list(AircraftsList air_list)
    {
        this.air_list = air_list;
    }

    public void list()
    {
        for(int i = 0; i < flights.size(); i++)
        {
            System.out.println(i+1+". "+flights.get(i));
        }
    }
    public void show_list()
    {
        System.out.println("-----List of flights:-----");
        list();
        System.out.println();
        this_controller.user();
    }

    public void add_flight()
    {
        Flight fly = new Flight();

        System.out.println("Change aircraft from list:");
        air_list.list();
        int choice = in.scan_int() - 1;
        while(choice < 1 || choice > air_list.getAircrafts().size())
        {
            System.out.print("Retry: ");
            choice = in.scan_int();
        }
        fly.setAircraft(air_list.getAircrafts().get(choice));

        System.out.println("Departure city: ");
        fly.setCityA(in.scan_line());

        System.out.println("Arrival city: ");
        fly.setCityB(in.scan_line());

        System.out.println("Date: ");
        fly.setDate(in.scan_line());

        System.out.println("Time: ");
        fly.setTime(in.scan_line());

        System.out.println("Distance: ");
        fly.setDistance(in.scan_int());

        System.out.println("Ticket price: ");
        fly.setTicket_price(in.scan_int());

        flights.add(fly);
        System.out.println("Flight was added to list.");
        this_controller.user();
    }

    public void delete_flight()
    {
        System.out.println("-----List of flights----- ");
        list();
        System.out.print("Delete: ");
        int num = in.scan_int() - 1;
        while(num < 1 || num > flights.size())
        {
            System.out.print("Retry: ");
            num = in.scan_int() - 1;
        }
        flights.remove(num);
        System.out.println("Flight deleted!");
        System.out.println("One more? 1 - Yes. 2 - No.");
        int choice = in.scan_int();
        while(choice < 1 || choice > 2)
        {
            System.out.println("Retry: ");
            choice = in.scan_int();
        }
        if(choice == 1)
            delete_flight();
        else {
            this_controller.user();
        }
    }

    private int total_price()
    {
        int total=0;
        for(Flight fly : flights)
        {
            total += fly.getTicket_price();
        }
        return total;
    }

    public void calculate()
    {
        System.out.println("Total ticket price: "+total_price());
        this_controller.user();
    }

    public void sort()
    {
        System.out.println("Sort by:\n1. Date \n2. Ticket price \n3. Distance");
        System.out.print("Your choose: ");
        int choice = in.scan_int();

        while (choice < 1 || choice > 3)
        {
            System.out.print("Retry: ");
            choice = in.scan_int();
        }
        if(choice == 1) {
            Comparator<Flight> comparator = Comparator.comparing(obj -> obj.getFull_date().getTime());
            Collections.sort(flights, comparator);
        }
        else if(choice == 2)
        {
            Comparator<Flight> comparator = Comparator.comparing(obj -> obj.getTicket_price());
            Collections.sort(flights, comparator);
        }
        else{
            Comparator<Flight> comparator = Comparator.comparing(obj -> obj.getDistance());
            Collections.sort(flights, comparator);
        }
        System.out.println("List of flights was sorted!");
        this_controller.user();
    }

    public void read_from_path(File folder)
    {
        Properties properties = new Properties();
        for(File file : folder.listFiles()) {
            try {
                properties.load(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println("Critical error. File not found.");
                exit(-1);
            } catch (IOException e) {
                System.out.println("Critical error. IOException");
                exit(-1);
            }

            Flight fly = new Flight();
            String model = properties.getProperty("model");
            Aircraft air = search_air_for_model(model);
            if(air != null)
            {
                fly.setAircraft(air);
            }
            else
                fly.setAir_model(model);
            fly.setCityA(properties.getProperty("cityA"));
            fly.setCityB(properties.getProperty("cityB"));
            fly.setDate(properties.getProperty("date"));
            fly.setTime(properties.getProperty("time"));
            int ticket_price = Integer.parseInt(properties.getProperty("ticket_price"));
            fly.setTicket_price(ticket_price);

            int distance = Integer.parseInt(properties.getProperty("distance"));
            fly.setDistance(distance);
            flights.add(fly);
        }
    }

    public void user_read_from_path()
    {
        System.out.println("Enter path with files (flights properties):");
        System.out.print("Directory: ");
        String folder_name = in.scan_line();
        File folder = new File(folder_name);
        while(!folder.isDirectory() || !folder.exists())
        {
            System.out.println("Retry: ");
            folder_name = in.scan_line();
            folder = new File(folder_name);
        }
        read_from_path(folder);
        System.out.println("All flights from this path was added to list.");
        this_controller.user();
    }

    private Aircraft search_air_for_model(String model)
    {
        for(Aircraft air : air_list.getAircrafts())
        {
            String current_model = air.getAircraft_model();
            if(model.equals(current_model))
            {
                return air;
            }
        }
        return null;
    }

}
