package network;
import java.net.*;
import java.io.*;
public class TcpServer {
    public static void main(String[] args){
    try{
ServerSocket serversocket = new ServerSocket(5000);
System.out.println("server started");

Socket socket = serversocket.accept();
System.out.println(" client connected");

DataInputStream in = new DataInputStream(socket.getInputStream());

DataOutputStream out = new DataOutputStream(socket.getOutputStream());
String message = in.readUTF();
System.out.println("client" + message);
out.writeUTF("hy hy");
in.close();
out.close();
socket.close();
serversocket.close();

    }
catch(Exception e){
    e.printStackTrace();
}


    } }
