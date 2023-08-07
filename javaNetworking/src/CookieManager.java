/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */

import java.net.*;
import java.io.*;
import java.util.*;
public class CookieManager {
     public static void main(String[] args) {
        try {
            // Create a CookieManager and set it as the default CookieHandler
            CookieManager cookieManager = new CookieManager();
            CookieHandler.setDefault(cookieManager);
            
            // Create a URLConnection and make a request
            URL url = new URL("http://example.com/");
            URLConnection connection = url.openConnection();
            connection.getContent();
            
            // Retrieve cookies from the CookieStore
            CookieStore cookieStore = cookieManager.getCookieStore();
            List<HttpCookie> cookies = cookieStore.getCookies();
            
            // Print the cookies
            for (HttpCookie cookie : cookies) {
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
