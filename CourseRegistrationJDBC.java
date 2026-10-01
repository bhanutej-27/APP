import java.sql.*;
import java.util.Scanner;

public class CourseRegistrationJDBC {

    static final String URL =
        "jdbc:mysql://localhost:3306/collegedb";

    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print(
            "Enter Course Code: "
        );

        String courseCode = sc.nextLine();

        String sql =
            "SELECT StudentID, StudentName, " +
            "CourseCode, CourseName, Semester " +
            "FROM CourseRegistration " +
            "WHERE CourseCode = ?";

        try (
            Connection con =
                DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
                );

            PreparedStatement ps =
                con.prepareStatement(sql)
        ) {

            ps.setString(1, courseCode);

            ResultSet rs =
                ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                    "Student ID: " +
                    rs.getInt("StudentID")
                );

                System.out.println(
                    "Student Name: " +
                    rs.getString("StudentName")
                );

                System.out.println(
                    "Course Code: " +
                    rs.getString("CourseCode")
                );

                System.out.println(
                    "Course Name: " +
                    rs.getString("CourseName")
                );

                System.out.println(
                    "Semester: " +
                    rs.getInt("Semester")
                );

                System.out.println();
            }

            if (!found) {

                System.out.println(
                    "No students registered for " +
                    "course code: " + courseCode
                );
            }

        } catch (SQLException e) {

            System.out.println(
                "Database error: " +
                e.getMessage()
            );
        }
    }
}