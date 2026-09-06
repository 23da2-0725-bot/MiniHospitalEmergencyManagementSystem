package hospital;

public class TestRunner {

    static int passCount = 0;
    static int failCount = 0;

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("     RUNNING SYSTEM TESTS");
        System.out.println("=================================");

        testPatientBST();
        testEmergencyQueue();
        testTreatmentStack();
        testVisitLinkedList();

        System.out.println();
        System.out.println("=================================");
        System.out.println("Total Passed: " + passCount + " | Total Failed: " + failCount);
        System.out.println("=================================");
    }

    // ==========================================
    // Test 1: Patient BST
    // ==========================================
    static void testPatientBST() {

        System.out.println();
        System.out.println("--- Testing PatientBST ---");

        PatientBST bst = new PatientBST();

        bst.insert(new Patient(101, "Test Patient A", 25, "0771111111", "Fever"));
        bst.insert(new Patient(102, "Test Patient B", 30, "0772222222", "Cough"));

        check("Search existing patient", bst.search(101) != null);
        check("Search non-existing patient", bst.search(999) == null);

        bst.delete(101);
        check("Delete removes patient", bst.search(101) == null);
    }

    // ==========================================
    // Test 2: Emergency Queue
    // ==========================================
    static void testEmergencyQueue() {

        System.out.println();
        System.out.println("--- Testing EmergencyQueue ---");

        EmergencyQueue queue = new EmergencyQueue();

        Patient p1 = new Patient(201, "Queue Patient A", 40, "0773333333", "Injury");
        Patient p2 = new Patient(202, "Queue Patient B", 35, "0774444444", "Burn");

        queue.enqueue(p1);
        queue.enqueue(p2);

        Patient first = queue.dequeue();

        check("Dequeue returns FIFO order (first enqueued)", first != null && first.patientId == 201);

        Patient second = queue.dequeue();

        check("Dequeue returns second patient correctly", second != null && second.patientId == 202);

        Patient empty = queue.dequeue();

        check("Dequeue on empty queue returns null", empty == null);
    }

    // ==========================================
    // Test 3: Treatment Stack
    // ==========================================
    static void testTreatmentStack() {

        System.out.println();
        System.out.println("--- Testing TreatmentStack ---");

        TreatmentStack stack = new TreatmentStack();

        Patient p1 = new Patient(301, "Stack Patient A", 45, "0775555555", "Fracture");
        Patient p2 = new Patient(302, "Stack Patient B", 50, "0776666666", "Sprain");

        stack.push(p1);
        stack.push(p2);

        Patient lastPushed = stack.pop();

        check("Pop returns LIFO order (last pushed)", lastPushed != null && lastPushed.patientId == 302);

        stack.pop();

        check("Stack is empty after popping all records", stack.isEmpty());
    }

    // ==========================================
    // Test 4: Visit Linked List
    // ==========================================
    static void testVisitLinkedList() {

        System.out.println();
        System.out.println("--- Testing VisitLinkedList ---");

        VisitLinkedList history = new VisitLinkedList();

        history.addVisit(new Visit(1, "2026-09-01", "Dr. Test", "Checkup", "Rest"));
        history.addVisit(new Visit(2, "2026--01", "Dr. Test", "Follow-up", "Medication"));

        check("Search finds existing visit", history.searchVisit(1) != null);
        check("Search returns null for missing visit", history.searchVisit(999) == null);

        history.removeVisit(1);

        check("Remove deletes the correct visit", history.searchVisit(1) == null);
        check("List is not empty after removing one visit", !history.isEmpty());
    }

    // ==========================================
    // Helper: Print PASS/FAIL result
    // ==========================================
    static void check(String testName, boolean condition) {

        if (condition) {
            System.out.println("[PASS] " + testName);
            passCount++;
        } else {
            System.out.println("[FAIL] " + testName);
            failCount++;
        }
    }
}