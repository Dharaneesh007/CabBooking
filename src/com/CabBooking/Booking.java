package com.CabBooking;

import java.util.Scanner;

import static com.CabBooking.Cab.availableCabs;
import static com.CabBooking.Cab.getCurrentTime;

public class Booking {
    static Scanner input = new Scanner(System.in);
    static int sLocation,destination;

    public static void CustomerBooking() throws InterruptedException {
        input.nextLine();
        System.out.println("Enter your name : ");
        String custName = input.nextLine();
        System.out.println("Choose your Starting Location : \n\n" +
                " 1 . Place1 \n 2 . Place2 \n 3 . Place3 \n 4 . Place4 \n 5 . Place5 \n 6 . Place6 \n 7 . Place7 \n 8 . Place8 \n 9 . Place9 \n 10 . Place10 \n");
        int custStartingLocation = input.nextInt();
        sLocation = Locations(custStartingLocation);
        if ((custStartingLocation>0)&&(custStartingLocation<11)){
            Locations(custStartingLocation);
            sLocation = Locations(custStartingLocation);
        }else {
            System.out.println("There is no service at that location");
        }
        //System.out.println(sLocation);
        System.out.println("Choose your Destination : \n\n" +
                " 1 . Place1 \n 2 . Place2 \n 3 . Place3 \n 4 . Place4 \n 5 . Place5 \n 6 . Place6 \n 7 . Place7 \n 8 . Place8 \n 9 . Place9 \n 10 . Place10 \n");
        int custDestionation = input.nextInt();
        if ((custDestionation>0)&&(custDestionation<11)){
            Locations(custDestionation);
            destination = Locations(custDestionation);
        }else {
            System.out.println("There is no service at that location");
        }
        //System.out.println(destination);
        Cab.getCurrentTime();
        //showAvailCabs(sLocation,destination);
        getCurrentTime();
        availableCabs(sLocation,destination);
    }


    public static int Locations(int a) {
        int size = 0;
        switch (a) {
            case 1:
                size = 0;
                break;
            case 2:
                size = 1;
                break;
            case 3:
                size = 2;
                break;
            case 4:
                size = 3;
                break;
            case 5:
                size = 4;
                break;
            case 6:
                size = 5;
                break;
            case 7:
                size = 6;
                break;
            case 8:
                size = 7;
                break;
            case 9:
                size = 8;
                break;
            case 10:
                size = 9;
                break;
            default:
                Locations(a);
                break;

        }
        return size;
    }

    public static void main(String[] args) throws InterruptedException {
        Cab.main(args);
        CustomerBooking();
    }
}
