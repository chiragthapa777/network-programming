/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit2;
import java.net.*;
import java.util.*;

/**
 *
 * @author DELL
 */
public class networkInterfaceExample {
    public static void main(String[] args) {
        try{
            
            //by inet address
            InetAddress local = InetAddress.getLocalHost();
            NetworkInterface nwLocal = NetworkInterface.getByInetAddress(local);
            if(nwLocal != null){
                System.out.println(nwLocal); // returns the name of network interface
            }
            
            //by name
            NetworkInterface nwName = NetworkInterface.getByName("eth0");
            System.out.println(nwName); // returns the name of network interface
            
            //by index
            NetworkInterface nwIndex = NetworkInterface.getByIndex(1);
            System.out.println(nwIndex);
            
            // list of network iterfaces
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            
            while(interfaces.hasMoreElements()){
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                System.out.println("MAC Address: " + networkInterface.getHardwareAddress());

                System.out.println("IP Addresses:");
                for (var address : networkInterface.getInterfaceAddresses()) {
                    System.out.println("  " + address.getAddress());
                }

                System.out.println("Is Up? " + networkInterface.isUp());
                System.out.println("Is Loopback? " + networkInterface.isLoopback());
                System.out.println("Is Virtual? " + networkInterface.isVirtual());
                System.out.println("Supports Multicast? " + networkInterface.supportsMulticast());

                System.out.println("--------------------");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
