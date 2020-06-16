package com.janguo.javabasic.concurrent.thread.tactics;

public class TestTax {

    /**
     * 策略模式
     */
    public static void main(String[] args) {
        /*
        Staff janGuo = new Staff("JanGuo", 10000d, 20000d);
        janGuo.setCalculator(new SimpCalculator());
        */
        Staff janGuo = new Staff("JanGuo", 10000d, 20000d, (l, b) -> {
            return l * 0.2 + b * 0.1;
        });
        System.out.println(janGuo.getTax());
    }
}
