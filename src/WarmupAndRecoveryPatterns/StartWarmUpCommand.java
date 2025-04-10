package WarmupAndRecoveryPatterns;

public class StartWarmUpCommand implements Command {
    private WarmUpService service;
    public StartWarmUpCommand(WarmUpService service) {
        this.service = service;
    }
    @Override
    public void execute() {
        service.startWarmUp();
    }
}
