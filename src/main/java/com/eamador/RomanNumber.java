package com.eamador;

import java.util.HashMap;

public class RomanNumber {
    private static final HashMap<String, Integer> integers = new HashMap<>();
    private String value;

    public RomanNumber(String value) throws IllegalArgumentException {
        integers.put("I", 1);
        integers.put("V", 5);
        integers.put("X", 10);
        integers.put("L", 50);
        integers.put("C", 100);
        integers.put("D", 500);
        integers.put("M", 1000);

        value = value.toUpperCase();

        if (!value.matches("^[IVXLCDM]+$")) {
            throw new IllegalArgumentException("Invalid roman number");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public ArabicNumber getArabicNumber() {
        /**
         * Iterate from right to left (less to more significant)
         * let's keep track of the previous number, because
         * the case of 4, 40, 400, etc are special (right value - left value)
         * 
         * example: XLVII
         * X    L   V   I   I
         *                  |
         *                  1
         *                  decimalValue = 1
         *              |
         *              1
         *              decimalValue = 2
         *         |
         *         5
         *        decimalValue = 7
         *    |
         *   50
         *   decimalValue = 57
         * |
         * 10 (this value is rest because the current value is less than the previou value)
         * decimalValue = 47
         * 
         */
        ArabicNumber arabicNumber = null;
        Integer integerValue = 0;
        Integer previous = 0;
        for (int i = value.length() - 1; i >= 0; i--) {
            Character currentChar = value.charAt(i);
            Integer current = integers.get(String.valueOf(currentChar));
            if (current < previous) {
                integerValue -= current;
            } else {
                integerValue += current;
            }
            previous = current;
        }
        arabicNumber = new ArabicNumber(integerValue);
        return arabicNumber;
    }
}
