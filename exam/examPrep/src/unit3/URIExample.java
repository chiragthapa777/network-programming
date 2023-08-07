package unit3;

import java.net.URI;
import java.net.URISyntaxException;

public class URIExample {
    public static void main(String[] args) {
        try {
            // Create a URI
            URI uri = new URI("https", "www.example.com:80", "/path/to/resource", "param1=value1&param2=value2", "fragment");

            // Print URI components
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Scheme-specific Part: " + uri.getSchemeSpecificPart());
            System.out.println("Authority: " + uri.getAuthority());
            System.out.println("User Info: " + uri.getUserInfo());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());
            System.out.println("Raw Scheme-specific Part: " + uri.getRawSchemeSpecificPart());
            System.out.println("Raw Authority: " + uri.getRawAuthority());
            System.out.println("Raw User Info: " + uri.getRawUserInfo());
            System.out.println("Raw Path: " + uri.getRawPath());
            System.out.println("Raw Query: " + uri.getRawQuery());
            System.out.println("Raw Fragment: " + uri.getRawFragment());

            // resolving
            URI baseUri = new URI("http://www.example.com");
            URI relativeUri = new URI("/home.html");
            URI resolved = baseUri.resolve(relativeUri);
            URI rr = resolved.relativize(baseUri);
            System.out.println(resolved.toString());
            System.out.println(rr.toString());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
