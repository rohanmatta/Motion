package Model.WarmupAndRecovery;

public class WarmUpPlan {
    private String clientId;
    private String planDetails;


    public WarmUpPlan(String clientId, String planDetails) {
        this.clientId = clientId;
        this.planDetails = planDetails;
    }

    public String getClientId() {
        return clientId;
    }


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public String getPlanDetails() {
        return planDetails;
    }


    public void setPlanDetails(String planDetails) {
        this.planDetails = planDetails;
    }


    public void displayPlanDetails() {
        System.out.println("Client ID: " + clientId);
        System.out.println("Plan Details: " + planDetails);
    }


    public boolean isEmpty() {
        return clientId == null || clientId.isEmpty() || planDetails == null || planDetails.isEmpty();
    }

    public void updatePlanDetails(String details) {
        this.planDetails = String.format("Updated Plan: %s", details);
    }


    public boolean equals(WarmUpPlan other) {
        if (other == null) return false;
        return this.clientId.equals(other.clientId) && this.planDetails.equals(other.planDetails);
    }


    @Override
    public String toString() {
        return "WarmUpPlan{" +
                "clientId='" + clientId + '\'' +
                ", planDetails='" + planDetails + '\'' +
                '}';
    }
}
