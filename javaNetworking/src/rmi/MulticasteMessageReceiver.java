/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author DELL
 */
import java.net.*;
import java.io.*;

public class MulticasteMessageReceiver {

    public static void main(String[] args) throws IOException {
        // Open the multicast socket on port 3456
        MulticastSocket socket = new MulticastSocket(3456);
        // Join a multicast group by specifying the multicast address
        InetAddress group = InetAddress.getByName("225.4.5.6");
        socket.joinGroup(group);
        // Create a byte array to store incoming data, maximum 1024 bytes
        byte[] buffer = new byte[1024];
        // Create a DatagramPacket for receiving multicast packets
        DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
        // Receive a multicast packet
        socket.receive(inPacket);
        // Convert the received data to a string and print it in the console
        String receivedMessage = new String(buffer, 0, inPacket.getLength());
        System.out.println("Received: " + receivedMessage);
        socket.close();
    }
}
