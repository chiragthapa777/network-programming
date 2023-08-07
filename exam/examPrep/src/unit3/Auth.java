package unit3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class Auth extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Auth() {
        // Create the username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        // Create the password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        // Create a login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        // Create the layout for the JFrame and add components
        setLayout(new FlowLayout());
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Auth");
        setVisible(true);
        setSize(500,500);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        System.out.println(username + password);

        // Set the default authenticator
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        });

        // URL and connection setup
        String urlString = "http://example.com";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            System.out.println("Response: " + response.toString());

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Auth();
    }
}