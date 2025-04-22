// Model/TrackProgress/WorkoutEntry.java
package Model.TrackProgress;

import java.sql.Date;

public class WorkoutEntry {
    private long id;
    private long userId;
    private String workoutName;
    private Date date;
    private int sets;
    private int reps;
    private int weight;

    public WorkoutEntry() { }

    public WorkoutEntry(long userId, String workoutName, Date date,
                        int sets, int reps, int weight) {
        this.userId      = userId;
        this.workoutName = workoutName;
        this.date        = date;
        this.sets        = sets;
        this.reps        = reps;
        this.weight      = weight;
    }

    // Getters & setters
    public long getId()              { return id; }
    public void setId(long id)       { this.id = id; }
    public long getUserId()          { return userId; }
    public void setUserId(long u)    { this.userId = u; }
    public String getWorkoutName()   { return workoutName; }
    public void setWorkoutName(String n) { this.workoutName = n; }
    public Date getDate()            { return date; }
    public void setDate(Date d)      { this.date = d; }
    public int getSets()             { return sets; }
    public void setSets(int s)       { this.sets = s; }
    public int getReps()             { return reps; }
    public void setReps(int r)       { this.reps = r; }
    public int getWeight()           { return weight; }
    public void setWeight(int w)     { this.weight = w; }
}