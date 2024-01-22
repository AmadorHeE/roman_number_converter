package com.eamador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArabicNumberTest {
    @ParameterizedTest(name = "Arabic number {0} = Roman {1}")
    @CsvSource({
        "1, I",
        "4, IV",
        "5, V",
        "9, IX",
        "10, X",
        "14, XIV",
        "20, XX",
        "40, XL",
        "50, L",
        "62, LXII",
        "90, XC",
        "100, C",
        "120, CXX",
    })
    public void testArabicNumber(Integer value, String expectedResult) throws IllegalArgumentException {
        ArabicNumber arabicNumber = new ArabicNumber(value);
        assertEquals(expectedResult, arabicNumber.getRomanNumber().getValue());
    }
}
