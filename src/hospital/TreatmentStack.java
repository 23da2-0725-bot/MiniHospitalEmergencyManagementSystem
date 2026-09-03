package hospital;

public class TreatmentStack {

    private StackNode top;

    // Push completed treatment record
    public void push(Patient patient) {

        StackNode newNode = new StackNode(patient);

        newNode.next = top;
        top = newNode;
    }

    // Pop most recent treatment record
    public Patient pop() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        Patient patient = top.patient;

        top = top.next;

        return patient;
    }

    // Display treatment records
    public void displayStack() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return;
        }

        StackNode current = top;

        System.out.println("Completed Treatment Records:");

        while (current != null) {

            current.patient.displayPatient();

            System.out.println("-----------------------------");

            current = current.next;
        }
    }

    // Check whether stack is empty
    public boolean isEmpty() {

        return top == null;
    }

    // Stack Node
    private static class StackNode {

        Patient patient;
        StackNode next;

        StackNode(Patient patient) {

            this.patient = patient;
            this.next = null;
        }
    }
}