import javax.swing.*;
import java.awt.*;

class EmployeeModel {

    private String id = "";
    private String name = "";
    private String department = "";

    private String password = "admin123";

    public boolean login(String username, String pass) {
        return username.equals("admin")
                && pass.equals("admin123");
    }

    public void addEmployee(String id,
                             String name,
                             String department) {

        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getEmployee() {

        return "ID: " + id +
               "\nName: " + name +
               "\nDepartment: " + department;
    }

    public boolean changePassword(String oldPassword,
                                   String newPassword,
                                   String confirmPassword) {

        if (!password.equals(oldPassword))
            return false;

        if (!newPassword.equals(confirmPassword))
            return false;

        if (newPassword.isEmpty())
            return false;

        password = newPassword;
        return true;
    }
}

class LoginView extends JFrame {

    JTextField username =
        new JTextField(15);

    JPasswordField password =
        new JPasswordField(15);

    JButton login =
        new JButton("Login");

    LoginView() {

        setTitle("Employee Login");

        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Username:"));
        add(username);

        add(new JLabel("Password:"));
        add(password);

        add(login);

        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

class MainView extends JFrame {

    JMenuItem addEmployee =
        new JMenuItem("Add Employee");

    JMenuItem viewEmployee =
        new JMenuItem("View Employee");

    JMenuItem changePassword =
        new JMenuItem("Change Password");

    JMenuItem logout =
        new JMenuItem("Logout");

    JMenuItem exit =
        new JMenuItem("Exit Application");

    MainView() {

        setTitle("Employee Management Portal");

        JMenuBar menuBar =
            new JMenuBar();

        JMenu employee =
            new JMenu("Employee");

        JMenu tools =
            new JMenu("Tools");

        JMenu exitMenu =
            new JMenu("Exit");

        employee.add(addEmployee);
        employee.add(viewEmployee);

        tools.add(changePassword);

        exitMenu.add(logout);
        exitMenu.add(exit);

        menuBar.add(employee);
        menuBar.add(tools);
        menuBar.add(exitMenu);

        setJMenuBar(menuBar);

        add(new JLabel(
            "Welcome to Employee Management Portal",
            SwingConstants.CENTER
        ));

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

public class EmployeeManagement {

    static EmployeeModel model =
        new EmployeeModel();

    static void showMainWindow() {

        MainView view = new MainView();

        view.addEmployee.addActionListener(e -> {

            JTextField id =
                new JTextField();

            JTextField name =
                new JTextField();

            JTextField department =
                new JTextField();

            Object[] fields = {
                "Employee ID", id,
                "Employee Name", name,
                "Department", department
            };

            int result = JOptionPane.showConfirmDialog(
                view,
                fields,
                "Add Employee",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (result == JOptionPane.OK_OPTION) {

                model.addEmployee(
                    id.getText(),
                    name.getText(),
                    department.getText()
                );

                JOptionPane.showMessageDialog(
                    view,
                    "Employee added successfully."
                );
            }
        });

        view.viewEmployee.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                view,
                model.getEmployee()
            );
        });

        view.changePassword.addActionListener(e -> {

            JPasswordField oldPassword =
                new JPasswordField();

            JPasswordField newPassword =
                new JPasswordField();

            JPasswordField confirmPassword =
                new JPasswordField();

            Object[] fields = {
                "Old Password", oldPassword,
                "New Password", newPassword,
                "Confirm Password", confirmPassword
            };

            int result = JOptionPane.showConfirmDialog(
                view,
                fields,
                "Change Password",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (result == JOptionPane.OK_OPTION) {

                boolean success =
                    model.changePassword(
                        new String(oldPassword.getPassword()),
                        new String(newPassword.getPassword()),
                        new String(confirmPassword.getPassword())
                    );

                if (success)
                    JOptionPane.showMessageDialog(
                        view,
                        "Password changed successfully."
                    );
                else
                    JOptionPane.showMessageDialog(
                        view,
                        "Invalid old password or passwords do not match."
                    );
            }
        });

        view.logout.addActionListener(e -> {

            view.dispose();
            showLoginWindow();
        });

        view.exit.addActionListener(e ->
            System.exit(0)
        );

        view.setVisible(true);
    }

    static void showLoginWindow() {

        LoginView view = new LoginView();

        view.login.addActionListener(e -> {

            String username =
                view.username.getText();

            String password =
                new String(
                    view.password.getPassword()
                );

            if (model.login(username, password)) {

                JOptionPane.showMessageDialog(
                    view,
                    "Login successful"
                );

                view.dispose();
                showMainWindow();

            } else {

                JOptionPane.showMessageDialog(
                    view,
                    "Invalid username or password",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        view.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
            EmployeeManagement::showLoginWindow
        );
    }
}