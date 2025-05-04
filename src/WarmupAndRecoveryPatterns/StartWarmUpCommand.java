package WarmupAndRecoveryPatterns;

public class StartWarmUpCommand implements Command {
    private final WarmUpService service;
    private final String warmupType;
    private final String username;

    public StartWarmUpCommand(WarmUpService service, String warmupType, String username) {
        this.service = service;
        this.warmupType = warmupType;
        this.username = username;
    }

    @Override
    public void execute() {
        service.startWarmUp(warmupType, username);
    }
}
