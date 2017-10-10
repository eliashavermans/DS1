package tcpserver;

import java.net.*;
import java.io.*;

//java -jar C:\Users\User\Documents\NetBeansProjects\TCPServer\dist\TCPServer.jar
//java -jar C:\Users\User\Documents\NetBeansProjects\Client\dist\Client.jar
public class TCPServer
{
	public static void main (String args[])
	{
		try
		{
			int serverPort = 7996;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true)
			{
				Socket clientSocket = listenSocket.accept();
				Connection c = new Connection(clientSocket);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
}
