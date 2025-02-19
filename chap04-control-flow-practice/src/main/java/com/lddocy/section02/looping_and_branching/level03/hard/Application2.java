package com.lddocy.section02.looping_and_branching.level03.hard;

import java.util.Random;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int rNum = random.nextInt(100) + 1;

        int input = 0;
        int cnt = 0;
        while (input != rNum) {
            System.out.print("정수를 입력하세요 : ");
            input = sc.nextInt();
            cnt++;
            if (input > rNum) {
                System.out.println("입력하신 정수보다 작습니다. ");
            } else if (input < rNum) {
                System.out.println("입력하신 정수보다 큽니다. ");
            } else {
                System.out.println("정답입니다. " + cnt + "회만에 정답을 맞추셨습니다.");
                return;
            }
        }

    }
}
