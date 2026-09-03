package hospital;

public class PatientTree {

    private PatientNode root;

    // Insert a new patient
    public void insert(Patient patient) {

        PatientNode newNode = new PatientNode(patient);

        if (root == null) {
            root = newNode;
            return;
        }

        PatientNode current = root;

        while (true) {

            if (patient.patientId < current.patient.patientId) {

                if (current.left == null) {
                    current.left = newNode;
                    break;
                }

                current = current.left;

            } else {

                if (current.right == null) {
                    current.right = newNode;
                    break;
                }

                current = current.right;
            }
        }
    }

    // Search for a patient
    public Patient search(int patientId) {

        PatientNode current = root;

        while (current != null) {

            if (patientId == current.patient.patientId) {
                return current.patient;
            }

            if (patientId < current.patient.patientId) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // Delete a patient
    public void delete(int patientId) {

        root = deleteNode(root, patientId);
    }

    private PatientNode deleteNode(PatientNode node, int patientId) {

        if (node == null) {
            return null;
        }

        if (patientId < node.patient.patientId) {

            node.left = deleteNode(node.left, patientId);

        } else if (patientId > node.patient.patientId) {

            node.right = deleteNode(node.right, patientId);

        } else {

            // No child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Only right child
            if (node.left == null) {
                return node.right;
            }

            // Only left child
            if (node.right == null) {
                return node.left;
            }

            // Two children
            PatientNode successor = findMin(node.right);

            node.patient = successor.patient;

            node.right = deleteNode(
                node.right,
                successor.patient.patientId
            );
        }

        return node;
    }

    // Find the smallest node
    private PatientNode findMin(PatientNode node) {

        PatientNode current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Display patients
    public void displayPatients() {

        if (root == null) {
            System.out.println("No patients available.");
            return;
        }

        displayInOrder(root);
    }

    // In-order traversal
    private void displayInOrder(PatientNode node) {

        if (node == null) {
            return;
        }

        displayInOrder(node.left);

        System.out.println(
            "Patient ID: " + node.patient.patientId +
            ", Name: " + node.patient.patientName +
            ", Age: " + node.patient.age +
            ", Contact: " + node.patient.contactNumber +
            ", Condition: " + node.patient.medicalCondition
        );

        displayInOrder(node.right);
    }
}