/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit6SocketClient;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author DELL
 */
public class Demo1DayTime {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("time.nist.gov",13);
            
            s.setSoTimeout(30000);
            
            
            System.out.println(s.getRemoteSocketAddress());
            System.out.println(s.getInetAddress());
            System.out.println(s.getPort());
            System.out.println(s.getLocalAddress());
            System.out.println(s.getLocalPort());
            System.out.println(s.isConnected());
            System.out.println(s.isClosed());
            
            
            
            
            InputStream in = s.getInputStream();
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder res = new StringBuilder();
            while((line = r.readLine())!=null){
                res.append(line);
            }
            System.out.println(res); // 60158 23-08-02 03:45:14 50 0 0 862.5 UTC(NIST) * 
            String toParse = res.toString().split(" ")[1] + " " + res.toString().split(" ")[2] + " UTC";
            System.out.println(new SimpleDateFormat("yy-MM-dd hh:mm:ss z").parse(toParse));
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
