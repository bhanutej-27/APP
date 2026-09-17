package Tutorial7.Q2;

import Tutorial7.Q2.doctor.Doctor;
import Tutorial7.Q2.patient.Patient;

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor(1, "Dr. Ravi", "Cardiologist", 800);
        Doctor doctor2 = new Doctor(2, "Dr. Priya", "Dermatologist", 600);

        Patient patient1 = new Patient(101, "Arun", "Heart Disease", 45);
        Patient patient2 = new Patient(102, "Kiran", "Skin Allergy", 28);
        Patient patient3 = new Patient(103, "Rahul", "Heart Disease", 52);

        Doctor[] assignedDoctors = { doctor1, doctor2, doctor1 };
        Patient[] patients = { patient1, patient2, patient3 };

        int doctor1Patients = 0;
        int doctor2Patients = 0;

        for (int i = 0; i < patients.length; i++) {
            System.out.println("Patient " + (i + 1));
            patients[i].displayPatientDetails();
            System.out.println("Treating Doctor:");
            assignedDoctors[i].displayDoctorDetails();
            System.out.println("----------------------------");

            if (assignedDoctors[i] == doctor1) {
                doctor1Patients++;
            } else {
                doctor2Patients++;
            }
        }

        System.out.println("Total Consultation Fee Collected");
        System.out.println(doctor1.getName() + ": " + (doctor1Patients * doctor1.getConsultationFee()));
        System.out.println(doctor2.getName() + ": " + (doctor2Patients * doctor2.getConsultationFee()));
    }
}
