package com.lddocy.level01.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> customers = new LinkedList<>();

        String input = "";
        while (!input.equals("exit")) {
            System.out.print("대기 고객 이름 입력 ");
            System.out.print("(다음 고객으로 넘어가려면 'next', 종료하려면 'exit') : ");
            input = sc.nextLine();

            if (input.equals("exit")) break;

            if (input.equals("next")) {
                if (customers.isEmpty()) {
                   System.out.println("대기 고객이 없습니다.");
                } else {
                    System.out.println(customers.poll() + " 고객님 차례입니다. ");
                }
                continue;
            }

            customers.add(input);
            System.out.println(input + " 고객님 대기 등록 되었습니다. ");
        }

        sc.close();
    }

}
