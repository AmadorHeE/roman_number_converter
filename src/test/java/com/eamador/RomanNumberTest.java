package com.eamador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RomanNumberTest {
    @ParameterizedTest(name = "Roman number {0} = Arabic {1}")
    @CsvSource({
        "I, 1",
        "IV, 4",
        "V, 5",
        "IX, 9",
        "X, 10",
        "XIV, 14",
        "XX, 20",
        "XL, 40",
        "L, 50",
        "LXII, 62",
        "XC, 90",
        "C, 100",
        "CXX, 120",
        "i, 1",
        "iv, 4",
        "v, 5",
        "ix, 9",
        "x, 10",
        "xiv, 14",
        "xx, 20",
        "xl, 40",
        "l, 50",
        "lxii, 62",
        "xc, 90",
        "c, 100",
        "cxx, 120",
    })
    public void testGetDecimalFromRomanUpperCase(String value, Integer expectedResult) throws IllegalArgumentException {
        RomanNumber romanNumber;
        
        romanNumber = new RomanNumber(value);
        assertEquals(expectedResult, romanNumber.getArabicNumber().getValue());
    }

    @Test
    public void testInvalidRomanNumber() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> {
            new RomanNumber("invalid value");
        });
    }
}
