import java.util.HashMap;
import java.util.Map;

public class BuggyApp {

    // --- User Class ---
    static class User {
        public String name;
        public String role;
        public String email;

        public User(String name, String role, String email) {
            this.name = name;
            this.role = role;
            this.email = email;
        }
    }

    // --- Database Simulation ---
    private static final Map<Integer, User> USERS_DB = new HashMap<>();
    static {
        USERS_DB.put(1, new User("Alice", "admin", "alice@example.com"));
        USERS_DB.put(2, new User("Bob", "editor", "bob@example.com"));
        USERS_DB.put(3, new User("Charlie", "viewer", "charlie@example.com"));
    }

    public static String getUserDetails(int userId) {
        User userRecord = USERS_DB.get(userId);
        // FIX: Add a null check to handle cases where the user does not exist.
        if (userRecord == null) {
            return String.format("User with ID %d not found.", userId);
        }
        return String.format("User Found: %s (%s)", userRecord.name, userRecord.email);
    }

    public static boolean isPasswordStrongEnough(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    // --- Main Application Logic ---
    public static void main(String[] args) {
        System.out.println("--- User Management System ---");
        System.out.println("\n[Scenario 1: Fetching a user by ID]");
        int userIdToFind = 99; // Non-existent ID to trigger the bug
        try {
            String userDetails = getUserDetails(userIdToFind);
            System.out.println("Searching for user with ID: " + userIdToFind);
            System.out.println("Result: " + userDetails);
        } catch (Exception e) {
            System.out.println("Result: An error occurred! " + e.getClass().getName());
        }

        System.out.println("\n[Scenario 2: Password Strength Check]");
        String[] testPasswords = {"short", "longpassword", "exactly8"};
        for (String pwd : testPasswords) {
            boolean isStrong = isPasswordStrongEnough(pwd);
            System.out.printf("Checking password '%s': %s\n", pwd, isStrong ? "Strong" : "Weak");
        }
    }
}