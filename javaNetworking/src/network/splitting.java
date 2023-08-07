/*
 * lab 6
 */
package network;
import java.net.*;

/**
 *
 * @author DELL
 */
public class splitting {
    public static void main(String[] args) {
        try{
            String urlString = "https://www.example.com:442/chirag/this.html?param1=value1#here";
            URL url = new URL(urlString);
            
            String protocol = url.getProtocol();
            System.out.println("Protocol : "+protocol);
            
            String host = url.getHost();
            System.out.println("Host : "+host);
            
            System.out.println("Get user info : "+url.getUserInfo());
            System.out.println("getpath : "+url.getPath());
            System.out.println("query : "+url.getQuery());
            System.out.println("getRef : "+url.getRef());
            System.out.println("getAuthority : "+url.getAuthority());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
