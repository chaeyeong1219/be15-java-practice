package com.lddocy.level01.basic;

import java.util.InputMismatchException;
import java.util.Scanner;

/* 사용자로부터 두 개의 정수를 입력 받아 나눗셈을 수행하는 프로그램을 작성한다.
정수가 아닌 값을 입력 받을 경우와 나누는 수가 0일 경우의 exception을 각각 처리하고,
마지막에는 항상 실행되는 메시지를 출력한다.
* */
public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("분자 입력 : ");
            int denominator = sc.nextInt();

            System.out.print("분모 입력 : ");
            int numerator = sc.nextInt();

            int result = denominator / numerator;
            System.out.println("결과 : " + result);

        } catch (InputMismatchException e) {
            System.out.println("오류 : 유효한 정수를 입력하세요.");

        } catch (ArithmeticException e) {
            System.out.println("오류 : 0으로 나누는 것은 허용되지 않습니다.");

        } finally {
            System.out.println("실행이 완료되었습니다.");
        }

        sc.close();

    }
}


