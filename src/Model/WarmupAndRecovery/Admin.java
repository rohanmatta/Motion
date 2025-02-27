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
     *
     * @return The unique identifier of the admin.
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * Sets the admin ID.
     *
     * @param adminId The new unique identifier to be assigned to the admin.
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    /**
     * Retrieves the admin's name.
     *
     * @return The name of the admin.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the admin's name.
     *
     * @param name The new name to be assigned to the admin.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Displays the admin's details.
     */
    public void displayAdminDetails() {
        System.out.println("Admin ID: " + adminId);
        System.out.println("Name: " + name);
    }

    /**
     * Compares this admin to another admin instance for equality.
     *
     * @param other The {@code Admin} object to compare with.
     * @return {@code true} if both admin instances have the same ID and name, otherwise {@code false}.
     */
    public boolean equals(Admin other) {
        if (other == null) return false;
        return this.adminId.equals(other.adminId) && this.name.equals(other.name);
    }

    /**
     * Updates the admin's name.
     *
     * @param newName The new name to be set for the admin.
     */
    public void updateName(String newName) {
        this.name = newName;
    }

    /**
     * Returns a string representation of the admin object.
     *
     * @return A formatted string containing admin details.
     */
    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
