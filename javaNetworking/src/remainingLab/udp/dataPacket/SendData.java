/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remainingLab.udp.dataPacket;

import java.net.*;
import java.io.*;

public class SendData {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        /* The DatagramSocket ds = new DatagramSocket(); statement creates a new DatagramSocket object
named ds, which is used to send and receive datagrams. */
        String str = "Message Sent by Datagram Socket.";
        /*The String str = "Message Sent by Datagram Socket."; statement creates a new string object named str,
which contains the message to be sent.*/
        byte[] data = "Message sent by DatagramSocket".getBytes();
        /* stored string in a bytes of array and object call data */
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 3000);
/* Created a new DatagramPacket object named dp, which represents the datagram to be sent. It takes four
arguments: the byte array representation of the message, the length of the message, the destination IP
address, and the destination port number (in this case, 1234). */
        ds.send(dp);
        ds.close();
    }
}
