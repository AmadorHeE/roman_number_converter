package com.eamador;

import java.util.HashMap;

public class RomanNumber {
    private static final HashMap<String, Integer> romanNumbers = new HashMap<>();
    private String value;

    public RomanNumber(String value) throws InvalidRomanNumberException {
        romanNumbers.put("I", 1);
        romanNumbers.put("V", 5);
        romanNumbers.put("X", 10);
        romanNumbers.put("L", 50);
        romanNumbers.put("C", 100);
        romanNumbers.put("D", 500);
        romanNumbers.put("M", 1000);

        value = value.toUpperCase();

        if (!value.matches("^[IVXLCDM]+$")) {
            throw new InvalidRomanNumberException("Invalid roman number");
        }

        this.value = value;
    }

    public int getInteger() {
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
        Integer integerValue = 0;
        Integer previous = 0;
        for (int i = value.length() - 1; i >= 0; i--) {
            Character currentChar = value.charAt(i);
            Integer current = romanNumbers.get(String.valueOf(currentChar));
            if (current < previous) {
                integerValue -= current;
            } else {
                integerValue += current;
            }
            previous = current;
        }
        return integerValue;
    }
}
