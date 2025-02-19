package com.lddocy.section02.looping_and_branching.level04.advanced;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열을 입력하세요 : ");
        String input = scanner.nextLine();

        System.out.print("숫자를 입력하세요 : ");
        int num = scanner.nextInt();
        num = num % 26;

        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char) ('A' + (ch - 'A' + num) % 26));
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ('a' + (ch - 'a' + num) % 26));
            } else {
                result.append(ch);
            }
        }

        System.out.println(result);
    }
}

