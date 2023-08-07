package unit7socketserver;

import java.io.*;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("192.168.1.81",6767);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            BufferedReader msgCreater = new BufferedReader(new InputStreamReader(System.in));

            String outMsg = "";
            String receivedMsg = "";

            while(!outMsg.equals("stop")){
                // send message
                System.out.print("Send : ");
                outMsg = msgCreater.readLine();
                out.writeUTF(outMsg);
                out.flush();

                // receive message
                receivedMsg = in.readUTF();
                System.out.println("received : "+receivedMsg);
            }
            s.close();
            in.close();
            out.close();
            msgCreater.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
