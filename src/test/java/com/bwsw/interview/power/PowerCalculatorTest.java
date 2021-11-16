package com.bwsw.interview.power;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Collection;

import static org.testng.Assert.*;

public class PowerCalculatorTest {

    private final PowerCalculator powerCalculator = new PowerCalculator();

    @DataProvider
    public Object[][] numbersAndPowers() {
        return new Object[][]{
                {0, 1, 0},
                {100, 0, 1},
                {2, 10, 1024},
                {3, 10, 59049}
        };
    }

    @DataProvider
    public Object[][] invalidNumbersAndPowers() {
        return new Object[][]{
                {2, -1, IllegalArgumentException.class},
                {Integer.MAX_VALUE, 2, ArithmeticException.class}
        };
    }

    @Test(dataProvider = "numbersAndPowers")
    public void testCalculate(int number, int power, int result) {
        assertEquals(powerCalculator.calculate(number, power), result);
    }

    @Test(dataProvider = "invalidNumbersAndPowers")
    public void testCalculateInvalidCases(int number, int power, Class<? extends Exception> exceptionClass) {
        assertThrows(exceptionClass, () -> powerCalculator.calculate(number, power));
    }

    @Test(dependsOnMethods = {"testCalculate", "testCalculateInvalidCases"})
    public void testGetCachedResults() {
        Collection<PowerResult> cachedResults = powerCalculator.getCachedResults();
        Object[][] expectedResults = numbersAndPowers();
        assertNotNull(cachedResults);
        assertEquals(cachedResults.size(), expectedResults.length);
        for (Object[] args : numbersAndPowers()) {
            int number = (int) args[0];
            int power = (int) args[1];
            int result = (int) args[2];
            assertTrue(cachedResults.stream()
                    .anyMatch(e -> e.getNumber() == number && e.getPower() == power && e.getResult() == result));
        }
    }

    @Test(dataProvider = "numbersAndPowers", dependsOnMethods = {"testGetCachedResults"})
    public void testCalculateCachedResults(int number, int power, int result) {
        int cacheSize = powerCalculator.getCachedResults().size();
        assertEquals(powerCalculator.calculate(number, power), result);
        assertEquals(powerCalculator.getCachedResults().size(), cacheSize);
    }
}
