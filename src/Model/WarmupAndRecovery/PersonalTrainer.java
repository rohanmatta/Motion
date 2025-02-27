package Model.WarmupAndRecovery;

/**
 * Represents a personal trainer with a unique ID and specialization.
 */
public class PersonalTrainer {
    private String trainerId;
    private String specialization;

    /**
     * Constructs a new {@code PersonalTrainer} instance.
     *
     * @param trainerId     The unique identifier of the trainer.
     * @param specialization The area of expertise for the trainer.
     */
    public PersonalTrainer(String trainerId, String specialization) {
        this.trainerId = trainerId;
        this.specialization = specialization;
    }

    /**
     * Retrieves the trainer ID.
     *
     * @return The unique identifier of the trainer.
     */
    public String getTrainerId() {
        return trainerId;
    }

    /**
     * Sets the trainer ID.
     *
     * @param trainerId The new unique identifier to be assigned to the trainer.
     */
    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    /**
     * Retrieves the trainer's specialization.
     *
     * @return The area of expertise of the trainer.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets the trainer's specialization.
     *
     * @param specialization The new area of expertise to be assigned to the trainer.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Displays the trainer's details.
     */
    public void displayTrainerDetails() {
        System.out.println("Trainer ID: " + trainerId);
        System.out.println("Specialization: " + specialization);
    }

    /**
     * Compares this trainer to another trainer instance for equality.
     *
     * @param other The {@code PersonalTrainer} object to compare with.
     * @return {@code true} if both trainer instances have the same ID and specialization, otherwise {@code false}.
     */
    public boolean equals(PersonalTrainer other) {
        if (other == null) return false;
        return this.trainerId.equals(other.trainerId) && this.specialization.equals(other.specialization);
    }

    /**
     * Updates the trainer's specialization.
     *
     * @param newSpecialization The new area of expertise to be set for the trainer.
     */
    public void updateSpecialization(String newSpecialization) {
        this.specialization = newSpecialization;
    }

    /**
     * Returns a string representation of the personal trainer object.
     *
     * @return A formatted string containing trainer details.
     */
    @Override
    public String toString() {
        return "PersonalTrainer{" +
                "trainerId='" + trainerId + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
