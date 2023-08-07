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

public class MulticastMessageSender {

    public static void main(String[] args) throws IOException {
 // Open the multicast socket on port 3456
        MulticastSocket socket = new MulticastSocket(3456);
        // Address for the multicast group
        InetAddress group = InetAddress.getByName("225.4.5.6");
        // Create the multicast message and store it in msg variable
        String msg = "Hello this is a multicast program";
        // Send the multicast packet to the multicast group
        DatagramPacket outPacket = new DatagramPacket(msg.getBytes(), msg.length(), group, 3456);
        socket.send(outPacket);
        socket.close();
    }
}
