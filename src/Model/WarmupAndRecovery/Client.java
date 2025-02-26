package Model.WarmupAndRecovery;

public class Client {
    private String clientId;
    private String fitnessGoal;


    public Client(String clientId, String fitnessGoal) {
        this.clientId = clientId;
        this.fitnessGoal = fitnessGoal;
    }


    public String getClientId() {
        return clientId;
    }


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public String getFitnessGoal() {
        return fitnessGoal;
    }


    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }


    public void displayClientDetails() {
        System.out.println("Client ID: " + clientId);
        System.out.println("Fitness Goal: " + fitnessGoal);
    }


    public boolean equals(Client other) {
        if (other == null) return false;
        return this.clientId.equals(other.clientId) && this.fitnessGoal.equals(other.fitnessGoal);
    }


    public void updateFitnessGoal(String newFitnessGoal) {
        this.fitnessGoal = newFitnessGoal;
    }


    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", fitnessGoal='" + fitnessGoal + '\'' +
                '}';
    }
}
