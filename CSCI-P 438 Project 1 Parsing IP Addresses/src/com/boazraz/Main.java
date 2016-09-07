package com.boazraz;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Integer.parseInt;



public class Main  {

    public static void main(String[] args) {


        String p1 = args[0]; //p1
        String p2 = args[1]; //p2
        String p3 = args[2]; //p3

        test(p1, p2, p3);


    } // end main


    public static void test(String p1, String p2, String p3) {
        if (p1.equals("0")) {
            validIP(p1,p2,p3);
        } else if (p1.equals("1")) {
            endian(p1, p2, p3);
        } else {
            System.out.println("ERROR");

        }
    }

    public static boolean validIP(String p1, String p2, String p3) {
        try {
            if (p2 == null || p2.isEmpty()) {
                System.out.println("ERROR");
                return false;
            }

            String[] parts = p2.split("\\.");
            if (parts.length != 4) {
                System.out.println("ERROR");
                return false;
            }

            for (String s : parts) {
                int i = parseInt(s);
                if ((i < 0) || (i > 255)) {
                    System.out.println("ERROR");
                    return false;
                }
            }
            if (p2.endsWith(".")) {
                System.out.println("ERROR");
                return false;
            }

            // Convert and print to long decimal
            String s7 = "";
            if (p1.equals("0") && p3.equals("0")){
                Collections.reverse(Arrays.asList(parts));
                for (String s : parts) {
                    int i = parseInt(s);
                    s7 += (String.format("%08d", new BigInteger(Long.toBinaryString((long)i))));

                }
                System.out.println( Long.parseLong(s7, 2));   // returns long

            } else if (p1.equals("0") && p3.equals("1")){
                for (String s : parts) {
                    int i = parseInt(s);
                    s7 += (String.format("%08d", new BigInteger(Long.toBinaryString((long)i))));
                }
                System.out.println( Long.parseLong(s7, 2));   // returns long

            } else {

            }


            return true;

        } catch (NumberFormatException nfe) {
            System.out.println("ERROR");
            return false;
        }
    }

    // Convert long number into ip address
    public static void endian(String p1, String p2,  String p3 ) {

        try {

            Long l2 = Long.parseLong(p2, 10);

            // *** convert long l1 to string of binary ***
            String s2 = Long.toBinaryString(l2);

            // split binary every 8 bits
            String[] thisCombo2 = s2.split("(?<=\\G........)");

            // print out the new array of strings every 8 digits
            String separator = "";  // separator here is your "."
            String s4 = "";

            if (p3.equals("1")) {
                for (String s : thisCombo2) {
                    int i = parseInt(s, 2);
                    String s5 = Integer.toString(i);
                    s4 += (separator + s5);
                    separator = ".";
                }
            }  else if (p3.equals("0")) { // convert to small endian
                // flip small endian
                Collections.reverse(Arrays.asList(thisCombo2));
                for (String s : thisCombo2) {
                    int i = parseInt(s, 2);
                    String s5 = Integer.toString(i);
                    s4 += (separator + s5);
                    separator = ".";
                }
            }

            if (validIP(p1,s4, p3)){
                System.out.println(s4); // testing
            } else {
            }

        } catch (NumberFormatException nfe) {
            System.out.println("ERROR");

        }

    } // end ConvertToIp method
} // end Main class