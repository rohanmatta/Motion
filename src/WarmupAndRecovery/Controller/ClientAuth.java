package WarmupAndRecovery.Controller;

public class ClientAuth {
    public boolean login(String username, String password) {
        return username.equals("client") && password.equals("securePass");
    }
}
