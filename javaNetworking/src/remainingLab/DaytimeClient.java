/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remainingLab;

import java.net.*; // Import the java.net package, which contains the Socket class
import java.io.*; // Import the java.io package, which contains the InputStream, InputStreamReader, andStringBuilder classes

public class DaytimeClient {

    public static void main(String[] args) { // Declare the main method
        try { // Start a try-catch block for handling exceptions
            Socket socket = new Socket("time.nist.gov", 13); // Create a new Socket object and connect it to thespecified hostname and port (13 is the standard Daytime port)
//socket.setSoTimeout(15000); // Set the socket's timeout to 15 seconds (in milliseconds)
            InputStream in = socket.getInputStream(); // Get an InputStream object from the socket
            StringBuilder time = new StringBuilder(); // Create a new StringBuilder object to store the incomingdata
            InputStreamReader reader = new InputStreamReader(in, "ASCII"); // Create a newInputStreamReader object to read the data as ASCII characters
            for (int c = reader.read(); c != -1; c = reader.read()) { // Start a for loop that reads characters fromthe input stream until the end of the stream is reached
                time.append((char) c); // Append each character to the StringBuilder object
            }
            System.out.println(time); // Print the contents of the StringBuilder object to the console (which shouldcontain the current time in the Daytime format)
        } catch (IOException ex) { // If an exception is thrown...
            System.err.println(ex); // Print the exception to the console
        }
    }
}
