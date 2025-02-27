package Model.WarmupAndRecovery;

/**
 * Represents a warm-up plan for a client, containing the client ID and plan details.
 */
public class WarmUpPlan {
    private String clientId;
    private String planDetails;

    /**
     * Constructs a new {@code WarmUpPlan} instance.
     *
     * @param clientId   The unique identifier of the client associated with the plan.
     * @param planDetails The details of the warm-up plan.
     */
    public WarmUpPlan(String clientId, String planDetails) {
        this.clientId = clientId;
        this.planDetails = planDetails;
    }

    /**
     * Retrieves the client ID associated with this warm-up plan.
     *
     * @return The unique identifier of the client.
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets the client ID for this warm-up plan.
     *
     * @param clientId The new unique identifier to be assigned to the client.
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Retrieves the details of the warm-up plan.
     *
     * @return The details of the plan.
     */
    public String getPlanDetails() {
        return planDetails;
    }

    /**
     * Sets the details of the warm-up plan.
     *
     * @param planDetails The new details to be assigned to the warm-up plan.
     */
    public void setPlanDetails(String planDetails) {
        this.planDetails = planDetails;
    }

    /**
     * Displays the details of the warm-up plan.
     */
    public void displayPlanDetails() {
        System.out.println("Client ID: " + clientId);
        System.out.println("Plan Details: " + planDetails);
    }

    /**
     * Checks if the warm-up plan is empty.
     *
     * @return {@code true} if the client ID or plan details are null or empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
        return clientId == null || clientId.isEmpty() || planDetails == null || planDetails.isEmpty();
    }

    /**
     * Updates the details of the warm-up plan.
     *
     * @param details The new details to be set for the warm-up plan.
     */
    public void updatePlanDetails(String details) {
        this.planDetails = String.format("Updated Plan: %s", details);
    }

    /**
     * Compares this warm-up plan to another warm-up plan instance for equality.
     *
     * @param other The {@code WarmUpPlan} object to compare with.
     * @return {@code true} if both warm-up plans have the same client ID and details, otherwise {@code false}.
     */
    public boolean equals(WarmUpPlan other) {
        if (other == null) return false;
        return this.clientId.equals(other.clientId) && this.planDetails.equals(other.planDetails);
    }

    /**
     * Returns a string representation of the warm-up plan object.
     *
     * @return A formatted string containing warm-up plan details.
     */
    @Override
    public String toString() {
        return "WarmUpPlan{" +
                "clientId='" + clientId + '\'' +
                ", planDetails='" + planDetails + '\'' +
                '}';
    }
}
