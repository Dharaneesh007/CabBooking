package com.CabBooking;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.CabBooking.Booking.CustomerBooking;

public class Cab {

    static List<Cab> cabs = new ArrayList<Cab>();
    static Scanner input = new Scanner(System.in);
    static long sysTime = (((System.nanoTime() / 1000000) / 1000));

    int time, currenctLocation, distance;
    long bookingTime,travelTime;
    double earning;
    Boolean isAvail;
    String name;

    public Cab(String name, long bookingTime,long travelTime, double earning, int currenctLocation, Boolean isAvail, int distance) {
        this.time = time;
        this.currenctLocation = currenctLocation;
        this.bookingTime = bookingTime;
        this.travelTime=travelTime;
        this.earning = earning;
        this.isAvail = isAvail;
        this.name = name;
        this.distance = distance;
    }

    public long getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(long travelTime) {
        this.travelTime = travelTime;
    }

    public int getDistance() {
        return distance;
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


    public long getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(long bookingTime) {
        this.bookingTime = bookingTime;
    }

    public double getEarning() {
        return earning;
    }

    public void setCurrenctLocation(int currenctLocation) {
        this.currenctLocation = currenctLocation;
    }

    public void setDistance(int distance) {
        this.distance = distance;
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

    public static void availableCabs(int a, int b) throws InterruptedException {
        int custLocation = a;
        int destination = b;
        System.out.println("...........Available Cabs.........");
        for (Cab cab : cabs) {
            if (cab.getAvail()) {
                if (custLocation - cab.currenctLocation >= 0) {
                    cab.setDistance((custLocation - cab.currenctLocation) * 30);
                } else if (custLocation - cab.currenctLocation < 0) {
                    cab.setDistance((cab.currenctLocation - custLocation) * 30);
                }

            }
        }
        Collections.sort(cabs, new Comparator<Cab>() {
            @Override
            public int compare(Cab o1, Cab o2) {
                int t1 = o1.getDistance();
                int t2 = o2.getDistance();
                return t1 - t2;
            }
        });
        nearbyCabs(custLocation, destination);
    }

    public static void nearbyCabs(int a, int b) throws InterruptedException {
        int custLocation = a;
        int destination = b;
        System.out.println("Choose the cab among the follwing");
        int temp = cabs.get(0).getDistance();
        for (Cab cab : cabs) {
            if (cab.getAvail()) {
                //System.out.println(cab.getName()+" " + cab.getDistance()+" \n\n");
                if (temp == cab.getDistance()) {
                    System.out.println("Cab Name : " + cab.getName() + ", Cab Location : " + cab.getDistance() + "kms");
                }
            } else {
                System.out.println("No cabs available!!!");
                break;
            }
        }
        bookinConfirm(custLocation, destination);
    }

    public static void bookinConfirm(int a, int b) throws InterruptedException {
        int custLocation = a;
        int destination = b;
        long sysTime2 = (((System.nanoTime() / 1000000) / 1000));
        long temptime = sysTime2 - sysTime;
        long temptraveltime;
        double tempearn;
        int i = input.nextInt();
        int j = --i;
        int temp = cabs.get(0).getDistance();
        for (Cab cab : cabs) {
            if (cab.getAvail()) {
                if (temp == cab.getDistance()) {
                    System.out.println("Cab Name:" + cabs.get(j).getName());
                    if (cabs.get(j).getAvail()) {
                        tempearn = ((((Math.abs(destination - custLocation)) * 30) - 5) * 10);

                        if (tempearn < 100.00) {
                            cab.setEarning(100.00);
                        } else {
                            cab.setEarning(100.00 + tempearn);
                        }
                        cab.setCurrenctLocation(destination);
                        System.out.println("Cab Fair : " + cab.getEarning()+" \n\n");
                        System.out.println(temptime);
                        cab.setBookingTime(temptime);
                        temptraveltime = (temptime+(destination- cab.getDistance())* 30L);
                        cab.setTravelTime(temptraveltime);
                        cab.setAvail(false);
                    }
                    System.out.println("Thanks for Booking Cab. Have a Peace and Safe Journey");
                    System.out.println("Do you want continue booking are exit? \n\n 1 - Continue \n\n 2 - Exit");
                    int m = input.nextInt();
                    if (m == 1) {
                        CustomerBooking();
                    }
                    break;
                }
            }
        }
    }

    public static void getCurrentTime() throws InterruptedException {
        long sysTime2 = (((System.nanoTime() / 1000000) / 1000));
        long temptime = sysTime2 - sysTime;
        for (Cab cab : cabs) {
            cab.getBookingTime();
            long checkTime = (temptime - cab.bookingTime);
            if (checkTime >= 0) {
                if (cab.travelTime<temptime){
                    cab.setAvail(true);
                }else {
                    cab.setAvail(false);
                }
            } else {
                cab.setAvail(false);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        cabs.add(new Cab("Cab1", 0, 0,0.0, 0, true, 0));
        cabs.add(new Cab("Cab2", 0, 0,0.0, 0, true, 0));
        cabs.add(new Cab("Cab3", 0, 0,0.0, 0, true, 0));
        cabs.add(new Cab("Cab4", 0, 0,0.0, 0, true, 0));
        //getCurrentTime();
        //availableCabs(1, 0);
    }
}

