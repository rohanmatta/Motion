package Controller;

import Model.TrackProgress.ProgressData;
import Model.TrackProgress.WorkoutSession;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for tracking user fitness progress.
 * Handles workout session storage, retrieval, and progress analysis
 */
public class TrackProgressController {

    private List<WorkoutSession> workoutSessions; // Stores user's workout history

    /**
     * Constructor (initializes the controller).
     */
    public TrackProgressController() {
        this.workoutSessions = new ArrayList<>();
    }

    /**
     * Retrieves the current progress data for a user (which is the latest session)
     */
    public ProgressData getProgress(int userId) {
        for (int i = workoutSessions.size() - 1; i >= 0; i--) {
            if (workoutSessions.get(i).getUserId() == userId) {
                return workoutSessions.get(i).getProgressData();
            }
        }
        return null; // If no progress is found
    }

    /**
     * Updates progress by logging/creating a new workout session.
     */
    public boolean updateProgress(int userId, ProgressData updatedProgress) {
        if (updatedProgress == null) return false;

        // Creating a new workout session with the updated progress
        WorkoutSession newSession = new WorkoutSession(userId, "Workout " + (workoutSessions.size() + 1), LocalDateTime.now(), updatedProgress);
        workoutSessions.add(newSession);
        return true;
    }

    /**
     * Retrieves all workout sessions for a user.
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


    public String getProgressTrends(int userId) {
        List<WorkoutSession> userSessions = getUserWorkoutSessions(userId);

        if (userSessions.isEmpty()) {
            return "No progress data available.";
        }

        double totalReps = 0, totalSets = 0, totalDuration = 0, totalCalories = 0;
        int sessionCount = userSessions.size();


        //Calculating averages (using data from later)
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

        //Displaying Trends
        return "{Progress Trends}\n"
                + "Total Workouts: " + sessionCount + "\n"
                + "Avg Reps per Workout: " + avgReps + "\n"
                + "Avg Sets per Workout: " + avgSets + "\n"
                + "Avg Duration: " + avgDuration + " min\n"
                + "Avg Calories Burned: " + avgCalories;
    }
}
