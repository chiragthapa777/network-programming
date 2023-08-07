package unit3;

import java.net.MalformedURLException;
import java.net.URL;

public class URLEqualityExample {
    public static void main(String[] args) {
        String url1 = "http://www.ibiblio.org";
        String url2 = "http://ibiblio.org";

        try {
            URL urlObj1 = new URL(url1);
            URL urlObj2 = new URL(url2);

            // Check equality using hashCode and equals
            boolean areEqual = urlObj1.hashCode() == urlObj2.hashCode() && urlObj1.equals(urlObj2);

            System.out.println(urlObj1.hashCode());

            if (areEqual) {
                System.out.println("The URLs are equal.");
            } else {
                System.out.println("The URLs are not equal.");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}