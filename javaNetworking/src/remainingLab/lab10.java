/*
 * 1. WAP to scan the running port number from [ 1 to 1024 ] ( low port ) on your local machine,
 */
package remainingLab;

import java.net.*;

/**
 *
 * @author DELL
 */
public class lab10 {

    public static void main(String[] args) { 
        String host = "localhost"; 
        for (int port = 1; port <= 1024; port++) { 
            try { 
                Socket s = new Socket(host, port); 
                System.out.println("Port " + port + " is open"); 
                s.close(); 
            } catch (Exception ex) { 
                System.out.println(ex.getMessage());
            }
        }
    }
}
