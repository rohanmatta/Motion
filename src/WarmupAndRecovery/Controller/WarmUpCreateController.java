package WarmupAndRecovery.Controller;

import WarmupAndRecovery.Model.WarmUpPlan;

public class WarmUpCreateController {
    public WarmUpPlan createPlan(String clientId) {
        return new WarmUpPlan(clientId, "Standard Warmup");
    }
}
