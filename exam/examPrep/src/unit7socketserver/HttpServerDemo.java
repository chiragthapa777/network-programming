package unit7socketserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class HttpServerDemo {

    public HttpServerDemo() {
        try {
            ServerSocket app = new ServerSocket(8081);
            while (true) {
                this.serveClient(app);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void serveClient(ServerSocket app) throws Exception {
        Socket client = app.accept();
        System.out.println("Client connected : " + client.getInetAddress().getHostAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        // Read and process the entire HTTP request
        StringBuilder requestBuilder = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            requestBuilder.append(line).append("\r\n");
        }
        String request = requestBuilder.toString();

        System.out.println(request.toString());

        String method = request.split(" ")[0]; // GET POST PUT DELETE
        String path = request.split(" ")[1]; // /path?query=value

        switch (method) {
            case "GET": {
                this.handleGet(client, path);
                break;
            }
            case "POST": {
                this.handlePost(client, path, request.toString());
                break;
            }
        }
    }

    public void handleGet(Socket client, String path) throws Exception {
        OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
        String data = "<html>" +
                "<head>" +
                "<title>title</title>" +
                "</head>" +
                "<body>"
                + path +
                "<body>" +
                "<html>";
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + data.length() + "\r\n" +
                "\r\n" + data;
        ;
        out.write(response);
        out.flush();
    }
    public void handlePost(Socket client, String path, String request) throws Exception {
        OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
        int bodyStart = request.indexOf("\r\n\r\n") + 4; // Find the start of the body
        String requestBody = request.substring(bodyStart);

        String data = "<html>" +
                "<head>" +
                "<title>title</title>" +
                "</head>" +
                "<body>"
                + requestBody +
                "<body>" +
                "<html>";
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + data.length() + "\r\n" +
                "\r\n" + data;
        ;
        out.write(response);
        out.flush();
    }

    public static void main(String[] args) {
        new HttpServerDemo();
    }
}
