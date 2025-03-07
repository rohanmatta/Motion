package View.TrackProgress;

import Model.TrackProgress.WorkoutSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Stub: Displays past workout sessions and progress trends.
 */
public class TrackProgressView {

    /**
     * Stub: Displays past workout sessions with dummy data.
     */
    public void displayPastWorkouts() {
        System.out.println("TrackProgressView: Fetching past workout sessions (Stub)...");

        // Stub: Use predefined values instead of fetching real data
        List<WorkoutSession> workoutSessions = new ArrayList<>();
        workoutSessions.add(new WorkoutSession(1, "Bench Press", LocalDateTime.now(), null));
        workoutSessions.add(new WorkoutSession(1, "Squats", LocalDateTime.now(), null));

        if (workoutSessions.isEmpty()) {
            System.out.println("TrackProgressView: No workouts logged yet (Stub).");
            return;
        }

        System.out.println("{Your Workout History (Stub)}");
        for (WorkoutSession session : workoutSessions) {
            System.out.println("Workout: " + session.getWorkoutName());
            System.out.println("Date: " + session.getSessionDate());
            System.out.println("Sets: 3 (Stub)");
            System.out.println("Reps: 10 (Stub)");
            System.out.println("Duration: 45 minutes (Stub)");
            System.out.println("Calories Burned: 350 (Stub)");
        }
    }

    /**
     * Stub: Displays progress trends with dummy values.
     */
    public void displayProgressTrends() {
        System.out.println("TrackProgressView: Fetching progress trends (Stub)...");

        // Stub: Use predefined progress trends instead of fetching real data
        String progressTrends = "{Progress Trends (Stub)}\n"
                + "Total Workouts: 5\n"
                + "Avg Reps per Workout: 12\n"
                + "Avg Sets per Workout: 3\n"
                + "Avg Duration: 35 min\n"
                + "Avg Calories Burned: 280";

        System.out.println(progressTrends);
    }
}
