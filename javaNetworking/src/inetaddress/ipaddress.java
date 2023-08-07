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
public class ipaddress {
    public static void main(String[] args) {
        try{
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println(addr);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
