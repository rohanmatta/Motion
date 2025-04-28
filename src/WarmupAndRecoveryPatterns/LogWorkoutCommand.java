package WarmupAndRecoveryPatterns;

public class LogWorkoutCommand implements Command {
    private WarmUpService service;
    private String workoutDetails;

    public LogWorkoutCommand(WarmUpService service, String workoutDetails) {
        this.service = service;
        this.workoutDetails = workoutDetails;
    }

    @Override
    public void execute() {
        service.logWorkout(workoutDetails);
    }
}
