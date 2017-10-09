package tcpserver;

import java.net.*;
import java.io.*;
class Connection extends Thread
{
	DataInputStream in;
	DataOutputStream out;
        FileOutputStream o;
	Socket clientSocket;
        File myFile = new File("C:\\Users\\User\\Documents\\NetBeansProjects\\TCPServer\\test.pdf");
	public Connection (Socket aClientSocket)
	{
            clientSocket = aClientSocket;
            this.start();
	}
	public void run()
	{
		try {
                        byte[] mybytearray = new byte[(int) myFile.length()];
                        int count;
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
                        OutputStream os = clientSocket.getOutputStream();
                        while((count = bis.read(mybytearray)) >= 0){
                            os.write(mybytearray, 0, count);
                            os.flush();
                        }
                        os.close();
		} catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch (IOException e) {System.out.println("readline:"+e.getMessage());
                }
		finally {
                    try{
                        clientSocket.close();}catch(IOException e){/*close failed*/}              }
	}
}