/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit7socketserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;

/**
 *
 * @author DELL
 */
public class DaytimeClient {
    public static void main(String[] args) {
        try{
            Socket client = new Socket("localhost", 6000);
            InputStream in = client.getInputStream();
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
