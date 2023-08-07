/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit6SocketClient;

/**
 *
 * @author DELL
 */
import java.io.*;
import java.net.*;

public class Demo2Write {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("dict.org",2628);

            // Create input and output streams for communication
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter outputWriter = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);

            // Send data to the server
            String dataToSend = "Hello, Server! This is the data I want to send.";
            outputWriter.println(dataToSend);

            // Receive the response from the server
            String serverResponse = inputReader.readLine();

            // Print the response received from the server
            System.out.println("Server Response: " + serverResponse);

            // Close the socket and streams
            s.close();
            inputReader.close();
            outputWriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
