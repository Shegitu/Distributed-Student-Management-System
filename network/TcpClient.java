package network;

import java.net.*;
import java.io.*;

public class TcpClient{
public static void main(String[] args){

try{

Socket socket = new Socket("localhost", 5000);
System.out.println("client connecced to server");

DataOutputStream out = new DataOutputStream(socket.getOutputStream());
DataInputStream in = new DataInputStream(socket.getInputStream());

out.writeUTF("hello ");

String response = in.readUTF();
System.out.println("server said " + response);
in.close();
out.close();
socket.close();
}
catch(Exception e){
    e.printStackTrace();
}






}



}