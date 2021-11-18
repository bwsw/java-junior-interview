package com.bwsw.interview.distance;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class DistanceCalculatorTest {

    @DataProvider
    public Object[][] arraysAndResults() {
        return new Object[][]{
                {new int[]{100, 3, 50, 80, 75, 81, 7}, 1},
                {new int[]{28, 71, 94, 17, 35, 88, 17}, 0},
                {new int[]{-10, 7, -5}, 5}
        };
    }

    @DataProvider
    public Object[][] invalidArrays() {
        return new Object[][]{
                {new int[]{}},
                {new int[]{1}}
        };
    }

    @Test(dataProvider = "arraysAndResults")
    public void testCalculate(int[] numbers, int result) {
        int[] initial = numbers.clone();
        assertEquals(DistanceCalculator.calculate(numbers), result);
        assertEquals(numbers, initial);
    }

    @Test(dataProvider = "invalidArrays")
    public void testCalculateInvalidCases(int[] numbers) {
        assertThrows(IllegalArgumentException.class, () -> DistanceCalculator.calculate(numbers));
    }
}
