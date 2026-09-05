package hospital;

public class EmergencyQueue {

    // Queue Node
    private static class QueueNode {

        Patient patient;
        QueueNode next;

        QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    // Constructor
    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    // Enqueue - Add patient to the queue
    public void enqueue(Patient patient) {

        QueueNode newNode = new QueueNode(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue - Remove the next patient for treatment (FIFO)
    public Patient dequeue() {

        if (front == null) {
            System.out.println("No patients waiting in the emergency queue.");
            return null;
        }

        Patient patient = front.patient;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        return patient;
    }

    // Display all waiting patients
    public void displayQueue() {

        if (front == null) {
            System.out.println("No patients are currently waiting in the queue.");
            return;
        }

        QueueNode current = front;

        while (current != null) {

            System.out.println(
                    "Patient ID: " + current.patient.patientId +
                    ", Name: " + current.patient.patientName +
                    ", Age: " + current.patient.age +
                    ", Condition: " + current.patient.medicalCondition
            );

            current = current.next;
        }
    }
}