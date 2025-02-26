package Model.TrackProgress;

/**
 * Tracks user workout performance and progress.
 */

//Need to add more relevant attributes
    //Need to add more date specific data
public class ProgressData {
    private int userId;
    private int sets;
    private int reps;
    private double duration; // Workout duration (time in minutes)
    private double caloriesBurned; // Calories burned during workout
    private double weightLifted;
    private String notes; // User notes about their progress

    public ProgressData(int userId, int sets, int reps, double duration, double caloriesBurned, double weightLifted, String notes) {
        this.userId = userId;
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.weightLifted = weightLifted;
        this.notes = notes;
    }

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

    /**
     * Updates the user's progress data based on new workout results.
     */
    public void updateProgressData(int newSets, int newReps, double newDuration, double newCalories, double newWeight) {
        // Logic for updating progress data
    }

    /**
     * Analyzes progress trends over time.
     */
    public void analyzeProgress() {
        // Logic for progress analysis
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
