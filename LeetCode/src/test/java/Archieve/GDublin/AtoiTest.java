package Archieve.GDublin;

import Archieve.GDub.Atoi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtoiTest {

    @Test
    void myAtoi() {
        Atoi atoi = new Atoi();
        Assertions.assertEquals(10, atoi.myAtoi("10"));
        Assertions.assertEquals(-10, atoi.myAtoi("-10abc"));
        Assertions.assertEquals(-42, atoi.myAtoi("  -042"));
    }
}