/*
 * 1. WAP to find the socket address info about local host and remote host .
Remote host : www.example.com
Remote Port : 80
 */
package remainingLab;

/**
 *
 * @author DELL
 */
import java.net.*;
import java.io.*;
public class lab11 {

    public static void main(String[] args) {
        try {
            Socket toSocket = new Socket("www.example.com", 80);
            System.out.println("Connected to " + toSocket.getInetAddress()
                    + " on port " + toSocket.getPort()
                    + " from port " + toSocket.getLocalPort()
                    + " of " + toSocket.getLocalAddress());
        } catch (IOException ex) {
            System.err.println(ex);

        }
    }
}
