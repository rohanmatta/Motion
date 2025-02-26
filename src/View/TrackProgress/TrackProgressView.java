package View.TrackProgress;

import Controller.TrackProgressController;
import Model.TrackProgress.WorkoutSession;
import java.util.List;

/**
 * Displays past workout sessions and progress trends.
 */
public class TrackProgressView {
    private TrackProgressController trackProgressController;

    /**
     * Constructor to initialize TrackProgressView with a controller.
     */
    public TrackProgressView(TrackProgressController trackProgressController) {
        this.trackProgressController = trackProgressController;
    }

    /**
     * Displays past workout sessions.
     */
    public void displayPastWorkouts() {
        List<WorkoutSession> workoutSessions = trackProgressController.getUserWorkoutSessions(1); // Fetch user's workout history

        if (workoutSessions.isEmpty()) {
            System.out.println("No workouts logged yet.");
            return;
        }

        System.out.println("=== Your Workout History ===");
        for (WorkoutSession session : workoutSessions) {
            System.out.println("Workout: " + session.getWorkoutName());
            System.out.println("Date: " + session.getSessionDate());
            System.out.println("Sets: " + session.getProgressData().getSets());
            System.out.println("Reps: " + session.getProgressData().getReps());
            System.out.println("Duration: " + session.getProgressData().getDuration() + " minutes");
            System.out.println("Calories Burned: " + session.getProgressData().getCaloriesBurned());
            System.out.println("---------------------------------");
        }
    }

    /**
     * Displays progress trends over time.
     */
    public void displayProgressTrends() {
        String progressTrends = trackProgressController.getProgressTrends(1); // Fetch user's progress analysis
        System.out.println("=== Progress Trends ===");
        System.out.println(progressTrends);
    }
}
