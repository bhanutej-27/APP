import java.util.Scanner;

class Employee {
    int id;
    String name;
    double monthlySalary;

    Employee(int id, String name, double monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: ₹" + monthlySalary);
    }

    double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    double calculateBonus() {
        if (monthlySalary >= 30000) {
            return calculateAnnualSalary() * 0.10;
        } else {
            return 0;
        }
    }

    void checkBonusEligibility() {
        if (monthlySalary >= 30000) {
            System.out.println("Bonus Eligibility: Eligible");
        } else {
            System.out.println("Bonus Eligibility: Not Eligible");
        }
    }

    void display() {
        displayDetails();

        System.out.println("Annual Salary: ₹" + calculateAnnualSalary());
        System.out.println("Bonus: ₹" + calculateBonus());

        checkBonusEligibility();

        System.out.println();
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Employee " + (i + 1) + ":");

            System.out.print("Employee ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Monthly Salary: ");
            double salary = sc.nextDouble();

            employees[i] = new Employee(id, name, salary);
        }

        System.out.println("\n--- Employee Details ---");

        for (int i = 0; i < 5; i++) {
            employees[i].display();
        }

        sc.close();
    }
}
