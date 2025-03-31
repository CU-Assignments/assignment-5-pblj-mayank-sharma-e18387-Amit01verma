import java.io.*;

// Serializable Student class
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student GPA: " + gpa);
    }
}

public class StudentSerialization {
    private static final String FILE_NAME = "student.ser";

    // Serialize Student object
    public static void serializeStudent(Student student) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(student);
            System.out.println("Student details saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    // Deserialize Student object
    public static void deserializeStudent() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Student student = (Student) in.readObject();
            System.out.println("\nReading from file...");
            student.display();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Run serialization first!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading student: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Creating a Student object
        Student student = new Student(101, "John Doe", 3.8);

        // Serialize and Deserialize
        serializeStudent(student);
        deserializeStudent();
    }
}
