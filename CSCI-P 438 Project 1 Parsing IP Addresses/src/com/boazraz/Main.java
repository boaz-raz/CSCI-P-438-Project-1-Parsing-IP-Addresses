package com.boazraz;

import java.util.Arrays;
import java.util.Collections;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {

//
//        validIP("");
//        validIP("192.169.1.1.1");
//        validIP("256.1.1.1");
//        validIP("-1");
//        validIP("192.168.0.1");
//
//        validIP("192.168.1a.1");
        ConvertToIp(3232235521L);



    } // end main


    public static boolean validIP (String ip) {
        try {
            if ( ip == null || ip.isEmpty() ) {
                System.out.println("String is empty");
                return false;

            }

            String[] parts = ip.split( "\\." );
            if ( parts.length != 4 ) {
                System.out.println("ip is longer or shouter than 4 a.b.c.d..");
                return false;
            }

            for ( String s : parts ) {
                int i = parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    System.out.println("ip is out of range");
                    return false;
                }
            }
            if ( ip.endsWith(".") ) {
                return false;
            }

            // add the parted int
            System.out.println("I'm parsing now...");
            for ( String s : parts ) {
                int i = parseInt( s );
               // int i = Integer.parseInt(s,2);
                System.out.println(Integer.toString(i,2));

//                String binary = Integer.toBinaryString(i);
//                System.out.println(binary);

            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }

    public static int ConvertToIp (Long l2) {
        try {

            System.out.println("testing 1234.. " + Long.toString(l2, 2)); // testing - print

            // *** convert long l1 to string of binary ***
            String s2 = Long.toBinaryString(l2);

            // split binary every 8 bits
            String[] thisCombo2 = s2.split("(?<=\\G........)");

            // print out the new array of strings every 8 digits
            String separator = "";  // separator here is your "."
            String s4 = "";
            for (String s : thisCombo2) {
                int i = parseInt(s, 2);
                String s5 =  Integer.toString(i);
                s4 += (separator + s5);
                separator = ".";
            }

            System.out.println(s4); // testing
            validIP(s4); // call validIP method to test if ip is valid

            //
            Collections.reverse(Arrays.asList(thisCombo2));
            for (String s : thisCombo2) {
                System.out.println(s);
            }

        } catch (NumberFormatException nfe) {

        }

        return 0;


    } // end ConvertToIp method

} // end Main class