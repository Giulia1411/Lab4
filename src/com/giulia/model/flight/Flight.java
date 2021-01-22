package com.giulia.model.flight;

import com.giulia.model.aircraft.Aircraft;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private Aircraft aircraft;
    private String air_model;
    private String cityA;
    private String cityB;

    private Date full_date;
    private String date;
    private String time;

    private int distance;
    private int ticket_price;

    public Flight()
    {
        cityA = "null";
        cityB = "null";
        distance = 0;
        ticket_price = 0;
        date = "00/00/0000";
        time = "00:00";
        air_model = "null";
        try {
            full_date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date+" "+time);
        }
        catch(ParseException e)
        {
            System.out.println("Parse Error exception. Critical error");
            System.exit(-1);
        }
    }

    public Date getFull_date() {
        return full_date;
    }

    public Flight(Aircraft aircraft, String cityA, String cityB, String date, String time, int distance, int ticket_price) {
        this.aircraft = aircraft;
        this.air_model = aircraft.getAircraft_model();
        this.cityA = cityA;
        this.cityB = cityB;
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.ticket_price = ticket_price;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public String getCityA() {
        return cityA;
    }

    public String getCityB() {
        return cityB;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    public int getTicket_price() {
        return ticket_price;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
        this.air_model = aircraft.getAircraft_model();
    }

    public void setAir_model(String air_model) {
        this.air_model = air_model;
    }

    public void setCityA(String cityA) {
        this.cityA = cityA;
    }

    public void setCityB(String cityB) {
        this.cityB = cityB;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }

    @Override
    public String toString() {
        return "Flight on " + air_model +
                " From: "+cityA +
                " to " + cityB +
                ", date: " + date +
                ", time: " + time +
                ", distance " + distance + " km" +
                ", ticket_price is " + ticket_price + " dollars";
    }
}
