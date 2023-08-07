/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author DELL
 */
public class httpDemo {
    public static void main(String[] args) {
        try {
            // Create the query string with name-value pairs
            String queryString = "name1=" + URLEncoder.encode("value1", "UTF-8")
                    + "&name2=" + URLEncoder.encode("value2", "UTF-8")
                    + "&name3=" + URLEncoder.encode("value3", "UTF-8");

            // Set the URL of the server-side program
            URL url = new URL("http://localhost:2000");

            // Open a connection to the server
            HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
            
            connection.setReadTimeout(300000);
            connection.setRequestMethod("PUT");
            

            // Enable output (i.e., we will write data to the server)
            connection.setDoOutput(true);

            // Write the query string to the OutputStream
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(queryString.getBytes());
            outputStream.close();
            
            System.out.println("resonse code : " + connection.getResponseCode());

            // Read the server response from the InputStream
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println(response.toString());
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
