package com.lddocy.section01.conditional.level03.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 정수 : ");
        int num1 = scanner.nextInt();

        System.out.print("두 번째 정수 : ");
        int num2 = scanner.nextInt();

        System.out.print("연산 기호를 입력하세요 : ");
        String op = scanner.next();

        int result = 0;
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                 result = num1 * num2;
                 break;
            case "/":
                 result = num1 / num2;
                 break;
            case "%" :
                result = num1 % num2;
            default:
                System.out.println("입력하신 연산은 없습니다. 프로그램을 종료합니다.");
                return;
        }

        System.out.println(num1 + op + num2 + " = " + result);
    }
}
