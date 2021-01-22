package com.giulia.manage_list;

import com.giulia.controller.menu_controllers.ControllerAircraftsListMenu;
import com.giulia.model.aircraft.Aircraft;
import com.giulia.model.aircraft.types.CargoAircraft;
import com.giulia.model.aircraft.types.ExtraAircraft;
import com.giulia.model.aircraft.types.PassengerAircraft;
import com.giulia.scanner.SaveScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;

public class AircraftsList {
    private List<Aircraft> aircrafts = new ArrayList<>();
    private ControllerAircraftsListMenu this_controller;
    private SaveScanner in = new SaveScanner();

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }


    public void setThis_controller(ControllerAircraftsListMenu this_controller) {
        this.this_controller = this_controller;
    }

    public void list()
    {
        for (int i = 0; i < aircrafts.size(); i++)
        {
            System.out.println((i+1)+". "+aircrafts.get(i));
        }
    }

    public void show_list()
    {
        System.out.println("-----List of aircrafts:-----");
        list();
        System.out.println();
        this_controller.user();
    }

    public void add_aircraft()
    {
        System.out.println("Type of aircraft: 1 - passenger, 2 - cargo, 3-extra, 4-default");
        int choice = in.scan_int();
        while(choice < 1 || choice > 4)
        {
            System.out.println("Retry: ");
            choice = in.scan_int();
        }
        Aircraft air;

        if(choice == 1)
            air = new PassengerAircraft();
        else if(choice == 2)
            air = new CargoAircraft();
        else if(choice == 3)
            air = new ExtraAircraft();
        else air = new Aircraft();

        System.out.print("Name: ");
        air.setName(in.scan_line());

        System.out.print("Model: ");
        air.setAircraft_model(in.scan_line());

        System.out.print("Wingspan(m): ");
        air.setWingspan(in.scan_double());

        System.out.print("Length(m): ");
        air.setLength(in.scan_double());

        System.out.print("Max speed(km/h): ");
        air.setMax_speed(in.scan_double());

        System.out.print("Flight range(km): ");
        air.setFlight_range(in.scan_double());

        System.out.print("Fuel consumption(l for km): ");
        air.setFuel_consumption(in.scan_double());

        System.out.print("Load capacity(kg): ");
        air.setLoad_capacity(in.scan_double());

        if(air.getType().equals("passenger")) {
            System.out.println("Total seats: ");
            air.setSeats(in.scan_int());
        }

        System.out.print("");

        aircrafts.add(air);
        System.out.println("Aircraft created successfully!");
        System.out.println("One more? 1 - Yes. 2 - No.");
        choice = in.scan_int();
        while(choice < 1 || choice > 2)
        {
            System.out.println("Retry: ");
            choice = in.scan_int();
        }
        if(choice == 1)
            add_aircraft();
        else {
            this_controller.user();
        }
    }

    public void delete_aircraft()
    {
        System.out.println("List of aircrafts: ");
        list();
        System.out.print("Delete: ");
        int num = in.scan_int() - 1;
        while(num < 1 || num > aircrafts.size())
        {
            System.out.print("Retry: ");
            num = in.scan_int() - 1;
        }
        aircrafts.remove(num);
        System.out.println("Aircraft deleted!");
        System.out.println("One more? 1 - Yes. 2 - No.");
        int choice = in.scan_int();
        while(choice < 1 || choice > 2)
        {
            System.out.println("Retry: ");
            choice = in.scan_int();
        }
        if(choice == 1)
            delete_aircraft();
        else {
            this_controller.user();
        }
    }

    private int total_seats()
    {
        int total_seats = 0;
        for(Aircraft air : aircrafts)
        {
            total_seats += air.getSeats();
        }
        return total_seats;
    }

    private int total_load_capacity()
    {
        int total_load_capacity = 0;

        for (Aircraft air : aircrafts)
        {
            total_load_capacity += air.getLoad_capacity();
        }
        return total_load_capacity;
    }
    // total seats and load capacity
    public void calculate()
    {
        System.out.println("Total seats: "+ total_seats());
        System.out.println("Total load capacity: "+total_load_capacity());
        this_controller.user();
    }

    // flight range, max_speed, load capacity
    public void sort()
    {
        System.out.println("Sort by:\n1. Flight range \n2. Max Speed \n3. Load Capacity");
        System.out.print("Your choose: ");
        int choice = in.scan_int();
        while (choice < 1 || choice > 3)
        {
            System.out.print("Retry: ");
            choice = in.scan_int();
        }
        if(choice == 1) {
            Comparator<Aircraft> comparator = Comparator.comparing(obj -> obj.getFlight_range());
            Collections.sort(aircrafts, comparator.reversed());
        }
        else if(choice == 2)
        {
            Comparator<Aircraft> comparator = Comparator.comparing(obj -> obj.getMax_speed());
            Collections.sort(aircrafts, comparator.reversed());
        }
        else{
            Comparator<Aircraft> comparator = Comparator.comparing(obj -> obj.getLoad_capacity());
            Collections.sort(aircrafts, comparator.reversed());
        }
        System.out.println("List of aircrafts was sorted!");
        this_controller.user();
    }

    // fuel, seats, capacity, name, model, speed
    public void filter()
    {
        System.out.println("Choose filter: ");
        System.out.println("1. Fuel consumption\n2. Seats\n3.Load Capacity\n4.Max Speed");
        int choice = in.scan_int();
        while (choice < 1 || choice > 4)
        {
            System.out.print("Retry: ");
            choice = in.scan_int();
        }

        if(choice == 1)
        {
            double interval_start;
            double interval_end;
            System.out.println("Filter from(l/km): ");
            interval_start = in.scan_double();
            System.out.println("To: ");
            interval_end = in.scan_double();

            System.out.println("Filtered list: ");
            int counter = 1;
            for (Aircraft air : aircrafts)
            {
                if(air.getFuel_consumption() >= interval_start && air.getFuel_consumption() <= interval_end) {
                    System.out.println(counter + ". " + air);
                    counter++;
                }
            }
        }
        else if (choice == 2)
        {
            int interval_start;
            int interval_end;
            System.out.println("Filter from(amount): ");
            interval_start = in.scan_int();
            System.out.println("To: ");
            interval_end = in.scan_int();
            System.out.println("Filtered list: ");
            int counter = 1;
            for (Aircraft air : aircrafts)
            {

                if (air.getSeats() >= interval_start && air.getSeats() <= interval_end) {
                    System.out.println(counter + ". " + air);
                    counter++;
                }

            }
        }
        else if(choice == 3)
        {
            double interval_start;
            double interval_end;
            System.out.println("Filter from(kg): ");
            interval_start = in.scan_double();
            System.out.println("To: ");
            interval_end = in.scan_double();

            System.out.println("Filtered list: ");
            int counter = 1;
            for (Aircraft air : aircrafts)
            {
                if(air.getLoad_capacity() >= interval_start && air.getLoad_capacity() <= interval_end)
                {   System.out.println(counter+". "+air);
                counter++;}
            }
        }
        else
        {
            double interval_start;
            double interval_end;
            System.out.println("Filter from(km/h): ");
            interval_start = in.scan_double();
            System.out.println("To: ");
            interval_end = in.scan_double();
            System.out.println("Filtered list: ");
            int counter = 1;
            for (Aircraft air : aircrafts)
            {
                if(air.getMax_speed() >= interval_start && air.getMax_speed() <= interval_end)
                {System.out.println(counter+". "+air);
                counter++;}
            }
        }
        System.out.println("List was filtered.");
        this_controller.user();
    }

    public void user_read_from_path() {
        System.out.println("Enter path with files (aircraft properties):");
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
        System.out.println("All aircrafts from this path was added to list.");
        this_controller.user();
    }

    public void read_from_path(File folder)
    {
        Properties properties = new Properties();
        for(File file : folder.listFiles())
        {
            try {
                properties.load(new FileReader(file));
            }
            catch (FileNotFoundException e) {

                System.out.println("Critical error. File not found.");
                exit(-1);
            }
            catch (IOException e)
            {
                System.out.println("Critical error. IOException");
                exit(-1);
            }
            String type = properties.getProperty("type");

            Aircraft air;
            if(type.equals("passenger"))
                air = new PassengerAircraft();
            else if(type.equals("cargo"))
                air = new CargoAircraft();
            else if(type.equals("extra"))
                air = new ExtraAircraft();
            else air = new Aircraft();

            air.setAircraft_model(properties.getProperty("model"));
            air.setName(properties.getProperty("name"));
            air.setType(properties.getProperty(type));
            if(type.equals("passenger")) {
                int total_seats = Integer.parseInt(properties.getProperty("total_seats"));
                air.setSeats(total_seats);
            }
            double wingspan = Double.parseDouble(properties.getProperty("wingspan"));
            air.setWingspan(wingspan);
            double length = Double.parseDouble(properties.getProperty("length"));
            air.setLength(length);
            double max_speed = Double.parseDouble(properties.getProperty("max_speed"));
            air.setMax_speed(max_speed);
            double flight_range = Double.parseDouble(properties.getProperty("flight_range"));
            air.setFlight_range(flight_range);
            double fuel_consumption = Double.parseDouble(properties.getProperty("fuel_consumption"));
            air.setFuel_consumption(fuel_consumption);
            double load_capacity = Double.parseDouble(properties.getProperty("load_capacity"));
            air.setLoad_capacity(load_capacity);
            aircrafts.add(air);
        }
    }

}
