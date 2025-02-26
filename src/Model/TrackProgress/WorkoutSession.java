package Model.TrackProgress;

import java.time.LocalDateTime;

public class WorkoutSession {
    private int userId;
    private String workoutName; // Name of the workout performed
    private LocalDateTime sessionDate; // Date and time of the workout
    private ProgressData progressData; // Tracks workout performance/progress


    public WorkoutSession(int userId, String workoutName, LocalDateTime sessionDate, ProgressData progressData) {
        this.userId = userId;
        this.workoutName = workoutName;
        this.sessionDate = sessionDate;
        this.progressData = progressData;
    }

    public int getUserId() {
        return userId;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public ProgressData getProgressData() {
        return progressData;
    }

    public void setProgressData(ProgressData progressData) {
        this.progressData = progressData;
    }

    /**
     * Logs a new workout session.
     */
    public void logWorkoutSession() {
        // Logic for saving workout session data
    }

    /**
     * Reviews workout performance based on stored progress data.
     */
    public void reviewWorkoutPerformance() {
        // Logic to analyze workout session data
    }

    @Override
    public String toString() {
        return "WorkoutSession{" +
                "userId=" + userId +
                ", workoutName='" + workoutName + '\'' +
                ", sessionDate=" + sessionDate +
                ", progressData=" + progressData +
                '}';
    }
}
