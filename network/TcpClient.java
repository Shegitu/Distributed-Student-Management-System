package network;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import model.Student;

public class TcpClient{
    static Socket socket;
    static ObjectOutputStream out;
    static ObjectInputStream in;


public static void main(String[] args){

try{

 socket = new Socket("localhost", 5000);
System.out.println("client connecced to server");

 out = new ObjectOutputStream(socket.getOutputStream());
in = new ObjectInputStream(socket.getInputStream());

    Thread listener = new Thread(){
public void run(){
    try{

while(true){
  Object response = in.readObject();
  System.out.println("server" + response);
  System.out.println("Choose option: ");
}
    }catch(Exception e){
        System.out.println("Connection closed");
            } } };
            listener.start();
            menu();
        } catch(Exception e){
            e.printStackTrace();
        } }


public static void menu(){
    Scanner s = new Scanner(System.in);

    while(true){
        try{
System.out.println("\nMENU");
System.out.println("1. add student");
System.out.println("2. view studnet");
System.out.println("3. search student");
System.out.println("4. delete student");
System.out.println("5. exit");

System.out.println("Enter ur choice: ");
int choice = s.nextInt();

if(choice == 1){
    System.out.println("id: ");
    int id = s.nextInt();
    s.nextLine();
System.out.println("Name: ");
String name = s.nextLine();
System.out.println("Age: ");
int age = s.nextInt();
s.nextLine();
System.out.println("Department: ");
String dept = s.nextLine();
System.out.println("Gpa: ");
double gpa = s.nextDouble();

Student student = new Student(id, name, age, dept, gpa);

out.writeObject("ADD");
out.writeObject(student);
out.flush(); 


} else if(choice ==2){
    
    out.writeObject("view");
    out.flush();
}
else if(choice == 3){
System.out.println("enter id: ");
int id = s.nextInt();
out.writeObject("search");
out.writeObject(id);
out.flush();
}
else if(choice ==4){
    System.out.println("enter id: ");
    int id = s.nextInt();
    out.writeObject("Delete");
    out.writeObject(id);
    out.flush();
}
   else if(choice ==5){
    System.out.println("exiting");
    socket.close();
    break;
   }
   else{
    System.out.println("invalid input");
   } }
catch(Exception e){
    e.printStackTrace();
}}

}
}


