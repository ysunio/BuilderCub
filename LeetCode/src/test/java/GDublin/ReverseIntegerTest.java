package GDublin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    @Test
    void reverse() {
        ReverseInteger reverseInteger = new ReverseInteger();
        Assertions.assertEquals(-321, reverseInteger.reverse(-123));
        Assertions.assertEquals(321, reverseInteger.reverse(123));
        Assertions.assertEquals(-2224, reverseInteger.reverse(-4222));
    }
}