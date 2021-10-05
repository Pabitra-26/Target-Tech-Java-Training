package com.target.training.programs;


import com.target.training.pograms.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTests {

    Calculator calc;

    @BeforeEach   //this function will be executed before every test case
    public void setup(){
        calc = new Calculator();
    }

    @Test
    void shouldAddTwoNumbers(){

        Double actual = calc.add(12., 20.);
        Double expected = 32.;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldAddNegativeNumbers(){

        Double actual = calc.add(-10., -20., -30.);
        Double expected = -60.;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldAddAllNumbersButNull(){
        Double actual = calc.add(10., null, 10., 10., null);
        Double expected = 30.;
        Assertions.assertNotNull(actual);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldAddStringNumbers(){
        Double actual = calc.add(10., "10.0", null);
        Double expected = 20.0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowException(){

        Assertions.assertThrows(NumberFormatException.class, ()->calc.add(10., "10.0", "ten"));

    }

    @Test
    void shouldNotThrowExceptionAgain(){

        Assertions.assertDoesNotThrow(()->{
            Double actual = calc.add(10., "10.0", "20.0");
            Assertions.assertEquals(40.0, actual);
        });

    }
}
