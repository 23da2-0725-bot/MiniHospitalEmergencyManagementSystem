package hospital;

public class Main {

    public static void main(String[] args) {

        // Create Patient Tree
        PatientTree patientTree = new PatientTree();
     // Create Emergency Queue
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();
        VisitLinkedList visitHistory = new VisitLinkedList();
        // Create 8 Patients

        Patient patient1 = new Patient(
                101,
                "Aathif",
                23,
                "0771234567",
                "Fever"
        );

        Patient patient2 = new Patient(
                103,
                "Asloof",
                18,
                "0777654321",
                "Headache"
        );

        Patient patient3 = new Patient(
                102,
                "Ameer",
                50,
                "0712345678",
                "Diabetes"
        );

        Patient patient4 = new Patient(
                105,
                "Abdullah",
                15,
                "0753456789",
                "Asthma"
        );

        Patient patient5 = new Patient(
                104,
                "Thaqi",
                30,
                "0764567890",
                "Heart Pain"
        );

        Patient patient6 = new Patient(
                106,
                "Afeef",
                25,
                "0745678901",
                "Back Pain"
        );

        Patient patient7 = new Patient(
                107,
                "Suja",
                41,
                "0726789012",
                "Migraine"
        );

        Patient patient8 = new Patient(
                108,
                "Rifqi",
                29,
                "0787890123",
                "Stomach Pain"
        );

        // Insert patients into BST

        patientTree.insert(patient1);
        patientTree.insert(patient2);
        patientTree.insert(patient3);
        patientTree.insert(patient4);
        patientTree.insert(patient5);
        patientTree.insert(patient6);
        patientTree.insert(patient7);
        patientTree.insert(patient8);

        // Display all patients

        System.out.println("=================================");
        System.out.println("     HOSPITAL PATIENT RECORDS");
        System.out.println("=================================");

        patientTree.displayPatients();

        // Search Patient

        System.out.println();
        System.out.println("=================================");
        System.out.println("        PATIENT SEARCH");
        System.out.println("=================================");

        Patient result = patientTree.search(101);

        if (result != null) {
            System.out.println("Patient Found!");
            System.out.println("Patient ID: " + result.patientId);
            System.out.println("Patient Name: " + result.patientName);
            System.out.println("Age: " + result.age);
            System.out.println("Contact: " + result.contactNumber);
            System.out.println("Medical Condition: " + result.medicalCondition);
        } else {
            System.out.println("Patient Not Found.");
        }
   
    
        // Delete Patient

        System.out.println();
        System.out.println("=================================");
        System.out.println("        DELETE PATIENT");
        System.out.println("=================================");

        patientTree.delete(105);

        System.out.println("Patient 105 deleted successfully.");

        // Display patients after deletion

        System.out.println();
        System.out.println("=================================");
        System.out.println("   PATIENT RECORDS AFTER DELETE");
        System.out.println("=================================");

        patientTree.displayPatients();  
     // Emergency Patient Queue

        System.out.println();
        System.out.println("=================================");
        System.out.println("       EMERGENCY PATIENT QUEUE");
        System.out.println("=================================");

        // Enqueue patients

        emergencyQueue.enqueue(patient3);
        emergencyQueue.enqueue(patient6);
        emergencyQueue.enqueue(patient8);

        System.out.println("Patients added to emergency queue.");

        // Display queue

        System.out.println();

        System.out.println("Patients currently waiting:");

        emergencyQueue.displayQueue();

        // Dequeue next patient

        System.out.println();

        System.out.println("Next patient for treatment:");

        Patient nextPatient = emergencyQueue.dequeue();

        if (nextPatient != null) {

            System.out.println("Patient ID: " + nextPatient.patientId);

            System.out.println("Patient Name: " + nextPatient.patientName);

            System.out.println("Medical Condition: " + nextPatient.medicalCondition);
        }

        // Display queue after dequeue

        System.out.println();

        System.out.println("Patients remaining in queue:");

        emergencyQueue.displayQueue();
     // Treatment History Stack

        System.out.println();
        System.out.println("=================================");
        System.out.println("       TREATMENT HISTORY");
        System.out.println("=================================");

        treatmentStack.push(patient3);
        treatmentStack.push(patient6);
        treatmentStack.push(patient8);

        System.out.println("Completed treatments added.");

        System.out.println();
        System.out.println("Treatment records:");

        treatmentStack.displayStack();

        System.out.println();
        System.out.println("Most recent treatment:");

        Patient treatedPatient = treatmentStack.pop();

        if (treatedPatient != null) {

            System.out.println("Patient ID: " + treatedPatient.patientId);
            System.out.println("Patient Name: " + treatedPatient.patientName);
            System.out.println("Medical Condition: " + treatedPatient.medicalCondition);
        }

        System.out.println();
        System.out.println("Treatment records after pop:");

        treatmentStack.displayStack();
        System.out.println();
        System.out.println("=================================");
        System.out.println("       EMPTY STACK TEST");
        System.out.println("=================================");

        treatmentStack.pop();
        treatmentStack.pop();

        if (treatmentStack.isEmpty()) {
            System.out.println("Treatment stack is empty.");
         // Patient Visit History

            System.out.println();
            System.out.println("=================================");
            System.out.println("       PATIENT VISIT HISTORY");
            System.out.println("=================================");

            // Create visits

            Visit visit1 = new Visit(
                    1,
                    "2026-08-20",
                    "Dr.SHIBLY",
                    "Fever",
                    "Medication"
            );

            Visit visit2 = new Visit(
                    2,
                    "2026-08-25",
                    "Dr. WAFFA",
                    "Cough",
                    "Medicine"
            );

            Visit visit3 = new Visit(
                    3,
                    "2026-09-01",
                    "Dr. AATHIF AMEER",
                    "Headache",
                    "Rest and Medication"
            );

         // Add visits

            visitHistory.addVisit(visit1);
            visitHistory.addVisit(visit2);
            visitHistory.addVisit(visit3);

            System.out.println("Visits added successfully.");

            System.out.println();
            System.out.println("Patient Visit History:");

            visitHistory.displayVisits();

            // Search Visit

            System.out.println();
            System.out.println("=================================");
            System.out.println("         SEARCH VISIT");
            System.out.println("=================================");

            Visit searchResult = visitHistory.searchVisit(3);

            if (searchResult != null) {

                System.out.println("Visit Found!");
                searchResult.displayVisit();

            } else {

                System.out.println("Visit Not Found.");

            }

            // Remove Visit

            System.out.println();
            System.out.println("=================================");
            System.out.println("         REMOVE VISIT");
            System.out.println("=================================");

            visitHistory.removeVisit(3);

            System.out.println();
            System.out.println("Visit History after removal:");

            visitHistory.displayVisits();
            }
        }


        
    }

