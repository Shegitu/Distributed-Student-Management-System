package db;

import model.Student;
import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    // 🔵 ADD STUDENT
    public void addStudent(Student s) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO students (id, name, age, department, gpa) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getDepartment());
            ps.setDouble(5, s.getGpa());

            ps.executeUpdate();

            con.close();

            System.out.println("Student added to DB");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔵 GET ALL STUDENTS
    public ArrayList<Student> getAllStudents() {

        ArrayList<Student> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getDouble("gpa")
                );

                list.add(s);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔵 SEARCH BY ID
    public Student getStudentById(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getDouble("gpa")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 🔵 DELETE STUDENT
    public void deleteStudent(int id) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM students WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            con.close();

            System.out.println("Student deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔵 UPDATE STUDENT
    public void updateStudent(Student s) {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE students SET name=?, age=?, department=?, gpa=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getDepartment());
            ps.setDouble(4, s.getGpa());
            ps.setInt(5, s.getId());

            ps.executeUpdate();

            con.close();

            System.out.println("Student updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}