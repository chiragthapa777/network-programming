/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit2;

import java.net.*;

/**
 *
 * @author DELL
 */
public class inetAddressExample {
    public static void main(String[] args) {
        try{
            
            //creating inetadress
            //returns ip address and host name of the host name
            InetAddress addr = InetAddress.getByName("www.example.com");
            System.out.println(addr);
            
            
            InetAddress addr2 = InetAddress.getLocalHost();
            System.out.println(addr2);
            
            InetAddress addr3 = InetAddress.getLoopbackAddress();
            System.out.println(addr3);
            
            InetAddress[] addrs = InetAddress.getAllByName("www.example.com");
            for(InetAddress ad : addrs){
                System.out.println(ad);
            }
            
            //getter methids for inet
            
            System.out.println("canonical : "+addr.getCanonicalHostName());
            System.out.println("getaddress : "+addr.getAddress());
            System.out.println("gethostaddress : "+addr.getHostAddress());
            System.out.println("getHostname : "+addr.getHostName());
            
            
        }catch(UnknownHostException e){
            System.out.println(e.getMessage());
        }
    }
    
}
