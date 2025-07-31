package junittasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    LoginService service = new LoginService();

    @Test
    void testValidLogin() {
        assertTrue(service.login("whybro", "Not@123"));
    }

    @Test
    void testInvalidUsername() {
        assertFalse(service.login("wrongUser", "Not@123"));
    }

    @Test
    void testInvalidPassword() {
        assertFalse(service.login("whybro", "wrongPass"));
    }

    @Test
    void testEmptyUsername() {
        assertFalse(service.login("", "password123"));
    }

    @Test
    void testEmptyPassword() {
        assertFalse(service.login("admin", ""));
    }

    @Test
    void testNullUsername() {
        assertThrows(IllegalArgumentException.class, () -> service.login(null, "Not@123"));
    }

    @Test
    void testNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> service.login("whybro", null));
    }
}

