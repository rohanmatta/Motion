package View.TrackProgress;

import Model.TrackProgress.WorkoutSession;
import Model.TrackProgress.ProgressData;
import Observer.Observer;  // Import Observer from your Observer package
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Stub that displays past workout sessions and progress trends.
 * Now implements Observer to receive progress updates.
 */
public class TrackProgressView implements Observer {

    @Override
    public void update(ProgressData progressData) {
        // This method will be called when ProgressSubject notifies observers.
        System.out.println("TrackProgressView updated: " + progressData.toString());
        // Here you could add code to update UI components, if applicable.
    }

    /**
     * Stub that displays past workout sessions with dummy data.
     */
    public void displayPastWorkouts() {
        System.out.println("TrackProgressView: Fetching past workout sessions (Stub)...");

        // Stub that uses predefined values instead of fetching real data
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
     * Stub that displays progress trends with dummy values.
     */
    public void displayProgressTrends() {
        System.out.println("TrackProgressView: Fetching progress trends (Stub)...");

        // Stubs that uses dummy progress trends
        String progressTrends = "{Progress Trends (Stub)}\n"
                + "Total Workouts: 5\n"
                + "Avg Reps per Workout: 12\n"
                + "Avg Sets per Workout: 3\n"
                + "Avg Duration: 35 min\n"
                + "Avg Calories Burned: 280";

        System.out.println(progressTrends);
    }
}
