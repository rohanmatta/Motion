package Controller;

import Model.WarmupAndRecovery.WarmUpPlan;

public class WarmUpCreateController {
    public WarmUpPlan createPlan(String clientId) {
        return new WarmUpPlan(clientId, "Standard Warmup");
    }
}
