package com.boazraz;

public class Main {

    public static void main(String[] args) {


        validIP("");
        validIP("192.169.1.1.1");
        validIP("256.1.1.1");
        validIP("-1");



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
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    System.out.println("ip is out of range");
                    return false;
                }
            }
            if ( ip.endsWith(".") ) {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
} // end Main class




