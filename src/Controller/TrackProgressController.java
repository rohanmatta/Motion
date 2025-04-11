package Controller;

import Model.TrackProgress.ProgressData;
import Model.TrackProgress.WorkoutSession;
import Model.TrackProgress.ProgressSubject;
import View.TrackProgress.TrackProgressView;
import Observer.Subject;  // Import Subject from your Observer package

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for tracking user fitness progress.
 * Handles workout session storage, retrieval, progress analysis, and observer pattern integration.
 */
public class TrackProgressController {

    private List<WorkoutSession> workoutSessions; // Stores user's workout history

    // Observer Pattern related members:
    private ProgressSubject progressSubject;
    private TrackProgressView progressView;

    /**
     * Constructor (initializes the controller).
     */
    public TrackProgressController() {
        this.workoutSessions = new ArrayList<>();

        // Initialize with dummy progress data.
        ProgressData initialData = new ProgressData(1, 3, 10, 45.0, 300.0, 100.0, "Initial data");
        progressSubject = new ProgressSubject(initialData);

        // Create the view and register it as an observer to the progress subject.
        progressView = new TrackProgressView();
        progressSubject.registerObserver(progressView);

        System.out.println("TrackProgressController: Initialized and Observer pattern integrated.");
    }

    /**
     * Retrieves the current progress data for a user (latest session).
     */
    public ProgressData getProgress(int userId) {
        System.out.println("TrackProgressController: Retrieving progress for user ID " + userId);
        return progressSubject.getProgressData();
    }

    /**
     * Updates progress by logging/creating a new workout session.
     * Notifies all observers of the updated progress.
     */
    public boolean updateProgress(int userId, ProgressData updatedProgress) {
        System.out.println("TrackProgressController: Updating progress for user ID " + userId);
        // Update the progress subject; this will notify the TrackProgressView observer.
        progressSubject.setProgressData(updatedProgress);
        // You can also add the new workout session to workoutSessions if desired.
        return true;
    }

    /**
     * Retrieves all workout sessions for a user.
     */
    public List<WorkoutSession> getUserWorkoutSessions(int userId) {
        System.out.println("TrackProgressController: Fetching workout sessions for user ID " + userId);
        // Stub for a dummy workout session.
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
        // Stub that returns a dummy progress summary.
        return "{Progress Trends}\n"
                + "Total Workouts: 5\n"
                + "Avg Reps per Workout: 12\n"
                + "Avg Sets per Workout: 3\n"
                + "Avg Duration: 35 min\n"
                + "Avg Calories Burned: 280";
    }
}
