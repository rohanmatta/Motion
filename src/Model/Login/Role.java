package Model.Login;

public enum Role {
    // To add new role follow same format and just increase right number by 1
    USER(1<<0),
    SUPPORT_USER(1<<1),
    TRAINER(1<<2),
    ADMIN(1<< 31);

    private final int value;

    Role(int role) {
        this.value = role;
    }
    public int getValue() {
        return value;
    }
}
