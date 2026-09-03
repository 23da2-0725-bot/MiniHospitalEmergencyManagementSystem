package hospital;

public class Treatment {

    private String treatmentId;
    private String treatmentName;
    private double cost;

    public Treatment(String treatmentId, String treatmentName, double cost) {
        this.treatmentId = treatmentId;
        this.treatmentName = treatmentName;
        this.cost = cost;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public double getCost() {
        return cost;
    }

    public void displayTreatment() {
        System.out.println("Treatment ID: " + treatmentId);
        System.out.println("Treatment Name: " + treatmentName);
        System.out.println("Cost: " + cost);
    }
}