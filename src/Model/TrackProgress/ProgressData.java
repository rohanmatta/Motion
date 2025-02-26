package Model.TrackProgress;

/**
 * Tracks user workout performance and progress.
 */
public class ProgressData {
    private int userId;
    private int sets;
    private int reps;
    private double duration; // Workout duration in minutes
    private double caloriesBurned; // Calories burned during workout
    private double weightLifted; // Optional: Track weights used (for strength workouts)
    private String notes; // Optional: User notes about their progress

    /**
     * Constructor to initialize progress data.
     * @param userId The user's unique identifier.
     * @param sets The number of sets completed.
     * @param reps The number of reps performed.
     * @param duration The workout duration in minutes.
     * @param caloriesBurned The number of calories burned.
     * @param weightLifted The weight lifted (if applicable).
     * @param notes Any notes on the workout session.
     */
    public ProgressData(int userId, int sets, int reps, double duration, double caloriesBurned, double weightLifted, String notes) {
        this.userId = userId;
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.weightLifted = weightLifted;
        this.notes = notes;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public double getWeightLifted() {
        return weightLifted;
    }

    public void setWeightLifted(double weightLifted) {
        this.weightLifted = weightLifted;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "ProgressData{" +
                "userId=" + userId +
                ", sets=" + sets +
                ", reps=" + reps +
                ", duration=" + duration +
                ", caloriesBurned=" + caloriesBurned +
                ", weightLifted=" + weightLifted +
                ", notes='" + notes + '\'' +
                '}';
    }
}
