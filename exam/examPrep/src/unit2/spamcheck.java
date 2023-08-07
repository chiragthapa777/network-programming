/*
 * For instance, if you want to ask sbl.spamhaus.org if 207.87.34.17 is a spammer, you
would look up the hostname 17.34.87.207.sbl.spamhaus.org
If the DNS query succeeds (and, more specifically, if it returns the address 127.0.0.2),
then the host is known to be a spammer. If the lookup fails—that is, it throws an
UnknownHostException

> java spamcheck 207.87.34.17 130.130.130.130

 */
package unit2;
import java.net.*;

/**
 *
 * @author DELL
 */
public class spamcheck {
    public static void main(String[] args) {

        String[] ips = {"207.87.34.17","130.130.130.130"};

        for(String arg:ips){
            if(isSpammer(arg)){
                System.out.println(arg + " is a known spammer.");
            }else{
                System.out.println(arg + " is not a spammer.");
            }
        }
    }
    public static boolean isSpammer(String arg){
        try{
            String[] splitArr = arg.split("\\.");
            String query = "";
            for(int i = splitArr.length -1; i>=0; i--){
                System.out.println(i);
                query += splitArr[i]+".";
            }
            query += "sbl.spamhaus.org";
            System.out.println("Looking up : "+query);
            InetAddress.getByName(query);
            return true;
        }catch(UnknownHostException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
