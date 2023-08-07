package datagramdemo;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;
public class ChannelReceiver {
    public static void main(String[] args)throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        InetSocketAddress addr = new InetSocketAddress(InetAddress.getLocalHost(), 1234);
        channel.bind(addr);
        ByteBuffer buff = ByteBuffer.allocate(1024);
        while (true){
            channel.receive(buff);
            buff.flip();
            byte[] receivedData = new byte[buff.remaining()];
            buff.get(receivedData);
            String msg = new String(receivedData);
            System.out.println("Received message : "+msg);
        }

    }
}
