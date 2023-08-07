/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remainingLab.tcpChat;

import java.io.*;
import java.net.*;

//server side chat
public class ServerSide {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(7676);

            Socket s = ss.accept(); // wait for a client to connect to the server

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = "", str2 = "";
            while (!str.equals("stop")) {
                System.out.println("Waiting for client reply..");
                str = din.readUTF();
                System.out.println("client : "+ str);
                System.out.println("Enter Message:");

                str2 = reader.readLine(); // read a reply from the console

                dout.writeUTF(str2);  // write the reply to the output stream of the socket

                dout.flush();
            }
            din.close();
            dout.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
