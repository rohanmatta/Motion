package WarmupAndRecoveryPatterns;

public class WarmUpService {

    public void startWarmUp(String warmupType) {
        System.out.println("Starting " + warmupType + " Warmup...");
    }

    public void logWorkout(String workoutDetails) {
        System.out.println("Logging workout: " + workoutDetails);
    }
}
