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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MutliThreadedServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6000);
            while (true) {
                Socket client = ss.accept();
                Thread t = new DayTimeThread(client);
                t.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static class DayTimeThread extends Thread {
        Logger logger = Logger.getLogger("error");
        private Socket client;

        DayTimeThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                Date now = new Date();
                OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
                out.write(now.toString());
                out.flush();
                client.close();
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage());
            }

        }
    }

}
