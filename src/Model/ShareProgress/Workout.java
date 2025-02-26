package Model.ShareProgress;

import java.util.List;

public class Workout {
    private String name;
    private String type;
    private int sets;
    private int reps;
    private double duration;
    private double caloriesBurned;
    private List<String> exercises;

    public Workout(String name, String type, int sets, int reps, double duration, double caloriesBurned, List<String> exercises) {
        this.name = name;
        this.type = type;
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.exercises = exercises;
    }

    public void updateWorkout(int sets, int reps, double duration, double caloriesBurned) {
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", duration=" + duration +
                ", caloriesBurned=" + caloriesBurned +
                ", exercises=" + exercises +
                '}';
    }
}
