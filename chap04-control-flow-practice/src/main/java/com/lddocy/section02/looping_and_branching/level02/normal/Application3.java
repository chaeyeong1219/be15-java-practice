package com.lddocy.section02.looping_and_branching.level02.normal;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int num = sc.nextInt();

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                result.append("박");
            } else {
                result.append("수");
            }
        }

        System.out.println(result);
    }
}
