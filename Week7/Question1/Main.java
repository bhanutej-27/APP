import student.Student;
import course.Course;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(101, "Bhanu Tej", "Computer Science Engineering");
        Course course = new Course("CSE101", "Java Programming", 4);

        System.out.println("Student Details");
        student.displayDetails();

        System.out.println("\nCourse Details");
        course.displayDetails();
    }
}
