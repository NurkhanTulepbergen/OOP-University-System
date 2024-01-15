package OOPProject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Proverka {
    public static void main(String[] args) {
        // Create a list of students for serialization
        List<Student> students = new ArrayList<>();


        // Serialization
        //serializeStudents(students);

        // Print the details of students from the file
        printStudentsFromFile("students.ser");
    }

    // Method for serializing a list of students
    private static void serializeStudents(List<Student> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            oos.writeObject(students);
            System.out.println("Serialization successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for printing details of students from the file
    private static void printStudentsFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Student> students = (List<Student>) ois.readObject();
            System.out.println("Students from the file:");
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}