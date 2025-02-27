package Controller;

import Model.WarmupAndRecovery.WarmUpPlan;

/**
 * Controller class responsible for creating warm-up plans for clients.
 */
public class WarmUpCreateController {

    /**
     * Creates a warm-up plan for a given client.
     *
     * @param clientId The unique identifier of the client.
     * @return A new {@link WarmUpPlan} instance with a standard warm-up routine.
     */
    public WarmUpPlan createPlan(String clientId) {
        return new WarmUpPlan(clientId, "Standard Warmup");
    }
}
