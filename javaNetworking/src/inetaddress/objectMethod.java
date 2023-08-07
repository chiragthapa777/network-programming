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
public class objectMethod {
    public static void main(String[] args) {
        try {
            InetAddress ib = InetAddress.getByName("www.ibilio.org");
            InetAddress ib2 = InetAddress.getByName("helios.ibilio.org");
            if(ib.equals(ib2)){
                System.out.println("www.ibilio.org is same as helios.ibilio.org");
            }else{
                System.out.println("They are not same");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
