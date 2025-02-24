package com.lddocy.level01.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder(input.toLowerCase());

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ' && (ch < '가' || ch > '힣')) {
                sb.deleteCharAt(i);
                i--;
            }
        }

        String[] words = sb.toString().split("\\s+");

        Map<String, Integer> count = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        String mostFrequent = "";
        int maxCount = 0;

        System.out.println("===== 단어 빈도 =====");
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            if (entry.getValue() > maxCount) {
                mostFrequent = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        if (!mostFrequent.isEmpty()) {
            System.out.println("가장 빈도 높은 단어 : " + mostFrequent + " (" + maxCount + " 번)");
        }

    }
}
