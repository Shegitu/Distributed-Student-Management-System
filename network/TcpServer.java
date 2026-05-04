package network;
 import java.net.*;
 import java.io.*;
 import model.Student;
 public class TcpServer{
public static void main(String[] args){
try{
ServerSocket serverSocket = new ServerSocket(5000);
System.out.println(" Server started on port 5000");

Socket socket = serverSocket.accept();
System.out.println("clinet connected");

ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

while(true){
String command = (String) in.readObject();
System.out.println("Command received: "+ command);

if(command.equals("add")){
    Student student = (Student) in.readObject();
    System.out.println("adding student: " + student);
    out.writeObject("student added");
    out.flush();
    }
    else if(command == "view"){
        
        System.out.println("viewing students");
        out.writeObject("Returning all students");
        out.flush();
    }
else if(command.equals("search")){
    int id =(Integer)in.readObject();
    
    System.out.println("Seaching student wiz id : "+ id);
out.writeObject("student found");
out.flush();
}
else if(command.equals("delete")){
    int id = (Integer) in.readObject();
    System.out.println("deleting student wiz id: "+ id);
    out.writeObject("Student deleted successfully");
    out.flush();
}
 else{
    out.writeObject("Invalid command");
    out.flush();
 }

}
}
catch(Exception e){
    e.printStackTrace();
}

}

}











 }