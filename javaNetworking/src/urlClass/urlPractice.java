package urlClass;
import java.net.*;
public class urlPractice {
    public static void main(String[] args) {
        String urlStr = args.length > 0 ? args[0] : "http://www.example.com";
        try{
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println("Request Method : " + conn.getRequestMethod());
            System.out.println("Response Code : " + conn.getResponseCode());
            System.out.println("Response Message : " + conn.getResponseMessage());
            System.out.println("Content Type : " + conn.getContentType());
            System.out.println("Last Modified : " + conn.getLastModified());
            System.out.println("Header Field : " + conn.getHeaderField("Content-Type"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
