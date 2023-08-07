/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remainingLab.tcpChat;

/**
 *
 * @author DELL
 */
import java.io.*;
import java.net.*;
//chat program Client side

public class ClientSide {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 7676);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // create buffered reader to read user input from the console
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = "", str2 = "";

            // loop until the user enters "stop"
            while (!str.equals("stop")) {
                System.out.println("Enter Response");

                str = reader.readLine();  // read a line of text from the console

                dout.writeUTF(str);     //write the message to the output stream of the socket   

                dout.flush();  // flush the output stream to ensure the message is sent immediately

                System.out.println("Waiting for server reply..");

                str2 = din.readUTF(); //read a reply from the input stream of the socket

                System.out.println("Server:" + str2);
            }
            dout.close();
            din.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
