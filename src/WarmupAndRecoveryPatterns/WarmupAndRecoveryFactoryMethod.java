package WarmupAndRecoveryPatterns;

public class WarmupAndRecoveryFactoryMethod {
    public static void main(String[] args) {
        WarmUpPlan plan1 = WarmUpPlanFactory.createWarmUpPlan("cardio");
        if (plan1 != null) {
            plan1.displayPlanDetails();
        }

        WarmUpPlan plan2 = WarmUpPlanFactory.createWarmUpPlan("strength");
        if (plan2 != null) {
            plan2.displayPlanDetails();
        }

        WarmUpPlan plan3 = WarmUpPlanFactory.createWarmUpPlan("flexibility");
        if (plan3 != null) {
            plan3.displayPlanDetails();
        }
    }
}
