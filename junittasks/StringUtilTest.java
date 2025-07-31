package junittasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void testReverseRegularString() {
        assertEquals("neelanjan", StringUtil.reverse("najnaleen"));
    }

    @Test
    void testReverseEmptyString() {
        assertEquals("", StringUtil.reverse(""));
    }

    @Test
    void testReverseNullThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtil.reverse(null));
    }
}

