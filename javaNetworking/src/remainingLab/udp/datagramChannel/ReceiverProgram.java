/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remainingLab.udp.datagramChannel;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ReceiverProgram {

    public static void main(String[] args) throws Exception {
        DatagramChannel channel = DatagramChannel.open(); // Open a DatagramChannel for receivingmessages
        InetSocketAddress receiverAddress = new InetSocketAddress("localhost", 1234); // Create thereceiver's address
        channel.bind(receiverAddress); // Bind the channel to the receiver's address
        ByteBuffer buffer = ByteBuffer.allocate(1024); // Create a ByteBuffer to receive the incomingmessage

        channel.receive(buffer); // Receive the message
        buffer.flip(); // Prepare the buffer for reading
        byte[] receivedData = new byte[buffer.remaining()]; // Create a byte array with the received data
        buffer.get(receivedData);
        String message = new String(receivedData); // Convert the byte array to a string to extract thereceived message
        System.out.println("Received message: " + message); // Print the received message
    }
}
