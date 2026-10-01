import java.sql.*;
import java.util.Scanner;

public class BookJDBC {

    static final String URL =
        "jdbc:mysql://localhost:3306/librarydb";

    static final String USER = "root";
    static final String PASSWORD = "root";

    static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
            URL, USER, PASSWORD
        );
    }

    static void insertBook(Scanner sc)
            throws SQLException {

        String sql =
            "INSERT INTO Book " +
            "(BookID, Title, Author, Price, Availability) " +
            "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            System.out.print("Book ID: ");
            ps.setInt(1, sc.nextInt());

            sc.nextLine();

            System.out.print("Title: ");
            ps.setString(2, sc.nextLine());

            System.out.print("Author: ");
            ps.setString(3, sc.nextLine());

            System.out.print("Price: ");
            ps.setDouble(4, sc.nextDouble());

            ps.setBoolean(5, true);

            ps.executeUpdate();

            System.out.println(
                "Book inserted successfully."
            );
        }
    }

    static void searchBook(Scanner sc)
            throws SQLException {

        System.out.print("Book ID: ");
        int id = sc.nextInt();

        String sql =
            "SELECT * FROM Book WHERE BookID = ?";

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                    rs.getInt("BookID") + " | " +
                    rs.getString("Title") + " | " +
                    rs.getString("Author") + " | " +
                    rs.getDouble("Price") + " | " +
                    rs.getBoolean("Availability")
                );

            } else {

                System.out.println(
                    "Book not found."
                );
            }
        }
    }

    static void displayAvailableBooks()
            throws SQLException {

        String sql =
            "SELECT * FROM Book " +
            "WHERE Availability = true";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs =
                 st.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                    rs.getInt("BookID") + " | " +
                    rs.getString("Title") + " | " +
                    rs.getString("Author") + " | " +
                    rs.getDouble("Price") +
                    " | Available"
                );
            }
        }
    }

    static void issueBook(Scanner sc)
            throws SQLException {

        System.out.print(
            "Book ID to issue: "
        );

        int id = sc.nextInt();

        String sql =
            "UPDATE Book SET Availability = false " +
            "WHERE BookID = ?";

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println(
                    "Book availability updated to Issued."
                );
            else
                System.out.println(
                    "Book not found."
                );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println(
                "\n1. Insert Book" +
                "\n2. Search Book" +
                "\n3. Display Available Books" +
                "\n4. Issue Book" +
                "\n5. Exit"
            );

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:
                        insertBook(sc);
                        break;

                    case 2:
                        searchBook(sc);
                        break;

                    case 3:
                        displayAvailableBooks();
                        break;

                    case 4:
                        issueBook(sc);
                        break;

                    case 5:
                        return;

                    default:
                        System.out.println(
                            "Invalid choice."
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
}