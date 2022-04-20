package com.CabBooking;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Cab {

    static List<Cab> cabs = new ArrayList<Cab>();
    static long sysTime = (((System.nanoTime()/1000000)/1000));

    int time, currenctLocation, destination;
    long bookingTime;
    double earning;
    Boolean isAvail;
    String name;

    public Cab(String name, long bookingTime, double earning, int currenctLocation, int destination, Boolean isAvail) {
        this.time = time;
        this.currenctLocation = currenctLocation;
        this.bookingTime = bookingTime;
        this.destination = destination;
        this.earning = earning;
        this.isAvail = isAvail;
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCurrenctLocation() {
        return currenctLocation;
    }

    public void setCurrenctLocation(int currenctLocation) {
        this.currenctLocation = currenctLocation;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public long getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(long bookingTime) {
        this.bookingTime = bookingTime;
    }

    public double getEarning() {
        return earning;
    }

    public void setEarning(double earning) {
        this.earning = earning;
    }

    public Boolean getAvail() {
        return isAvail;
    }

    public void setAvail(Boolean avail) {
        isAvail = avail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void availableCabs() {
        for (Cab cab : cabs) {
            if (cab.getAvail() == true) {

            }
        }
    }
    public  static void isAvail(){
        for (Cab cab : cabs) {
            if (cab.isAvail==true) {
                System.out.println(cab.getName());
            }
        }
    }
    public static void getCurrentTime() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        long sysTime2 = (((System.nanoTime()/1000000)/1000));
        long temptime = sysTime2-sysTime;
        for (Cab cab : cabs) {
            cab.getBookingTime();
            long checkTime = (temptime - cab.bookingTime);
            if (checkTime>=0){
                cab.setAvail(true);
            }else {
                cab.setAvail(false);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        cabs.add(new Cab("Cab1", 8, 0.0, 0, 0, true));
        cabs.add(new Cab("Cab2", 4, 0.0, 0, 0, true));
        cabs.add(new Cab("Cab3", 5, 0.0, 0, 0, true));
        cabs.add(new Cab("Cab4", 10, 0.0, 0, 0, true));
        getCurrentTime();
        isAvail();
    }
}

