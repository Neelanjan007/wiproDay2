package junittasks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class Junit1 {

    @Test
    void testFactorialValidInputs() {
        assertEquals(1, Factorial.fact(0));
        assertEquals(1, Factorial.fact(1));
        assertEquals(2, Factorial.fact(2));
        assertEquals(6, Factorial.fact(3));
        assertEquals(24, Factorial.fact(4));
        assertEquals(120, Factorial.fact(5));
    }

    @Test
    void testFactorialNegativeInputThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.fact(-1));
    }
}
