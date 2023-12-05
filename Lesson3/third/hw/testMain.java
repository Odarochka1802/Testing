package seminars.third.hw;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainHWTest {

    // Test for HW 3.1
    @Test
    public void testIsEven() {
        assertTrue(MainHW.isEven(4));
        assertFalse(MainHW.isEven(7));
    }

    // Test for HW 3.2
    @Test
    public void testIsInRange() {
        assertTrue(MainHW.isInRange(50));
        assertFalse(MainHW.isInRange(20));
    }
}
