package com.lddocy.section01.conditional.level04.advanced;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("월 급여 입력 : ");
        long salary = scanner.nextLong();

        System.out.print("매출액 입력 : ");
        long sell = scanner.nextLong();

        int bonusRate;
        if (sell >= 50000000) {
            bonusRate = 5;
        } else if (sell >= 30000000 && sell < 50000000) {
            bonusRate = 3;
        } else if (sell >= 10000000 && sell < 30000000) {
            bonusRate = 1;
        } else {
            bonusRate = 0;
        }

        long total = salary + (sell * bonusRate);

        System.out.println("======================");
        System.out.println("매출액 : " + sell);
        System.out.println("보너스율 : " + bonusRate +"%");
        System.out.println("월 급여 : " + salary);
        System.out.println("보너스 금액 : " + (sell * bonusRate) / 100);
        System.out.println("======================");
        System.out.println("총 급여 : " + total);
    }
}
