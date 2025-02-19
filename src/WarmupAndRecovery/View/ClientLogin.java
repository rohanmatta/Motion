package WarmupAndRecovery.View;

public class ClientLogin {
    public boolean authenticate(String username, String password) {
        // Authentication logic here
        return username.equals("client") && password.equals("password");
    }
}
