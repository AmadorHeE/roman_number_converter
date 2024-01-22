package com.eamador;

public class App {
    private static final String ROMAN_TO_ARABIC = "ROMAN_TO_ARABIC";
    private static final String ARABIC_TO_ROMAN = "ARABIC_TO_ROMAN";

    public static void main( String[] args ) {
        if (args.length < 2) {
            System.out.println("Please provide two arguments: operation(ARABIC_TO_ROMAN | ARABIC_TO_ROMAN) type and value to convert.");
            return;
        }

        String operation = args[0];
        String value = args[1];
        
        if (operation == null || operation.isEmpty()) {
            System.out.println("Please provide a valid operation(ARABIC_TO_ROMAN | ROMAN_TO_ARABIC).");
            return;
        }

        if (value == null || value.isEmpty()) {
            System.out.println("Please provide a valid value to convert.");
            return;
        }

        if (operation.equals(ROMAN_TO_ARABIC)) {
            try {
                RomanNumber romanNumber = new RomanNumber(value);
                System.out.println(romanNumber.getArabicNumber().getValue());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro converting roman number " + e.getMessage());
            }
        } else if (operation.equals(ARABIC_TO_ROMAN)) {
            try {
                ArabicNumber arabicNumber = new ArabicNumber(Integer.parseInt(value));
                System.out.println(arabicNumber.getRomanNumber().getValue());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro converting arabic number " + e.getMessage());
            }
        } else {
            System.out.println("Please provide a valid operation(ARABIC_TO_ROMAN | ARABIC_TO_ROMAN).");
        }
        
    }
}
