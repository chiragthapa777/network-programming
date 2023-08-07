package socketPackage;

import java.net.*;

public class demo1 {
    public static void main(String[] args) {
        String host = "google.com";
        try{

            Socket soc = new Socket(host,80);
            System.out.println("Connected to " + soc.getInetAddress() + " on port "+ soc.getPort() + " from port "+soc.getLocalPort() + " of address " + soc.getLocalAddress());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
