package datagramdemo;

import java.net.*;
import java.io.*;


public class SendData {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        String str = "This is the message";
        DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(),InetAddress.getLocalHost(), 1234);
        ds.send(dp);
        ds.close();
    }
}
