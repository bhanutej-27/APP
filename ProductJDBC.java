import java.sql.*;
import java.util.Scanner;

public class ProductJDBC {

    static final String URL =
        "jdbc:mysql://localhost:3306/storedb";

    static final String USER = "root";
    static final String PASSWORD = "root";

    static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
            URL, USER, PASSWORD
        );
    }

    static void insertProduct(Scanner sc)
            throws SQLException {

        System.out.print("Product ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Product Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        String sql =
            "INSERT INTO Product " +
            "VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);

            ps.executeUpdate();

            System.out.println(
                "Product inserted successfully."
            );
        }
    }

    static void retrieveProduct(Scanner sc)
            throws SQLException {

        System.out.print("Product ID: ");
        int id = sc.nextInt();

        String sql =
            "SELECT * FROM Product " +
            "WHERE ProductID = ?";

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs =
                ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                    rs.getInt("ProductID") + " | " +
                    rs.getString("ProductName") + " | " +
                    rs.getDouble("Price") + " | " +
                    rs.getInt("Quantity")
                );

            } else {

                System.out.println(
                    "Product not found."
                );
            }
        }
    }

    static void updateQuantity(Scanner sc)
            throws SQLException {

        System.out.print("Product ID: ");
        int id = sc.nextInt();

        System.out.print("New Quantity: ");
        int quantity = sc.nextInt();

        String sql =
            "UPDATE Product SET Quantity = ? " +
            "WHERE ProductID = ?";

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setInt(1, quantity);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println(
                    "Quantity updated successfully."
                );
            else
                System.out.println(
                    "Product not found."
                );
        }
    }

    static void displayLowStock()
            throws SQLException {

        String sql =
            "SELECT * FROM Product " +
            "WHERE Quantity < 10";

        try (Connection con = getConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql);
             ResultSet rs =
                 ps.executeQuery()) {

            System.out.println(
                "Products with quantity below 10:"
            );

            while (rs.next()) {

                System.out.println(
                    rs.getInt("ProductID") + " | " +
                    rs.getString("ProductName") + " | " +
                    rs.getDouble("Price") + " | " +
                    rs.getInt("Quantity")
                );
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println(
                "\n1. Insert Product" +
                "\n2. Retrieve Product" +
                "\n3. Update Quantity" +
                "\n4. Display Low Stock" +
                "\n5. Exit"
            );

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            try {

                if (choice == 1)
                    insertProduct(sc);

                else if (choice == 2)
                    retrieveProduct(sc);

                else if (choice == 3)
                    updateQuantity(sc);

                else if (choice == 4)
                    displayLowStock();

                else if (choice == 5)
                    break;

                else
                    System.out.println(
                        "Invalid choice."
                    );

            } catch (SQLException e) {

                System.out.println(
                    "Database error: " +
                    e.getMessage()
                );
            }
        }
    }
}