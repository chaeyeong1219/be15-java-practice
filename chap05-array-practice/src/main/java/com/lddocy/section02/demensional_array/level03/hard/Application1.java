package com.lddocy.section02.demensional_array.level03.hard;

import java.util.Random;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rows, cols;
        while (true) {
            System.out.print("가로 행의 수를 입력하세요 : ");
            rows = sc.nextInt();
            if (rows >= 1 && rows <= 10) break;
            System.out.println("반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요.");
        }

        while (true) {
            System.out.print("세로 열의 수를 입력하세요 : ");
            cols = sc.nextInt();
            if (cols >= 1 && cols <= 10) break;
            System.out.println("반드시 1~10까지의 정수를 입력해야 합니다. 다시 입력하세요.");
        }

        char[][] arr = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = (char) ('A' + random.nextInt(26));
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
