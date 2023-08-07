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
public class getHostAd {
    public static void main(String[] args) {
        try{
          InetAddress me = InetAddress.getLocalHost();
          String dottedQuad = me.getHostAddress();
          System.out.println("My address is "+dottedQuad);
          String hostName = me.getHostName();
            System.out.println("My hostname is "+hostName);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
