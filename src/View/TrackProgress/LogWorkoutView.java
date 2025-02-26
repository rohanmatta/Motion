package View.TrackProgress;

import Controller.TrackProgressController;
import Model.TrackProgress.ProgressData;
import Model.TrackProgress.WorkoutSession;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Provides UI for logging a new workout session.
 */
public class LogWorkoutView {
    private TrackProgressController trackProgressController;
    private Scanner scanner;

    /**
     * Constructor to initialize LogWorkoutView with a controller.
     */
    public LogWorkoutView(TrackProgressController trackProgressController) {
        this.trackProgressController = trackProgressController;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Input form for logging a new workout (Not needed now but can use later)
     */
    public void displayWorkoutLogForm() {
        System.out.println("{Log a New Workout}");

        System.out.print("Enter Workout Name: ");
        String workoutName = scanner.nextLine();

        System.out.print("Enter Sets: ");
        int sets = scanner.nextInt();

        System.out.print("Enter Reps: ");
        int reps = scanner.nextInt();

        System.out.print("Enter Workout Duration (minutes): ");
        double duration = scanner.nextDouble();

        System.out.print("Enter Calories Burned: ");
        double caloriesBurned = scanner.nextDouble();

        System.out.print("Enter Weight Lifted (or 0 if not applicable): ");
        double weightLifted = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter any Notes about this workout: ");
        String notes = scanner.nextLine();

        // Create ProgressData and WorkoutSession objects
        ProgressData progressData = new ProgressData(1, sets, reps, duration, caloriesBurned, weightLifted, notes);
        WorkoutSession workoutSession = new WorkoutSession(1, workoutName, LocalDateTime.now(), progressData);

        // Sends the data to the controller for processing
        trackProgressController.updateProgress(1, progressData);

        System.out.println("Workout logged successfully!!!");
    }
}
