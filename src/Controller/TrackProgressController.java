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
     * Constructor to initialize the controller.
     */
    public TrackProgressController() {
        this.workoutSessions = new ArrayList<>();
    }

    /**
     * Retrieves the current progress data for a user (latest session).
     * @param userId The unique identifier of the user.
     * @return ProgressData object containing the most recent workout progress metrics.
     */
    public ProgressData getProgress(int userId) {
        for (int i = workoutSessions.size() - 1; i >= 0; i--) {
            if (workoutSessions.get(i).getUserId() == userId) {
                return workoutSessions.get(i).getProgressData();
            }
        }
        return null; // No progress found
    }

    /**
     * Updates progress by logging a new workout session.
     * @param userId The user's ID.
     * @param updatedProgress The updated progress data.
     * @return true if the update is successful, false otherwise.
     */
    public boolean updateProgress(int userId, ProgressData updatedProgress) {
        if (updatedProgress == null) return false;

        // Create a new workout session with the updated progress
        WorkoutSession newSession = new WorkoutSession(userId, "Workout " + (workoutSessions.size() + 1), LocalDateTime.now(), updatedProgress);
        workoutSessions.add(newSession);
        return true;
    }

    /**
     * Retrieves all workout sessions for a user.
     * @param userId The user's ID.
     * @return A list of workout sessions.
     */
    public List<WorkoutSession> getUserWorkoutSessions(int userId) {
        List<WorkoutSession> userSessions = new ArrayList<>();
        for (WorkoutSession session : workoutSessions) {
            if (session.getUserId() == userId) {
                userSessions.add(session);
            }
        }
        return userSessions;
    }

    /**
     * Retrieves progress trends for a user by analyzing past workouts.
     * @param userId The user's ID.
     * @return A string summarizing progress trends.
     */
    public String getProgressTrends(int userId) {
        List<WorkoutSession> userSessions = getUserWorkoutSessions(userId);

        if (userSessions.isEmpty()) {
            return "No progress data available.";
        }

        double totalReps = 0, totalSets = 0, totalDuration = 0, totalCalories = 0;
        int sessionCount = userSessions.size();

        for (WorkoutSession session : userSessions) {
            totalReps += session.getProgressData().getReps();
            totalSets += session.getProgressData().getSets();
            totalDuration += session.getProgressData().getDuration();
            totalCalories += session.getProgressData().getCaloriesBurned();
        }

        double avgReps = totalReps / sessionCount;
        double avgSets = totalSets / sessionCount;
        double avgDuration = totalDuration / sessionCount;
        double avgCalories = totalCalories / sessionCount;

        return "=== Progress Trends ===\n"
                + "Total Workouts: " + sessionCount + "\n"
                + "Avg Reps per Workout: " + avgReps + "\n"
                + "Avg Sets per Workout: " + avgSets + "\n"
                + "Avg Duration: " + avgDuration + " min\n"
                + "Avg Calories Burned: " + avgCalories;
    }
}
