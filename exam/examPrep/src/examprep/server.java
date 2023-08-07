/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examprep;

/**
 *
 * @author DELL
 */
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
public class server {
       public static void main(String[] args) throws IOException {
        // Create a new HttpServer instance listening on port 2000
        HttpServer server = HttpServer.create(new InetSocketAddress(2000), 0);

        // Set the context path and the handler for incoming requests
        server.createContext("/", new MyHandler());

        // Start the server
        server.start();

        System.out.println("Server started. Listening on port 2000.");
    }
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Get the request method (e.g., GET, POST, etc.)
            String method = exchange.getRequestMethod();

            // Get the request URL
            String url = exchange.getRequestURI().toString();

            // Get the request query parameters
            Map<String, String> queryParams = parseQueryParams(exchange.getRequestURI().getQuery());

            // Get the request body
            String body = getRequestBody(exchange);

            // Log the request details
            System.out.println("Request Method: " + method);
            System.out.println("Request URL: " + url);
            System.out.println("Request Query Parameters: " + queryParams);
            System.out.println("Request Body: " + body);

            // Prepare the response
            String response = "Server says he got method = " +method+" || query = " +queryParams+" || body = "+body;
            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, response.length());

            // Send the response
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }

        // Helper method to parse query parameters into a Map
        private Map<String, String> parseQueryParams(String query) {
            Map<String, String> params = new HashMap<>();
            if (query != null) {
                String[] queryParams = query.split("&");
                for (String param : queryParams) {
                    String[] pair = param.split("=");
                    if (pair.length == 2) {
                        params.put(pair[0], pair[1]);
                    }
                }
            }
            return params;
        }

        // Helper method to read the request body from the InputStream
        private String getRequestBody(HttpExchange exchange) throws IOException {
            StringBuilder requestBody = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    requestBody.append(line);
                }
            }
            return requestBody.toString();
        }
    }
}
