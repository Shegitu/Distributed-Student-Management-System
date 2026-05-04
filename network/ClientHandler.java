package network;

import java.net.*;
import java.io.*;
import model.Student;
import service.StudentService;

public class ClientHandler implements Runnable {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    private StudentService service = new StudentService();

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {

            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());

            while (true) {

                String command = (String) in.readObject();

                if (command.equals("add")) {

                    Student student = (Student) in.readObject();
                    String result = service.add(student);

                    out.writeObject(result);
                    out.flush();
                }

                else if (command.equals("view")) {

                    out.writeObject(service.students);
                    out.flush();
                }

                else if (command.equals("search")) {

                    int id = (Integer) in.readObject();
                    Student result = service.search(id);

                    out.writeObject(result);
                    out.flush();
                }

                else if (command.equals("delete")) {

                    int id = (Integer) in.readObject();
                    String result = service.delete(id);

                    out.writeObject(result);
                    out.flush();
                }

                else {

                    out.writeObject("Invalid command");
                    out.flush();
                }
            }

        } catch (Exception e) {
            System.out.println("Client disconnected");
        }
    }
}