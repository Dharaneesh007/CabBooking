package com.CabBooking;



public class Log {
    public String name;
    public long bookingTime;
    public double earning;

    public Log(String name, long bookingTime, double earning) {
        this.name = name;
        this.bookingTime = bookingTime;
        this.earning = earning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
