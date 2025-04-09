package WarmupAndRecoveryPatterns;

public class WarmupAndRecoveryFactoryMethod {
    public static void main(String[] args) {
        WarmUpPlan plan1 = WarmUpPlanFactory.createPlan("cardio");
        plan1.showPlan();

        WarmUpPlan plan2 = WarmUpPlanFactory.createPlan("strength");
        plan2.showPlan();

        WarmUpPlan plan3 = WarmUpPlanFactory.createPlan("flexibility");
        plan3.showPlan();
    }
}
