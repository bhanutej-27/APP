import doctor.Doctor;
import patient.Patient;

public class Main {
    public static void main(String[] args) {
        Doctor d1 = new Doctor(1, "Dr. Ravi", "Cardiology", 800);
        Doctor d2 = new Doctor(2, "Dr. Priya", "Dermatology", 600);

        Patient p1 = new Patient(101, "Arun", "Heart Disease", 45);
        Patient p2 = new Patient(102, "Meena", "Skin Allergy", 30);
        Patient p3 = new Patient(103, "Kiran", "Heart Disease", 52);

        System.out.println("Patient 1");
        p1.displayDetails();
        System.out.println("Treating Doctor: " + d1.getName() + " - " + d1.getSpecialization());

        System.out.println("\nPatient 2");
        p2.displayDetails();
        System.out.println("Treating Doctor: " + d2.getName() + " - " + d2.getSpecialization());

        System.out.println("\nPatient 3");
        p3.displayDetails();
        System.out.println("Treating Doctor: " + d1.getName() + " - " + d1.getSpecialization());

        int d1Patients = 2;
        int d2Patients = 1;
        System.out.println("\nTotal fee collected by " + d1.getName() + ": " + (d1Patients * d1.getConsultationFee()));
        System.out.println("Total fee collected by " + d2.getName() + ": " + (d2Patients * d2.getConsultationFee()));
    }
}
