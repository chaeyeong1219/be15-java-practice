package com.lddocy.level01.basic;

import java.io.*;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("원본 파일의 이름을 입력하세요 : ");
        String originName = sc.nextLine();

        System.out.print("복사 파일의 이름을 입력하세요 : ");
        String copyName = sc.nextLine();

        try {
            File originFile = new File(originName);
            File copyFile = new File(copyName);

            FileInputStream fis = new FileInputStream(originFile);
            FileOutputStream fos = new FileOutputStream(copyFile);

            byte[] bytes = new byte[1024];

            int value;
            while ((value = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, value);
            }

            System.out.println("파일 복사가 성공적으로 완료 되었습니다. ");

            fis.close();
            fos.close();

        } catch (IOException e) {
            System.out.println("오류 : " + e.getMessage());
        }
    }
}
