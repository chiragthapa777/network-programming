package unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*; // java.net.URL
public class UrlExample {
    public static void main(String[] args) {
        try{

            URL u1 = new URL("https://www.example.com");
            URL u2 = new URL("https","www.example.com","/index.html");
            URL u3 = new URL("https", "fourier.dur.ac.uk", 8000, "/");
            URL u4 = new URL(u1,"/index.html");


            //retriving data
            InputStream is = u1.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String c;
            while ((c =br.readLine())!=null){
                System.out.println(c);
            }
            is.close();
            br.close();

            Object o = u1.getContent();
            System.out.println(o.getClass().getName()); // object name

            URLConnection conn = u1.openConnection();
            BufferedReader r = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line = r.readLine())!= null){
                System.out.println(line);
            }
            r.close();



            URL aURL = new URL("http://example.com:80/docs/books/tutorial"
                    + "/index.html?name=networking&type=tryy11#DOWNLOADING");

            System.out.println("protocol = " + aURL.getProtocol());
            System.out.println("authority = " + aURL.getAuthority());
            System.out.println("host = " + aURL.getHost());
            System.out.println("port = " + aURL.getPort());
            System.out.println("path = " + aURL.getPath());
            System.out.println("query = " + aURL.getQuery());
            System.out.println("query name = " + aURL.getQuery().split("&")[0].split("=")[1]);
            System.out.println("filename = " + aURL.getFile());
            System.out.println("ref = " + aURL.getRef());

        }catch (MalformedURLException mu){
            System.out.println("url exception");
        }catch (IOException ie){
            System.out.println("Io exception");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
