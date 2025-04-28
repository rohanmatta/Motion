package WarmupAndRecoveryPatterns;

public class StartWarmUpCommand implements Command {
    private WarmUpService service;
    private String warmupType;

    public StartWarmUpCommand(WarmUpService service, String warmupType) {
        this.service = service;
        this.warmupType = warmupType;
    }

    @Override
    public void execute() {
        service.startWarmUp(warmupType);
    }
}
