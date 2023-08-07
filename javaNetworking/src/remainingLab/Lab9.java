/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remainingLab;

import java.net.*;
import java.util.Scanner;

public class Lab9 {

    public static void main(String[] args) {
        try {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter URL");

            String urlString = myObj.nextLine();
// Create a URL object and connected to example.com
            URL url = new URL(urlString);
// Create a HttpURLConnection object for the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            System.out.println("Content Type: " + connection.getContentType());
// Extract and print the Content Length of the response
            System.out.println("Content Length: " + connection.getContentLength());
            System.out.println("Content-Encoding: " + connection.getHeaderField("Content-Encoding"));
// Extract and print the Date of the response as a java.util.Date object
            System.out.println("Date: " + new java.util.Date(connection.getDate()));
// Extract and print the Last Modified date of the resource as a java.util.Date object
            System.out.println("Last Modified: " + new java.util.Date(connection.getLastModified()));
// Extract and print the Expiration date of the resource as a java.util.Date object, or "notspecified" if no expiration date is set
            long expiration = connection.getExpiration();
            if (expiration == 0) {
                System.out.println("Expiration: not specified");
            } else {
                System.out.println("Expiration: " + new java.util.Date(expiration));
            }
// Extract and print additional headers using a loop
            System.out.println("Additional headers:");
        } catch (Exception ex) {
// If an I/O error occurs, print an error message to the console
            System.err.println(ex);
        }
    }
}
