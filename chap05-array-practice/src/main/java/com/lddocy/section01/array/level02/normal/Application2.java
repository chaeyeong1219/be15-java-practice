package com.lddocy.section01.array.level02.normal;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("주민등록번호를 입력하세요 : ");
        String rNum = sc.next();
        char[] carr = rNum.toCharArray();

        for (int i = 8; i < carr.length; i++) {
            carr[i] = '*';
        }

        System.out.println(new String(carr));
    }
}
