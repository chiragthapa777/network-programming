package socketPackage;

import java.net.ServerSocket;

public class socketEx {
    public static void main(String[] args) {
        try{
            ServerSocket sv = new ServerSocket(0);
            System.out.println("The server runs on port " + sv.getLocalPort());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
