package datagramdemo;

import java.net.*;
import java.io.*;

public class ReceiveData {
    public static void main(String[] args) throws Exception {
        DatagramSocket dsocket = new DatagramSocket(1234);
        byte[] buff = new byte[1024];
        DatagramPacket dpacket = new DatagramPacket(buff, 1024);
        dsocket.receive(dpacket);
        String str = new String(dpacket.getData(),0,dpacket.getLength());
        System.out.println(str);
        dsocket.close();
    }
}
