package com.lddocy.level01.basic;

import java.util.HashMap;
import java.util.Scanner;

public class Application6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> phones = new HashMap<>();

        while (true) {
            System.out.print("이름과 전화번호를 띄어쓰기 기준으로 입력하세요 ");
            System.out.print("(검색: 'search', 종료: 'exit') : ");
            String input = sc.nextLine();

            if (input.equals("exit")) break;

            if (input.equals("search")) {
                System.out.print("검색 할 이름 : ");
                String search = sc.nextLine();

                if (phones.containsKey(search)) {
                    System.out.println(search + " 씨의 전화번호 : " + phones.get(search));
                } else {
                    System.out.println(search + " 님의 전화번호는 등록되어 있지 않습니다.");
                }
                continue;
            }

            String[] sarr = input.split(" ");
            if (sarr.length != 2) {
                System.out.println("입력이 잘못되었습니다. 다음 양식으로 입력해주세요 : <이름> <전화번호>");
                continue;
            }

            phones.put(sarr[0], sarr[1]);
            System.out.println("추가 완료 : " + sarr[0] + " " + sarr[1]);
        }

        sc.close();
    }

}
