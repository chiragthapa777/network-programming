/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inetaddress;
import java.net.*;

/**
 *
 * @author DELL
 */
public class getHostNameByIp {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("8.8.8.8");
            System.out.println( "Host name of ip 8.8.8.8 is "+ addr.getCanonicalHostName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
