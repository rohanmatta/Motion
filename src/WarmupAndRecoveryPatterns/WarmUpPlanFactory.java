package WarmupAndRecoveryPatterns;

public class WarmUpPlanFactory {

    public static WarmUpPlan createWarmUpPlan(String type) {
        if (type.equalsIgnoreCase("Cardio")) {
            return new CardioWarmUp();
        } else if (type.equalsIgnoreCase("Strength")) {
            return new StrengthWarmUp();
        } else if (type.equalsIgnoreCase("Flexibility")) {
            return new FlexibilityWarmUp();
        } else {
            return null; // No matching plan
        }
    }
}
