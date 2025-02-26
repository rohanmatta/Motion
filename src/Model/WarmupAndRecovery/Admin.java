package Model.WarmupAndRecovery;

public class Admin {
    private String adminId;
    private String name;

    public Admin(String adminId, String name) {
        this.adminId = adminId;
        this.name = name;
    }


    public String getAdminId() {
        return adminId;
    }


    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void displayAdminDetails() {
        System.out.println("Admin ID: " + adminId);
        System.out.println("Name: " + name);
    }


    public boolean equals(Admin other) {
        if (other == null) return false;
        return this.adminId.equals(other.adminId) && this.name.equals(other.name);
    }


    public void updateName(String newName) {
        this.name = newName;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
