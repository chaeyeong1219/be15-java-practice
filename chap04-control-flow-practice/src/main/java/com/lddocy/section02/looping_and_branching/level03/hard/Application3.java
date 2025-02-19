package com.lddocy.section02.looping_and_branching.level03.hard;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z')) {
                System.out.println("영문자가 아닌 문자가 포함되어 있습니다.");
                return;
            }
        }

        System.out.print("문자 입력 : ");
        char searchChar = scanner.next().charAt(0);

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == searchChar) {
                count++;
            }
        }

        System.out.println("포함된 개수 : " + count + "개");
    }
}
