package Model.WarmupAndRecovery;

public class PersonalTrainer {
    private String trainerId;
    private String specialization;

    public PersonalTrainer(String trainerId, String specialization) {
        this.trainerId = trainerId;
        this.specialization = specialization;
    }

    public String getTrainerId() { return trainerId; }
    public String getSpecialization() { return specialization; }
}
