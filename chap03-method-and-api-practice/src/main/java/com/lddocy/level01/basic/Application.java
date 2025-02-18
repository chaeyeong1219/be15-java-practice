package com.lddocy.level01.basic;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        //메소드 호출 확인용 메소드 호출
        calculator.checkMethod();
        //함수를 호출하여 1~10까지의 합을 리턴 받아 출력
        System.out.print("1부터 10까지의 합 : ");
        System.out.println(calculator.sum1to10());
        //10, 20 두 개의 정수를 매개변수로 하여 큰 값 출력하는 메소드 호출
        System.out.print("두 수 중 큰 수는 ");
        calculator.checkMaxNumber(10, 20);
        System.out.println("이다. ");
        //10, 20 두 개의 정수를 매개변수로 하여 두 수를 더하는 메소드 호출 후 리턴값 출력
        System.out.print("10과 20의 합은 : ");
        System.out.println(calculator.sumTwoNumber(10, 20));
        //10, 5 두 개의 정수를 매개변수로 하여 두 수의 차를 구하는 메소드 호출 후 리턴값 출력
        System.out.print("10과 5의 차는 : ");
        System.out.println(calculator.minusTwoNumber(10, 5));

    }
}
