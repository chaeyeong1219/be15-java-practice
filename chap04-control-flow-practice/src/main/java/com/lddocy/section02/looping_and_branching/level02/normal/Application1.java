package com.lddocy.section02.looping_and_branching.level02.normal;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하세요 : ");
        String str = sc.nextLine();

        char[] ch = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
            System.out.println(i + " : " + ch[i]);
        }

    }
}
