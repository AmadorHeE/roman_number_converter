package com.eamador;

import java.util.ArrayList;
import java.util.Arrays;

public class ArabicNumber {
    private static final ArrayList<String> units = new ArrayList<>(Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"));
    private static final ArrayList<String> tens = new ArrayList<>(Arrays.asList("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"));
    private static final ArrayList<String> hundreds = new ArrayList<>(Arrays.asList("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"));   
    private static final ArrayList<String> thousands = new ArrayList<>(Arrays.asList("", "M", "MM", "MMM"));

    private Integer value;

    public ArabicNumber(Integer value) {
        if (value < 1 || value > 3999) {
            throw new IllegalArgumentException("Invalid arabic number");
        }
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public RomanNumber getRomanNumber() {
        RomanNumber romanNumber = null;
        String romanNumberString = "";
        Integer quotient = null;
        
        quotient = value / 1000;
        value -= quotient * 1000;
        romanNumberString += ArabicNumber.thousands.get(quotient) ;
        
        quotient = value / 100;
        value -= quotient * 100;
        romanNumberString += ArabicNumber.hundreds.get(quotient) ;

        quotient = value / 10;
        value -= quotient * 10;
        romanNumberString += ArabicNumber.tens.get(quotient) ;

        romanNumberString += ArabicNumber.units.get(value) ;

        try {
            romanNumber = new RomanNumber(romanNumberString);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return romanNumber;
    }
}
