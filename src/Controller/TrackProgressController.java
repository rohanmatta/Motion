package Controller;

import Model.TrackProgress.ProgressData;
import Model.TrackProgress.WorkoutSession;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for tracking user fitness progress.
 * Handles workout session storage, retrieval, and progress analysis.
 */
public class TrackProgressController {

    private List<WorkoutSession> workoutSessions; // Stores user's workout history

    /**
     * Constructor (initializes the controller).
     */
    public TrackProgressController() {
        this.workoutSessions = new ArrayList<>();
        System.out.println("TrackProgressController: Initialized.");
    }

    /**
     * Retrieves the current progress data for a user (latest session).
     */
    public ProgressData getProgress(int userId) {
        System.out.println("TrackProgressController: Retrieving progress for user ID " + userId);

        // Have a stub for progress
        return new ProgressData(userId, 3, 10, 45.0, 300.0, 100.0, "");
    }

    /**
     * Updates progress by logging/creating a new workout session.
     */
    public boolean updateProgress(int userId, ProgressData updatedProgress) {
        System.out.println("TrackProgressController: Updating progress for user ID " + userId);

        // Stub that adds a workout session (that always return true)
        return true;
    }

    /**
     * Retrieves all workout sessions for a user.
     */
    public List<WorkoutSession> getUserWorkoutSessions(int userId) {
        System.out.println("TrackProgressController: Fetching workout sessions for user ID " + userId);

        // Have a stub for a dummy workout session
        List<WorkoutSession> dummySessions = new ArrayList<>();
        dummySessions.add(new WorkoutSession(userId, "Sample Workout", LocalDateTime.now(),
                new ProgressData(userId, 3, 10, 45.0, 300.0, 120.0, "Need to have better form for bench-press")));
        return dummySessions;
    }

    /**
     * Progress trend summary for a user.
     */
    public String getProgressTrends(int userId) {
        System.out.println("TrackProgressController: Analyzing progress trends for user ID " + userId);

        // Stub that returns a dummy progress summary
        return "{Progress Trends}\n"
                + "Total Workouts: 5\n"
                + "Avg Reps per Workout: 12\n"
                + "Avg Sets per Workout: 3\n"
                + "Avg Duration: 35 min\n"
                + "Avg Calories Burned: 280";
    }
}
