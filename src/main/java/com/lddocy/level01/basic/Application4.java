package com.lddocy.level01.basic;

import java.util.HashSet;
import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> students = new HashSet<>();

        String input = "";
        while (!input.equals("exit")) {
            System.out.print("학생 ID 입력 ('exit' 입력 시 종료) : ");
            input = sc.nextLine();

            if (input.equals("exit")) {
                break;
            } else if (students.contains(input)) {
                System.out.println("이미 등록 된 ID 입니다. ");
                continue;
            }

            students.add(input);
            System.out.println("ID가 추가 되었습니다. ");
        }

        System.out.println("모든 학생의 ID : " + students);
        sc.close();
    }

}
