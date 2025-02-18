package com.lddocy.level01.basic;

public class Calculator {
    public void checkMethod() {
        System.out.println("메소드 호출 확인");
    }

    public int sum1to10() {
        int result = 0;
        for (int i = 1; i <= 10; i++) {
            result += i;
        }
        return result;
    }

    public void checkMaxNumber(int a, int b) {
        System.out.print(Math.max(a, b));
    }

    public int sumTwoNumber(int a, int b) {
        return a + b;
    }

    int minusTwoNumber(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return max - min;
    }

}
