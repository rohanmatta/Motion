package Controller;

import Model.WarmupAndRecovery.WarmUpPlan;

/**
 * Controller class responsible for creating and managing warm-up plans for clients.
 */
public class WarmUpCreateController {

    /**
     * Creates a warm-up plan for a given client.
     *
     * @param clientId The unique identifier of the client.
     * @return A new {@link WarmUpPlan} instance with a standard warm-up routine.
     */
    public WarmUpPlan createPlan(String clientId) {
        System.out.println("Creating warm-up plan for client ID: " + clientId);
        return new WarmUpPlan(clientId, "Standard Warmup");
    }

    /**
     * Updates an existing warm-up plan.
     *
     * @param warmUpPlan The existing {@link WarmUpPlan} to be updated.
     * @param newDetails The new details to be set for the plan.
     */
    public void updatePlan(WarmUpPlan warmUpPlan, String newDetails) {
        // Stub: update the warm-up plan with new details
        System.out.println("Updating warm-up plan with new details: " + newDetails);
        warmUpPlan.updatePlanDetails(newDetails);
    }

    /**
     * Deletes a warm-up plan for a given client.
     *
     * @param clientId The unique identifier of the client whose plan needs to be deleted.
     */
    public void deletePlan(String clientId) {
        // Stub: simulate deleting a warm-up plan
        System.out.println("Deleting warm-up plan for client ID: " + clientId);
    }

    /**
     * Retrieves a warm-up plan for a given client.
     *
     * @param clientId The unique identifier of the client whose plan is to be retrieved.
     * @return The warm-up plan for the specified client.
     */
    public WarmUpPlan getPlan(String clientId) {
        // Stub: simulate retrieving a warm-up plan
        System.out.println("Retrieving warm-up plan for client ID: " + clientId);
        return new WarmUpPlan(clientId, "Standard Warmup"); // Placeholder return
    }

    /**
     * Displays the details of a warm-up plan for a given client.
     *
     * @param warmUpPlan The warm-up plan whose details need to be displayed.
     */
    public void displayPlan(WarmUpPlan warmUpPlan) {
        // Stub: simulate displaying the plan details
        System.out.println("Displaying warm-up plan details.");
        warmUpPlan.displayPlanDetails();
    }
}
