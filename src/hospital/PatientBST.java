package hospital;

public class PatientBST {

    // Root node of the Binary Search Tree
    PatientNode root;

    // ==========================================
    // INSERT PATIENT
    // ==========================================
    public void insert(Patient patient) {

        PatientNode newNode = new PatientNode(patient);

        // If the tree is empty
        if (root == null) {
            root = newNode;
            return;
        }

        PatientNode current = root;

        while (true) {

            // Smaller Patient ID goes to the left
            if (patient.patientId < current.patient.patientId) {

                if (current.left == null) {
                    current.left = newNode;
                    return;
                }

                current = current.left;

            } else {

                // Larger Patient ID goes to the right
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }

                current = current.right;
            }
        }
    }

    // ==========================================
    // SEARCH PATIENT
    // ==========================================
    public Patient search(int patientId) {

        PatientNode current = root;

        while (current != null) {

            // Patient found
            if (patientId == current.patient.patientId) {
                return current.patient;
            }

            // Search left subtree
            if (patientId < current.patient.patientId) {
                current = current.left;
            }

            // Search right subtree
            else {
                current = current.right;
            }
        }

        // Patient not found
        return null;
    }

    // ==========================================
    // DELETE PATIENT
    // ==========================================
    public void delete(int patientId) {

        root = deleteNode(root, patientId);
    }

    private PatientNode deleteNode(PatientNode root, int patientId) {

        // Patient does not exist
        if (root == null) {
            return null;
        }

        // Search left subtree
        if (patientId < root.patient.patientId) {

            root.left = deleteNode(root.left, patientId);
        }

        // Search right subtree
        else if (patientId > root.patient.patientId) {

            root.right = deleteNode(root.right, patientId);
        }

        // Patient found
        else {

            // Case 1: No children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 3: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 4: Two children
            PatientNode successor = findMin(root.right);

            root.patient = successor.patient;

            root.right = deleteNode(
                    root.right,
                    successor.patient.patientId
            );
        }

        return root;
    }

    // ==========================================
    // FIND MINIMUM NODE
    // ==========================================
    private PatientNode findMin(PatientNode node) {

        PatientNode current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // ==========================================
    // IN-ORDER TRAVERSAL
    // ==========================================
    public void inOrder() {

        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }

        inOrderTraversal(root);
    }

    private void inOrderTraversal(PatientNode node) {

        if (node != null) {

            // Visit left subtree
            inOrderTraversal(node.left);

            // Display patient
            node.patient.displayPatient();

            // Visit right subtree
            inOrderTraversal(node.right);
        }
    }
}