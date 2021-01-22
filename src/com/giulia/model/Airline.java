package com.giulia.model;

import com.giulia.controller.menu_controllers.ControllerAircraftsListMenu;
import com.giulia.controller.menu_controllers.ControllerCurrentAirlineMenu;
import com.giulia.controller.menu_controllers.ControllerFlightsListMenu;
import com.giulia.manage_list.AircraftsList;
import com.giulia.manage_list.FlightsList;

public class Airline {
    private String name;
    private AircraftsList aircrafts;
    private FlightsList flights;
    private ControllerCurrentAirlineMenu this_controller;
    private ControllerAircraftsListMenu controller_aircrafts =
            new ControllerAircraftsListMenu(this_controller);
    private ControllerFlightsListMenu controller_flights =
            new ControllerFlightsListMenu(this_controller);


    public void setController_aircrafts(ControllerAircraftsListMenu controller_aircrafts) {
        this.controller_aircrafts = controller_aircrafts;
    }

    public void setController_flights(ControllerFlightsListMenu controller_flights) {
        this.controller_flights = controller_flights;
    }

    public AircraftsList getAircrafts() {
        return aircrafts;
    }

    public FlightsList getFlights() {
        return flights;
    }

    public void setAircrafts(AircraftsList aircrafts) {
        this.aircrafts = aircrafts;
    }

    public void setFlights(FlightsList flights) {
        this.flights = flights;
    }

    public Airline(String name){
        this.name = name;
    }

    public void set_this_controller(ControllerCurrentAirlineMenu this_controller)
    {
        this.this_controller = this_controller;
    }

    public String getName() {
        return name;
    }


    public void aircrafts_list()
    {
        if (aircrafts == null) {
            System.out.println("List is empty.");
            this_controller.user();
        }
        aircrafts.list();
        this_controller.user();
    }

    public void flights_list()
    {
        if(flights == null)
        {
            System.out.println("List is empty.");
            this_controller.user();
        }
        flights.list();
        this_controller.user();
    }

    public void manage_flights()
    {
        if(aircrafts==null) {
            System.out.println("You can't manage flight, because aircraft list is empty.");
            this_controller.user();
        }
        flights = controller_flights.getFlights();
        flights.set_air_list(aircrafts);
        controller_flights.user();
    }

    public void manage_aircrafts()
    {
        aircrafts = controller_aircrafts.getAircrafts();
        controller_aircrafts.user();
    }
}
