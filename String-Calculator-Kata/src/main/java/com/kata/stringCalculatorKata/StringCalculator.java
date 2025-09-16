package com.kata.stringCalculatorKata;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    /**
     * Suma los numeros dentro de un string segun las reglas del kata.
     *
     * @param input cadena de entrada
     * @return suma de los numeros
     * @throws IllegalArgumentException si hay numeros negativos
     */
    public int add (String input) {
        String delimiters = ",\n";
        String newDelimiter = "";
        String number = "";
        List<Integer> numbers = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        int salto = 0;
        int sum = 0;

        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.indexOf("//") == 0) {
            salto = input.indexOf("\n");
            newDelimiter = input.substring(2, salto);
            delimiters = delimiters + newDelimiter;
            input = input.substring(salto + 1);
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (delimiters.indexOf(c) != -1) {
                if (!number.isEmpty()) {
                    numbers.add(Integer.parseInt(number));
                    number = "";
                }
            } else {
                number = number + c;
            }
        }

        if (!number.isEmpty()) {
            numbers.add(Integer.parseInt(number));
        }

        for (int i = 0; i < numbers.size(); i++) {
            int n = numbers.get(i);
            if (n < 0) {
                negatives.add(n);
            } else if (n <= 1000) {
                sum = sum + n;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives.toString());
        }

        return sum;
    }

}
