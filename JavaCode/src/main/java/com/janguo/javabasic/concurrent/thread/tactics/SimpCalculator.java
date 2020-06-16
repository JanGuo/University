package com.janguo.javabasic.concurrent.thread.tactics;

public class SimpCalculator implements Calculator {

    private final double LABORAGE_TAX = 0.1;
    private final double BONUS_TAX = 0.15;

    @Override
    public Double calculate(Double laborage, Double bonus) {
        return laborage * LABORAGE_TAX + bonus * BONUS_TAX;
    }
}
