import java.util.Scanner;

class Patient {
    String name;
    double consultationFee;

    Patient(String name, double consultationFee) {
        this.name = name;
        this.consultationFee = consultationFee;
    }

    double calculateFinalAmount(double fee) {
        double discount;

        if (fee >= 2000) {
            discount = fee * 0.10;
        } else {
            discount = fee * 0.05;
        }

        return fee - discount;
    }

    void display() {
        double finalAmount = calculateFinalAmount(consultationFee);
        double discount = consultationFee - finalAmount;

        System.out.println("Patient Name: " + name);
        System.out.println("Original Consultation Fee: ₹" + consultationFee);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Final Amount: ₹" + finalAmount);
        System.out.println();
    }
}

public class HospitalBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Patient[] patients = new Patient[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Patient " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Consultation Fee: ");
            double fee = sc.nextDouble();

            sc.nextLine();

            patients[i] = new Patient(name, fee);
        }

        System.out.println("\n--- Consultation Bill ---");

        for (int i = 0; i < 5; i++) {
            patients[i].display();
        }

        sc.close();
    }
}
