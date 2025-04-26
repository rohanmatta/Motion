package Model.DB;

public class DBError extends Exception {
    private String message = "Database error";
    public DBError() {}
    public DBError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
