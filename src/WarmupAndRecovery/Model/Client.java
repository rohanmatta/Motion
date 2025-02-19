package WarmupAndRecovery.Model;

public class Client {
    private String clientId;
    private String fitnessGoal;

    public Client(String clientId, String fitnessGoal) {
        this.clientId = clientId;
        this.fitnessGoal = fitnessGoal;
    }

    public String getClientId() { return clientId; }
    public String getFitnessGoal() { return fitnessGoal; }
}
