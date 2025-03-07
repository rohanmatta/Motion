package View.TrackProgress;

import Controller.TrackProgressController;
import Model.TrackProgress.ProgressData;
import Model.TrackProgress.WorkoutSession;

import java.time.LocalDateTime;

/**
 * Provides UI for logging a new workout session (Stubbed).
 */
public class LogWorkoutView {
    private TrackProgressController trackProgressController;

    /**
     * Constructor to initialize LogWorkoutView with a controller.
     */
    public LogWorkoutView(TrackProgressController trackProgressController) {
        this.trackProgressController = trackProgressController;
        System.out.println("LogWorkoutView: Initialized.");
    }

    /**
     * Stub method for displaying a workout log form (No actual user input).
     */
    public void displayWorkoutLogForm() {
        System.out.println("LogWorkoutView: Simulating workout logging...");

        // Stub: Use predefined values instead of user input
        String workoutName = "Bench Press";
        int sets = 3;
        int reps = 10;
        double duration = 45.0;
        double caloriesBurned = 350.0;
        double weightLifted = 100.0;
        String notes = "Felt strong today!";

        // Stub: Create a dummy ProgressData and WorkoutSession
        ProgressData progressData = new ProgressData(1, sets, reps, duration, caloriesBurned, weightLifted, notes);
        WorkoutSession workoutSession = new WorkoutSession(1, workoutName, LocalDateTime.now(), progressData);

        // Stub: Simulate sending data to the controller
        System.out.println("LogWorkoutView: Sending workout data to controller...");
        trackProgressController.updateProgress(1, progressData);

        // Stub: Print success message
        System.out.println("LogWorkoutView: Workout logged successfully (Stub).");
    }
}
