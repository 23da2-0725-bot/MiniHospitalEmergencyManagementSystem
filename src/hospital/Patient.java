package hospital;

public class Patient {

    // Patient information
    int patientId;
    String patientName;
    int age;
    String contactNumber;
    String medicalCondition;

    // Patient's previous visit history
    VisitLinkedList visitHistory;

    // Constructor
    public Patient(int patientId, String patientName, int age,
                   String contactNumber, String medicalCondition) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;

        // Create an empty visit history for this patient
        this.visitHistory = new VisitLinkedList();
    }

    // Display patient details
    public void displayPatient() {

        System.out.println("----------------------------------------");
        System.out.println("Patient ID        : " + patientId);
        System.out.println("Patient Name      : " + patientName);
        System.out.println("Age               : " + age);
        System.out.println("Contact Number    : " + contactNumber);
        System.out.println("Medical Condition : " + medicalCondition);
        System.out.println("----------------------------------------");
    }
}
