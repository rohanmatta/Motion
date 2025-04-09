package WarmupAndRecoveryPatterns;

public class WarmUpPlanFactory {
    public static WarmUpPlan createPlan(String type) {
        switch (type.toLowerCase()) {
            case "cardio":
                return new CardioWarmUp();
            case "strength":
                return new StrengthWarmUp();
            case "flexibility":
                return new FlexibilityWarmUp();
            default:
                throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }
}
