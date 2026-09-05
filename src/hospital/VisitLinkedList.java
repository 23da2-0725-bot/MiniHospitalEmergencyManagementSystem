package hospital;

public class VisitLinkedList {

    private VisitNode head;

    // Add a new visit to the end of the patient's visit history
    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
        } else {

            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    // Display the patient's full visit history
    public void displayVisits() {

        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        VisitNode current = head;

        while (current != null) {
            current.visit.displayVisit();
            System.out.println("-----------------------------");
            current = current.next;
        }

    }

    // Remove a visit using Visit ID
    public void removeVisit(int visitId) {

        if (head == null) {

            System.out.println("No visit history available.");
            return;
        }

        // Remove first visit
        if (head.visit.visitId == visitId) {

            head = head.next;

            System.out.println("Visit " + visitId + " removed successfully.");

            return;
        }

        VisitNode current = head;

        while (current.next != null) {

            if (current.next.visit.visitId == visitId) {

                current.next = current.next.next;

                System.out.println("Visit " + visitId + " removed successfully.");

                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // Search for a visit using Visit ID
    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.visitId == visitId) {

                return current.visit;
            }

            current = current.next;
        }

        System.out.println("Visit ID " + visitId + " not found in visit history.");

        return null;
    }

    // Check whether visit history is empty
    public boolean isEmpty() {

        return head == null;
    }
}
