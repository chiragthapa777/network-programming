/*
 * 2. Write a pogram using DatagramChannel between sender and receiver ;
ALgorithms
SENDER :
1. Open a DatagramChannel.
2. Create the message to be sent.
3. Wrap the message in a ByteBuffer.
4. Create an InetSocketAddress with the receiver's address and port.
5. Send the message using the send method of the channel, providing the buffer and receiver's address.
6. Close the channel.

RECEIVER :
1. Open a DatagramChannel.
2. Create an InetSocketAddress with the receiver's address and port.
3. Bind the channel to the receiver's address using the bind method.
4. Create a ByteBuffer with a suitable size to receive the incoming message.
5. Use the receive method of the channel to receive the message, providing the buffer.
6. Flip the buffer to prepare it for reading.
7. Create a byte array with the remaining bytes in the buffer.
8. Convert the byte array to a string to extract the received message.
9. Print the received message.
10. Close the channel.
 */
package remainingLab.udp.datagramChannel;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class SenderProgram {

    public static void main(String[] args) throws Exception {
        DatagramChannel channel = DatagramChannel.open(); // Open a DatagramChannel for sendingmessages
        String message = "Hello, Receiver!"; // Create the message to be sent
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes()); // Wrap the message in a ByteBuffer
        InetSocketAddress receiverAddress = new InetSocketAddress("localhost", 1234); // Create thereceiver's address
        channel.send(buffer, receiverAddress); // Send the message to the receiver
        System.out.println("Message sent successfully.");
    }
}
