package com.bwsw.interview.power;

import java.util.Collection;

public class PowerCalculator {

    /**
     * Calculates the value of a given number raised to a specified power if it has not been calculated yet,
     * otherwise returns a result from a cache.
     *
     * @param number the number to raise
     * @param power the exponent
     * @return the number raised to the power
     * @throws IllegalArgumentException if the exponent < 0
     * @throws ArithmeticException if the result overflows an int
     */
    public int calculate(int number, int power) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns calculations from the cache.
     *
     * @return calculations from the cache
     */
    public Collection<PowerResult> getCachedResults() {
        throw new UnsupportedOperationException();
    }
}
