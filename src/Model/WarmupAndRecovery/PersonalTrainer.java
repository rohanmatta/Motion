package Model.WarmupAndRecovery;

public class PersonalTrainer {
    private String trainerId;
    private String specialization;


    public PersonalTrainer(String trainerId, String specialization) {
        this.trainerId = trainerId;
        this.specialization = specialization;
    }


    public String getTrainerId() {
        return trainerId;
    }


    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }


    public String getSpecialization() {
        return specialization;
    }


    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    public void displayTrainerDetails() {
        System.out.println("Trainer ID: " + trainerId);
        System.out.println("Specialization: " + specialization);
    }


    public boolean equals(PersonalTrainer other) {
        if (other == null) return false;
        return this.trainerId.equals(other.trainerId) && this.specialization.equals(other.specialization);
    }


    public void updateSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
    }


    @Override
    public String toString() {
        return "PersonalTrainer{" +
                "trainerId='" + trainerId + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
