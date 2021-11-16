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
                {-1},
                {13}
        };
    }

    @Test(dataProvider = "numbersAndFactorials")
    public void testCalculate(int number, int factorial) {
        assertEquals(FactorialCalculator.calculate(number), factorial);
    }

    @Test(dataProvider = "invalidNumbers")
    public void testCalculateInvalidCases(int number) {
        assertThrows(() -> FactorialCalculator.calculate(number));
    }
}
