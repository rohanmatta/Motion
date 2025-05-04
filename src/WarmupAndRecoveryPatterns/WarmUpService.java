package WarmupAndRecoveryPatterns;

import Model.UserHistoryManager;
import java.time.LocalDate;

public class WarmUpService {

    public void startWarmUp(String warmupType, String username) {
        System.out.println("Starting " + warmupType + " Warmup...");
        UserHistoryManager.log(username, "warmup", warmupType + " routine started", LocalDate.now().toString());
    }

    public void logWorkout(String workoutDetails, String username) {
        System.out.println("Logging workout: " + workoutDetails);
        UserHistoryManager.log(username, "warmup", workoutDetails, LocalDate.now().toString());
    }
}
