package com.bwsw.interview.power;

public class PowerResult {

    private final int number;
    private final int power;
    private final int result;

    public PowerResult(int number, int power, int result) {
        this.number = number;
        this.power = power;
        this.result = result;
    }

    public int getNumber() {
        return number;
    }

    public int getPower() {
        return power;
    }

    public int getResult() {
        return result;
    }
}
