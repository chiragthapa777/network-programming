package unit7socketserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleFileServer {
    public static void main(String[] args) {
        String filePath = "index.html";
        try{
            ServerSocket ss = new ServerSocket(9090);
            while(true){
                Socket client = ss.accept();

                OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());

                BufferedReader r = new BufferedReader(new FileReader(filePath));
                StringBuilder fileContent = new StringBuilder();
                String line;
                while((line=r.readLine())!=null){
                    fileContent.append(line);
                }
                r.close();
                System.out.println(fileContent.toString());

                out.write("HTTP/1.1 200 Ok \r\n Content-Type: text/html \r\n Content-Length:"+fileContent.toString().length()+"\r\n\r\n");
                out.write(fileContent.toString());
                out.flush();
                out.close();

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
