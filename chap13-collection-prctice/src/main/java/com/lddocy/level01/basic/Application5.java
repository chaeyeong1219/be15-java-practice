package com.lddocy.level01.basic;

import java.util.Scanner;
import java.util.TreeSet;

public class Application5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<String> words = new TreeSet<>();

        String input = "";
        while (!input.equals("exit")) {
            System.out.print("단어 입력 ('exit' 입력 시 종료) : ");
            input = sc.nextLine();

            if (input.equals("exit")) break;

            words.add(input);
        }

        System.out.println("정렬 된 단어 : " + words);
        sc.close();
    }
}

