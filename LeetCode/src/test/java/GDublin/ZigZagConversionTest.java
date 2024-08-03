package GDublin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagConversionTest {

    @Test
    void convert() {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        String sA = zigZagConversion.convert("PAYPALISHIRING", 3);
        String sB = zigZagConversion.convert("PAYPALISHIRING", 4);
        Assertions.assertEquals("PAHNAPLSIIGYIR", sA);
        Assertions.assertEquals("PINALSIGYAHRPI", sB);
    }
}