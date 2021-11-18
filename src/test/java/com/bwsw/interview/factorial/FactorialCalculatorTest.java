package com.bwsw.interview.factorial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialCalculatorTest {

    @DataProvider
    public Object[][] numbersAndFactorials() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {12, 479001600}
        };
    }

    @DataProvider
    public Object[][] invalidNumbers() {
        return new Object[][]{
                {-1, IllegalArgumentException.class},
                {13, ArithmeticException.class}
        };
    }

    @Test(dataProvider = "numbersAndFactorials")
    public void testCalculate(int number, int factorial) {
        assertEquals(FactorialCalculator.calculate(number), factorial);
    }

    @Test(dataProvider = "invalidNumbers")
    public void testCalculateInvalidCases(int number, Class<? extends Exception> exceptionClass) {
        assertThrows(exceptionClass, () -> FactorialCalculator.calculate(number));
    }
}
