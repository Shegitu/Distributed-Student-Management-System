package file;

import java.io.*;
import java.util.ArrayList;
import model.Student;

public class FileHandler {

    private final String FILE_PATH = "data/students.dat";

    // 🔵 SAVE STUDENTS TO FILE
    public void save(ArrayList<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(students);

            oos.close();
            fos.close();

            System.out.println("Data saved to file.");

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // 🔵 LOAD STUDENTS FROM FILE
    public ArrayList<Student> load() {

        ArrayList<Student> students = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);

            students = (ArrayList<Student>) ois.readObject();

            ois.close();
            fis.close();

            System.out.println("Data loaded from file.");

        } catch (FileNotFoundException e) {
            System.out.println("No file found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        return students;
    }
}