package WarmupAndRecoveryPatterns;

public class LogWorkoutCommand implements Command {
    private final WarmUpService service;
    private final String workoutDetails;
    private final String username;

    public LogWorkoutCommand(WarmUpService service, String workoutDetails, String username) {
        this.service = service;
        this.workoutDetails = workoutDetails;
        this.username = username;
    }

    @Override
    public void execute() {
        service.logWorkout(workoutDetails, username);
    }
}
