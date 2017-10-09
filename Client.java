package client;

import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {
        Socket clientSocket;
        String tcpserver = "127.0.0.1";
        DataInputStream input;
        try {
            clientSocket = new Socket(tcpserver,7996);
            byte[] mybytearray = new byte[(int) Math.pow(2,22)];
            int count;
            InputStream is = clientSocket.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\Client\\testClient.pdf");
            while((count = is.read(mybytearray)) >= 0){
		fos.write(mybytearray, 0, count);
                System.out.println("lol");
            }
            fos.close();
            clientSocket.close();
        } catch (IOException e) {System.out.println(e.getMessage());}
    }
}
