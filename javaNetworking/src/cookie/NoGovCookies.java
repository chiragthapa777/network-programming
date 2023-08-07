package cookie;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URL;

public class NoGovCookies implements CookiePolicy {

    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        if(uri.getAuthority().endsWith(".gov") && cookie.getDomain().endsWith(".gov")){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        try {
            NoGovCookies ng = new NoGovCookies();
            URL uri = new URL("https://nepal.gov.np");
            HttpCookie hc = new HttpCookie("key","value");
            boolean flag = ng.shouldAccept(uri.toURI(),hc);
            System.out.println(flag);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
