package View.WarmupAndRecovery;

public class TrainerLogin {
    public boolean authenticate(String username, String password) {
        // Authentication logic here
        return username.equals("trainer") && password.equals("password");
    }
}
