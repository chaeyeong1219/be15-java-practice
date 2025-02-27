package com.lddocy.level01.basic;

import java.util.*;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> urlQueue = new LinkedList<>();

        String input = "";
        while (input != "exit") {
            System.out.print("방문 url을 입력하세요 (단, exit을 입력하면 종료) : ");
            input = sc.nextLine();

            if (input.equals("exit")) return;

            urlQueue.offer(input);

            if (urlQueue.size() > 5) {
                urlQueue.poll();
            }

            List<String> recentUrls = new ArrayList<>(urlQueue);
            Collections.reverse(recentUrls);

            System.out.print("최근 방문 url : ");
            System.out.println(recentUrls);
        }

        sc.close();
    }

}
