package com.kata.stringCalculatorKata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private final StringCalculator calc = new StringCalculator();

    /**
     * Verifica que la calculadora puede manejar una cadena vacia y devuelva 0.
     */
    @Test
    public void testEmptyString() {
        assertEquals(0, calc.add(""));
    }

    /**
     * Verifica que la calculadora puede manejar que si hay un solo numero nos devuelva el mismo numero
     */
    @Test
    public void testSingleNumber() {
        assertEquals(5, calc.add("5"));
    }

    /**
     * Verifica que la calculadora puede manejar dos numeros separados por coma y devuelve la suma.
     */
    @Test
    public void testTwoNumbers() {
        assertEquals(7, calc.add("3,4"));
    }

    /**
     * Verifica que la calculadora puede manejar mas de dos numeros separados por coma y devuelve la suma de todos.
     */
    @Test
    public void testMultipleNumbers() {
        assertEquals(10, calc.add("1,2,3,4"));
    }

    /**
     * Verifica que la calculadora puede manejar que ademas de la coma, tambien se permite usar salto de línea (\n) como separador.
     */
    @Test
    public void testNewLineDelimiter() {
        assertEquals(6, calc.add("1\n2,3"));
    }

    /**
     * Verifica que la calculadora puede manejar que se puede definir un delimitador personalizado en la primera línea, despues de //.
     */
    @Test
    public void testCustomDelimiter() {
        assertEquals(3, calc.add("//;\n1;2"));
    }

    /**
     * Verifica que la calculadora puede manejar que si la cadena contiene numeros negativos, el metodo lanza una excepcion.
     */
    @Test
    public void testNegativeNumbers() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> calc.add("1,-2,3"));
        assertTrue(ex.getMessage().contains("Negatives not allowed"));
    }

    /**
     * Verifica que la calculadora puede manejar que los numeros mayores a 1000 se ignoran en la suma.
     */
    @Test
    public void testNumbersGreaterThan1000Ignored() {
        assertEquals(2, calc.add("1001,2"));
    }

}
