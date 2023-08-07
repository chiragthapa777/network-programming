/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit7socketserver;

/**
 *
 * @author DELL
 */
import java.net.*;
import java.io.*;
import java.util.Date;

public class DayTime {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6000);
            while (true) {
                Socket client = ss.accept();
                Date now = new Date();
                OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
                out.write(now.toString());

                // if binary data to be sent               
//                OutputStream out = client.getOutputStream();
//                byte[] binary = now.toString().getBytes();
//                out.write(binary);
                out.flush();
                client.close();
            }
        } catch (Exception e) {

        }

    }
}
