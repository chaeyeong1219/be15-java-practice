package com.lddocy.section01.array.level03.hard;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("홀수인 양의 정수를 입력하세요 : ");
        int num = sc.nextInt();

        if (num <= 0 || num % 2 == 0) {
            System.out.println("양수 혹은 홀수만 입력해야 합니다.");
            return;
        }

        int[] arr = new int[num];

        int mid = num / 2;
        for (int i = 0; i <= mid; i++) {
            arr[i] = i + 1;
            arr[num - i - 1] = i + 1;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
