package com.lddocy.level01.basic.student.model.dto;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<StudentDTO> studentInfo = new ArrayList<>();
        char answer = 'y';

        while (answer == 'y' || answer == 'Y') {
            System.out.print("학년 : ");
            int grade = sc.nextInt();

            System.out.print("반 : ");
            int classroom = sc.nextInt();

            sc.nextLine();
            System.out.print("이름 : ");
            String name = sc.nextLine();

            System.out.print("국어점수 : ");
            int kor = sc.nextInt();

            System.out.print("영어점수 : ");
            int eng = sc.nextInt();

            System.out.print("수학점수 : ");
            int math = sc.nextInt();

            StudentDTO studentDTO = new StudentDTO(grade, classroom, name, kor, eng, math);
            studentInfo.add(studentDTO);

            System.out.print("계속 추가할 겁니까 ? (y/n): ");
            answer = sc.next().charAt(0);
        }

        for (StudentDTO student : studentInfo) {
            System.out.println(student.getInformation());
        }

        sc.close();
    }
}
