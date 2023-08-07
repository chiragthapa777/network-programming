package unit7socketserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer{
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(6767);
            System.out.println("Waiting for client..........");
            Socket client = ss.accept();
            System.out.println("client connected! " +  client.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream( client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            BufferedReader msgCreater = new BufferedReader(new InputStreamReader(System.in));

            String outMsg = "";
            String receivedMsg = "";

            while(!receivedMsg.equals("stop")){

                // receive message
                receivedMsg = in.readUTF();
                System.out.println("received : "+receivedMsg);

                // send message
                System.out.print("Send : ");
                outMsg = msgCreater.readLine();
                out.writeUTF(outMsg);
                out.flush();


            }
            client.close();
            in.close();
            out.close();
            msgCreater.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
