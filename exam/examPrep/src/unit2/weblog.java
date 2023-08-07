package unit2;
import java.io.*;
import java.net.*;

public class weblog {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("./log.txt"));
            String line = reader.readLine();

            while (line != null) {
                int index = line.indexOf(" ");
                String ip = line.substring(0,index);
                String rest = line.substring(index);
                try{
                    InetAddress ia = InetAddress.getByName(ip);
                    System.out.println(ia.getHostName() + " " + rest);
                }catch (UnknownHostException e){
                    System.out.println(line);
                }finally {
                    line = reader.readLine();
                }
            }
            reader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
