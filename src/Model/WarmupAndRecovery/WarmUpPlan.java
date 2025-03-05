package Model.WarmupAndRecovery;

import java.util.Objects;

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
        // Stub: returning the clientId
        System.out.println("Getting client ID: " + clientId);
        return clientId;
    }

    /**
     * Sets the client ID for this warm-up plan.
     *
     * @param clientId The new unique identifier to be assigned to the client.
     */
    public void setClientId(String clientId) {
        // Stub: setting the clientId
        System.out.println("Setting client ID to: " + clientId);
        this.clientId = clientId;
    }

    /**
     * Retrieves the details of the warm-up plan.
     *
     * @return The details of the plan.
     */
    public String getPlanDetails() {
        // Stub: returning the planDetails
        System.out.println("Getting plan details: " + planDetails);
        return planDetails;
    }

    /**
     * Sets the details of the warm-up plan.
     *
     * @param planDetails The new details to be assigned to the warm-up plan.
     */
    public void setPlanDetails(String planDetails) {
        // Stub: setting the planDetails
        System.out.println("Setting plan details to: " + planDetails);
        this.planDetails = planDetails;
    }

    /**
     * Displays the details of the warm-up plan.
     */
    public void displayPlanDetails() {
        // Stub: simulate displaying details
        System.out.println("Displaying warm-up plan details.");
        System.out.println("Client ID: " + clientId);
        System.out.println("Plan Details: " + planDetails);
    }

    /**
     * Checks if the warm-up plan is empty.
     *
     * @return {@code true} if the client ID or plan details are null or empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
        // Stub: checking if plan is empty
        System.out.println("Checking if the plan is empty.");
        return clientId == null || clientId.isEmpty() || planDetails == null || planDetails.isEmpty();
    }

    /**
     * Updates the details of the warm-up plan.
     *
     * @param details The new details to be set for the warm-up plan.
     */
    public void updatePlanDetails(String details) {
        // Stub: updating plan details
        System.out.println("Updating plan details with: " + details);
        this.planDetails = String.format("Updated Plan: %s", details);
    }

    /**
     * Compares this warm-up plan to another warm-up plan instance for equality.
     *
     * @param other The {@code WarmUpPlan} object to compare with.
     * @return {@code true} if both warm-up plans have the same client ID and details, otherwise {@code false}.
     */
    public boolean equals(WarmUpPlan other) {
        // Stub: comparing plans for equality
        System.out.println("Comparing plans for equality.");
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
        // Stub: returning string representation
        System.out.println("Converting warm-up plan to string.");
        return String.format("WarmUpPlan { clientId='%s', planDetails='%s' }", clientId, planDetails);
    }
}
