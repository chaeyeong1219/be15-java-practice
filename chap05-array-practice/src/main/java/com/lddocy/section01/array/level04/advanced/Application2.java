package com.lddocy.section01.array.level04.advanced;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Set<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            set.add(random.nextInt(10));
        }

        int[] correctArr = new int[4];

        int index = 0;
        for (int num : set) {
            correctArr[index++] = num;
        }

        System.out.println(Arrays.toString(correctArr)); // 테스트용 지울거임
        System.out.println("숫자 야구 게임을 시작합니다!");

        int cnt = 10;
        while (cnt > 0) {
            System.out.println(cnt + "회 남으셨습니다.");
            System.out.print("4자리 숫자를 입력하세요 : ");
            String input = sc.nextLine();

            if (!input.matches("\\d{4}")) {
                System.out.println("4자리의 정수를 입력해야 합니다.");
                continue;
            }

            int[] userArr = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();

            int strikes = 0;
            int balls = 0;
            for (int i = 0; i < 4; i++) {
                if (userArr[i] == correctArr[i]) {
                    strikes++;
                } else {
                    for (int j = 0; j < 4; j++) {
                        if (i != j && userArr[i] == correctArr[j]) {
                            balls++;
                        }
                    }
                }
            }

            if (strikes == 4) {
                System.out.println("정답입니다!");
                return;
            }

            System.out.println("아쉽네요 " + strikes + "S " + balls + "B 입니다.");
            cnt--;
        }
        System.out.println("10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다.");
    }
}
