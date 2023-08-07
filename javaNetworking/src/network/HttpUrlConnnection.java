package network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 *
 * @author DELL
 */
public class HttpUrlConnnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            HttpURLConnection conn =(HttpURLConnection) url.openConnection();
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
