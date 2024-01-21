package com.eamador;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumberTest {
    @Test
    public void testGetDecimalFromRomanUpperCase() throws InvalidRomanNumberException {
        RomanNumber romanNumber;
        
        romanNumber = new RomanNumber("I");
        Assert.assertEquals(1, romanNumber.getInteger());
        romanNumber = new RomanNumber("IV");
        Assert.assertEquals(4, romanNumber.getInteger());
        romanNumber = new RomanNumber("V");
        Assert.assertEquals(5, romanNumber.getInteger());
        romanNumber = new RomanNumber("IX");
        Assert.assertEquals(9, romanNumber.getInteger());
        romanNumber = new RomanNumber("X");
        Assert.assertEquals(10, romanNumber.getInteger());
        romanNumber = new RomanNumber("XIV");
        Assert.assertEquals(14, romanNumber.getInteger());
        romanNumber = new RomanNumber("XX");
        Assert.assertEquals(20, romanNumber.getInteger());
        romanNumber = new RomanNumber("XL");
        Assert.assertEquals(40, romanNumber.getInteger());
        romanNumber = new RomanNumber("L");
        Assert.assertEquals(50, romanNumber.getInteger());
        romanNumber = new RomanNumber("LXII");
        Assert.assertEquals(62, romanNumber.getInteger());
        romanNumber = new RomanNumber("XC");
        Assert.assertEquals(90, romanNumber.getInteger());
        romanNumber = new RomanNumber("C");
        Assert.assertEquals(100, romanNumber.getInteger());
        romanNumber = new RomanNumber("CXX");
        Assert.assertEquals(120, romanNumber.getInteger());
    }

    @Test
    public void testGetDecimalFromRomanLowerCase() throws InvalidRomanNumberException {
        RomanNumber romanNumber;
        romanNumber = new RomanNumber("i");
        Assert.assertEquals(1, romanNumber.getInteger());
        romanNumber = new RomanNumber("iv");
        Assert.assertEquals(4, romanNumber.getInteger());
        romanNumber = new RomanNumber("v");
        Assert.assertEquals(5, romanNumber.getInteger());
        romanNumber = new RomanNumber("ix");
        Assert.assertEquals(9, romanNumber.getInteger());
        romanNumber = new RomanNumber("x");
        Assert.assertEquals(10, romanNumber.getInteger());
        romanNumber = new RomanNumber("xiv");
        Assert.assertEquals(14, romanNumber.getInteger());
        romanNumber = new RomanNumber("xx");
        Assert.assertEquals(20, romanNumber.getInteger());
        romanNumber = new RomanNumber("xl");
        Assert.assertEquals(40, romanNumber.getInteger());
        romanNumber = new RomanNumber("l");
        Assert.assertEquals(50, romanNumber.getInteger());
        romanNumber = new RomanNumber("lxii");
        Assert.assertEquals(62, romanNumber.getInteger());
        romanNumber = new RomanNumber("xc");
        Assert.assertEquals(90, romanNumber.getInteger());
        romanNumber = new RomanNumber("c");
        Assert.assertEquals(100, romanNumber.getInteger());
        romanNumber = new RomanNumber("cxx");
        Assert.assertEquals(120, romanNumber.getInteger());
    }

    @Test(expected = InvalidRomanNumberException.class)
    public void testInvalidRomanNumber() throws InvalidRomanNumberException {
        RomanNumber romanNumber = new RomanNumber("invalid value");
        romanNumber.getInteger();
    }
}
