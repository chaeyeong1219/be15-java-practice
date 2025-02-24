package com.lddocy.level01.basic;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력: ");
        String input = sc.nextLine();

        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        String converted = result.toString().trim();

        System.out.println("변환된 문자열: " + converted);
        System.out.println("총 단어 개수: " + words.length);

    }
}
