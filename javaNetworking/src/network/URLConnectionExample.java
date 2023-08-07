/*
 lab 5
 */
package network;
import java.net.*;
import java.io.*;

/**
 *
 * @author DELL
 */
public class URLConnectionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            URLConnection conn = url.openConnection();
            InputStream stream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
