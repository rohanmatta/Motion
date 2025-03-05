package Model.WarmupAndRecovery;

/**
 * Represents an administrator with an ID and a name.
 */
public class Admin {
    private String adminId;
    private String name;

    /**
     * Constructs a new {@code Admin} instance.
     *
     * @param adminId The unique identifier of the admin.
     * @param name    The name of the admin.
     */
    public Admin(String adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }

    /**
     * Retrieves the admin ID.
     * This is a stub method.
     *
     * @return The unique identifier of the admin.
     */
    public String getAdminId() {
        // Stub: return a test value
        System.out.println("Returning admin ID for test.");
        return "testAdminId";
    }

    /**
     * Sets the admin ID.
     * This is a stub method.
     *
     * @param adminId The new unique identifier to be assigned to the admin.
     */
    public void setAdminId(String adminId) {
        // Stub: print the action of setting admin ID
        System.out.println("Setting admin ID to: " + adminId);
    }

    /**
     * Retrieves the admin's name.
     * This is a stub method.
     *
     * @return The name of the admin.
     */
    public String getName() {
        // Stub: return a test name
        System.out.println("Returning admin name for test.");
        return "Test Admin";
    }

    /**
     * Sets the admin's name.
     * This is a stub method.
     *
     * @param name The new name to be assigned to the admin.
     */
    public void setName(String name) {
        // Stub: print the action of setting admin name
        System.out.println("Setting admin name to: " + name);
    }

    /**
     * Displays the admin's details.
     * This is a stub method.
     */
    public void displayAdminDetails() {
        // Stub: print admin details
        System.out.println("Displaying admin details: Admin ID: " + adminId + ", Name: " + name);
    }

    /**
     * Compares this admin to another admin instance for equality.
     * This is a stub method.
     *
     * @param other The {@code Admin} object to compare with.
     * @return {@code true} if both admin instances have the same ID and name, otherwise {@code false}.
     */
    public boolean equals(Admin other) {
        // Stub: compare using mock logic
        System.out.println("Comparing admin instances.");
        return this.adminId.equals(other.adminId) && this.name.equals(other.name);
    }

    /**
     * Updates the admin's name.
     * This is a stub method.
     *
     * @param newName The new name to be set for the admin.
     */
    public void updateName(String newName) {
        // Stub: update and print new name
        System.out.println("Updating admin name to: " + newName);
        this.name = newName;
    }

    /**
     * Returns a string representation of the admin object.
     * This is a stub method.
     *
     * @return A formatted string containing admin details.
     */
    @Override
    public String toString() {
        // Stub: return a test string representation
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
