package junittasks;

public class LoginService {
    private static final String VALID_USERNAME = "whybro";
    private static final String VALID_PASSWORD = "Not@123";

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password cannot be null");
        }
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}

