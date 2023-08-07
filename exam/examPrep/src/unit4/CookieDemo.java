/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

/**
 *
 * @author DELL
 */
import java.net.*;
import java.util.List;
public class CookieDemo {
    public static void main(String[] args) throws Exception {
        // Create a new CookieManager with a permissive CookiePolicy
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        // Example: Set a list of cookies
        URI uri = new URI("http://example.com");
        HttpCookie cookie1 = new HttpCookie("name", "chirag");
        HttpCookie cookie2 = new HttpCookie("age", "20");

        // Add the cookies to the cookie store associated with the URI
        CookieStore cookieStore = cookieManager.getCookieStore();
        cookieStore.add(uri, cookie1);
        cookieStore.add(uri, cookie2);

        // Example: Remove a specific cookie
        List<HttpCookie> cookies = cookieStore.get(uri);
        for (HttpCookie 
                : cookies) {
            System.out.println("==>"+cookie);
            System.out.println("getDomain = "+cookie.getDomain());
            if (cookie.getName().equals("name")) {
                // Remove the cookie from the cookie store
                cookieStore.remove(uri, cookie);
            }
        }
        
         HttpCookie cookie = new HttpCookie("name", "chirag");
        cookie.setDomain("example.com");
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hour
        cookie.setSecure(true);
        cookie.setHttpOnly(true);

        System.out.println("Name: " + cookie.getName());
        System.out.println("Value: " + cookie.getValue());
        System.out.println("Domain: " + cookie.getDomain());
        System.out.println("Path: " + cookie.getPath());
        System.out.println("Max Age (seconds): " + cookie.getMaxAge());
//        System.out.println("Secure: " + cookie.isSecure());
        System.out.println("HTTP-only: " + cookie.isHttpOnly());
        System.out.println("Version: " + cookie.getVersion());
        System.out.println("Has Expired: " + cookie.hasExpired());
//        System.out.println("Expires (Unix timestamp): " + cookie.getExpires());
    }
}
