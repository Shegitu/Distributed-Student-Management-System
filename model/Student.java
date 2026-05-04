package  model;
import java.io.Serializable;


public class Student {
    implements Serializable;
    private int id;
    private String name;
   private  int age;
    private String department;
   private  double gpa;

   public Student(int id,
    String name,
    int age,
    String department,
    double gpa){
    this.id = id;
    this.name = name;
    this.age = age;
    this.department = department;
    this.gpa = gpa;
   }

public int getAge(){
    return age;
}

public void setAge(int age){
    this.age = age;
}

public String getName(){
    return name;
}
public void setName(String name){
    this.name = name;
}
public String getDepartment(){
    return department;
}
public void setDepartment(String department){
    this.department = department;
}
public double getGpa(){
    return gpa;
}

public void setGpa(double gpa){
    this.gpa = gpa;
}


@Override
public String toString(){
    return "ID: " + id +
       " | Name: " + name +
       " | Department: " + department +
       " | GPA: " + gpa +
       " | Age: " + age;

}
}