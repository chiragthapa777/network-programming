/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit5;

/**
 *
 * @author DELL
 */
import java.net.*;
import java.io.*;
import java.util.*;
public class UrlConnectionDemo {
    public static void main(String[] args) {
        try{
            // creating a url
            URL u = new URL("http://localhost:2000");
            // opeing a url connection
            URLConnection uc = u.openConnection();
            
            System.out.println("=======Reading specific header fields=======");
            
            System.out.println("Content-Type = "+uc.getContentType());
            System.out.println("Content-Length = " + uc.getContentLength());
            System.out.println("Content-Encoding = "+ uc.getContentEncoding() );
            System.out.println("Expires = " + new Date(uc.getExpiration()));
            System.out.println("Date = "+ new Date(uc.getDate()));
            System.out.println("Last-Modified = " + new Date(uc.getLastModified()));
            
            System.out.println("=======Reading srbitr header fields=======");
            
            System.out.println(uc.getHeaderField("content-type"));
            int index  = 1;
            String data;
            while((data = uc.getHeaderFieldKey(index)) != null ){
                System.out.println(data + " => " + uc.getHeaderField(data));
                index++;
            }
            
            
            System.out.println("============Reading data===============");
            BufferedReader r = new BufferedReader( new InputStreamReader(uc.getInputStream()));
            String line;
            while((line=r.readLine())!=null){
                System.out.println(line);
            }
            r.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
