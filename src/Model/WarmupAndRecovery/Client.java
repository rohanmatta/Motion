package Model.WarmupAndRecovery;

/**
 * Represents a client with a unique ID and a fitness goal.
 */
public class Client {
    private String clientId;
    private String fitnessGoal;

    /**
     * Constructs a new {@code Client} instance.
     *
     * @param clientId    The unique identifier of the client.
     * @param fitnessGoal The fitness goal of the client.
     */
    public Client(String clientId, String fitnessGoal) {
        this.clientId = clientId;
        this.fitnessGoal = fitnessGoal;
    }

    /**
     * Retrieves the client ID.
     *
     * @return The unique identifier of the client.
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Sets the client ID.
     *
     * @param clientId The new unique identifier to be assigned to the client.
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Retrieves the client's fitness goal.
     *
     * @return The fitness goal of the client.
     */
    public String getFitnessGoal() {
        return fitnessGoal;
    }

    /**
     * Sets the client's fitness goal.
     *
     * @param fitnessGoal The new fitness goal to be assigned to the client.
     */
    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    /**
     * Displays the client's details.
     */
    public void displayClientDetails() {
        System.out.println("Client ID: " + clientId);
        System.out.println("Fitness Goal: " + fitnessGoal);
    }

    /**
     * Compares this client to another client instance for equality.
     *
     * @param other The {@code Client} object to compare with.
     * @return {@code true} if both client instances have the same ID and fitness goal, otherwise {@code false}.
     */
    public boolean equals(Client other) {
        if (other == null) return false;
        return this.clientId.equals(other.clientId) && this.fitnessGoal.equals(other.fitnessGoal);
    }

    /**
     * Updates the client's fitness goal.
     *
     * @param newFitnessGoal The new fitness goal to be set for the client.
     */
    public void updateFitnessGoal(String newFitnessGoal) {
        this.fitnessGoal = newFitnessGoal;
    }

    /**
     * Returns a string representation of the client object.
     *
     * @return A formatted string containing client details.
     */
    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", fitnessGoal='" + fitnessGoal + '\'' +
                '}';
    }
}
