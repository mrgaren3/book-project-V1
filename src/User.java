public class User {
    private String username;
    private String password;
    private String role;

    // Constructor
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Simulated login validation
    public static boolean validateLogin(String username, String password, String role) {
        // Dummy validation (you can replace this with real authentication logic)
        if (role.equals("Admin")) {
            return username.equals("admin") && password.equals("admin123");
        } else {
            return username.equals("customer") && password.equals("customer123");
        }
    }
}
