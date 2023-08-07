/*
 * lab7
 */
package network;
import java.net.*;

/**
 *
 * @author DELL
 */
public class urlEquality {
    public static void main(String[] args) {
        try {
            URL u1 = new URL("http://www.example.com");
            URL u2 = new URL("http://example.com");
            if(u1.equals(u2)){
                System.out.println("Both url are same");
            }else{
                System.out.println("Both url are not same");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
