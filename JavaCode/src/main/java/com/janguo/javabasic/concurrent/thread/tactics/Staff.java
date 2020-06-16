package com.janguo.javabasic.concurrent.thread.tactics;

public class Staff {
    private String name;
    private double laborage;
    private double bonus;
    private Calculator calculator;

    public Staff(String name, double laborage, double bonus) {
        this.name = name;
        this.laborage = laborage;
        this.bonus = bonus;
    }

    public Staff(String name, double laborage, double bonus, Calculator calculator) {
        this.name = name;
        this.laborage = laborage;
        this.bonus = bonus;
        this.calculator = calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public double getTax() {
        return calculator.calculate(laborage, bonus);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLaborage() {
        return laborage;
    }

    public void setLaborage(double laborage) {
        this.laborage = laborage;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
