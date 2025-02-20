package com.lddocy.section01.array.level02.normal;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 하나 입력하세요 : ");
        String str = sc.next();
        System.out.print("검색할 문자를 입력하세요 : ");
        char search = sc.next().charAt(0);

        char[] carr = str.toCharArray();

        int cnt = 0;
        for  (char ch : carr) {
            if (ch == search) {
                cnt++;
            }
        }

        System.out.println("입력하신 문자열 " + str + "에서 찾으시는 문자 " + search + "은 " + cnt + "개 입니다.");
    }
}
