package com.CabBooking;

import java.util.Comparator;

public class temp {
    public static Comparator<Cab> sorting = new Comparator<Cab>() {
        @Override
        public int compare(Cab o1, Cab o2) {
            int t1 = o1.getTime();
            int t2 = o2.getTime();
            return t1 - t2;
        }
    };
}
