package urlClass;

import java.net.*;

public class UrlConnection {
    public static void main(String[] args) {
        String fileName = "example.css";
        String contentType = URLConnection.guessContentTypeFromName(fileName);
        System.out.println("Content-Type:"+contentType);

    }
}
