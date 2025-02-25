package com.lddocy.level01.basic;

import com.lddocy.level01.basic.exception.InvalidAgeException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*생년월일을 입력 받아 만 20세 미만일 경우
InvalidAgeException이라는 사용자 정의 예외를 발생시키는 프로그램을 작성한다.*/
public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("생년월일 입력 (yyyy-MM-dd 양식으로 작성) : ");
            String birthDay = sc.nextLine();

            LocalDate birthDate = LocalDate.parse(birthDay);
            LocalDate today = LocalDate.now();

            int age = Period.between(birthDate, today).getYears();

            if (age < 20) {
                throw new InvalidAgeException("만 20세 미만은 입장 불가입니다.");
            } else {
                System.out.println("입장하셔도 됩니다.");
            }

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("날짜 양식을 잘못 입력하셨습니다. ");
        } finally {
            sc.close();
        }

    }
}