import java.util.*;
import java.net.*;
import java.io.*;

class WebServer{
    public static void main(String args[]) throws Exception{
        try{
            ServerSocket server = new ServerSocket(1234);
            int counter = 1;
            while(true){
                Socket client = server.accept();
                System.out.println(counter+"клиент подключен");
                Runnable sct = new MyThreadOther(client);
                Thread t = new Thread(sct);
                t.start();
                counter++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
