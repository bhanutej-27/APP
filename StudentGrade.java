import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Student {
    String name;
    int m1, m2, m3;

    Student(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    double average() {
        return (m1 + m2 + m3) / 3.0;
    }

    String grade() {
        double a = average();

        if (a >= 90) return "A";
        if (a >= 75) return "B";
        if (a >= 60) return "C";
        if (a >= 50) return "D";
        return "F";
    }
}

class StudentView extends JFrame {
    JTextField name = new JTextField();
    JTextField m1 = new JTextField();
    JTextField m2 = new JTextField();
    JTextField m3 = new JTextField();
    JButton calculate = new JButton("Calculate Result");
    JLabel result = new JLabel("Result");

    StudentView() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Student Name"));
        add(name);
        add(new JLabel("Subject 1"));
        add(m1);
        add(new JLabel("Subject 2"));
        add(m2);
        add(new JLabel("Subject 3"));
        add(m3);
        add(calculate);
        add(result);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class StudentController {
    StudentView view;

    StudentController(StudentView view) {
        this.view = view;

        view.calculate.addActionListener(e -> {
            try {
                Student s = new Student(
                    view.name.getText(),
                    Integer.parseInt(view.m1.getText()),
                    Integer.parseInt(view.m2.getText()),
                    Integer.parseInt(view.m3.getText())
                );

                view.result.setText(
                    "Total: " + (s.m1 + s.m2 + s.m3) +
                    " Average: " + String.format("%.2f", s.average()) +
                    " Grade: " + s.grade()
                );
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Enter valid marks");
            }
        });
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        new StudentController(new StudentView());
    }
}