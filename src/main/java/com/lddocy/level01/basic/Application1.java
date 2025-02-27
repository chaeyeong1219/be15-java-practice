package com.lddocy.level01.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> scoreList = new ArrayList<>();

        char q = 'y';
        int sum = 0;
        while (q == 'y' || q == 'Y') {
            System.out.print("학생 성적 : ");
            int score = sc.nextInt();
            scoreList.add(score);

            System.out.print("추가 입력하려면 y : ");
            q = sc.next().charAt(0);

            sum += score;
        }

        System.out.println("학생 인원 : " + scoreList.size());

        double avg = sum / scoreList.size();
        System.out.println("평균 점수 : " + avg);

        sc.close();
    }

}
