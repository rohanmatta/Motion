package WarmupAndRecovery.Controller;

public class TrainerAuth {
    public boolean login(String username, String password) {
        return username.equals("trainer") && password.equals("securePass");
    }
}
