package datagramdemo;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;

public class ChannelSender {
    public static void main(String[] args)throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        String msg = "Hello this is message from channel";
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        InetSocketAddress receiverAddress = new InetSocketAddress(InetAddress.getLocalHost(), 1234);
        channel.send(buffer, receiverAddress);
        System.out.println("Message sent successfully");
    }
}
