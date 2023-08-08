package unit7socketserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RedirectorServer {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(9090);
            while(true){
                Socket client = ss.accept();

                OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());

                out.write("HTTP/1.1 302 Found \r\n Location: http://www.example.com \r\n \r\n");
                out.flush();
                out.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
