package com.bwsw.interview.distance;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DistanceCalculatorTest {

    @DataProvider
    public Object[][] arraysAndResults() {
        return new Object[][]{
                {new int[]{}, 0},
                {new int[]{1}, 0},
                {new int[]{100, 3, 50, 80, 75, 81, 7}, 1},
                {new int[]{28, 71, 94, 17, 35, 88, 17}, 0},
                {new int[]{-10, 7, -5}, 5}
        };
    }

    @Test(dataProvider = "arraysAndResults")
    public void testCalculate(int[] numbers, int result) {
        assertEquals(DistanceCalculator.calculate(numbers), result);
    }
}
