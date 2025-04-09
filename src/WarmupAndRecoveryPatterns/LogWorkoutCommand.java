package WarmupAndRecoveryPatterns;

public class LogWorkoutCommand implements Command {
    private ProgressTracker tracker;

    public LogWorkoutCommand(ProgressTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public void execute() {
        tracker.logWorkout();
    }
}
