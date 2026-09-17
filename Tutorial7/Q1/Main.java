package Tutorial7.Q1;

import Tutorial7.Q1.student.Student;
import Tutorial7.Q1.course.Course;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(101, "Bhanu Tej", "Computer Science and Engineering");
        Course course = new Course("CS101", "Java Programming", 4);

        student.displayStudentDetails();
        System.out.println();
        course.displayCourseDetails();
    }
}
