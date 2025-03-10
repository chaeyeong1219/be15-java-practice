package com.lddocy.comprehensive.ui;

import com.lddocy.comprehensive.domain.Seat;
import com.lddocy.comprehensive.persistance.FileSeatStorage;
import com.lddocy.comprehensive.persistance.SeatRepository;
import com.lddocy.comprehensive.service.SeatService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Application {
    private final SeatService seatService;
    private final Scanner scanner;

    public Application() {
        SeatRepository seatRepository = new SeatRepository(new FileSeatStorage());
        this.seatService = new SeatService(seatRepository);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n===== 콘서트 좌석 예매 시스템 =====");
            System.out.println("1. 회원별 예매 좌석 조회");
            System.out.println("2. 등급별 잔여 좌석 조회");
            System.out.println("3. 좌석 예매");
            System.out.println("4. 예매 취소");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> showUserReservations();
                    case 2 -> showAvailableSeatsByGrade();
                    case 3 -> reserveSeat();
                    case 4 -> cancelReservation();
                    case 9 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }
    }

    // 1. 회원별 예매 좌석 조회
    private void showUserReservations() {
        System.out.print("ID를 입력하세요 : ");
        String userId = scanner.nextLine();

        System.out.print("비밀번호를 입력하세요 : ");
        String password = scanner.nextLine();

        List<Seat> reservedSeats = seatService.searchSeatsByUserId(userId, password);
        if (reservedSeats.isEmpty()) {
            System.out.println("해당 회원이 예매한 좌석이 없습니다.");
        } else {
            reservedSeats.forEach(System.out::println);
        }
    }

    // 2. 등급별 잔여 좌석 조회
    private void showAvailableSeatsByGrade() {
        Map<String, Map<String, Object>> availableSeats = seatService.countAvailableSeatsByGrade();

        System.out.println("===== 등급별 잔여 좌석 =====");
        availableSeats.forEach((grade, details) -> {
            long totalSeats = (long) details.get("총 잔여좌석");
            int totalSeatsInt = (int) totalSeats;
            List<Integer> seatNumbers = (List<Integer>) details.get("좌석번호");

            System.out.println("좌석 등급: " + grade);
            System.out.println("총 잔여좌석: " + totalSeatsInt);
            System.out.println("좌석번호: " + seatNumbers);
            System.out.println("----------------");
        });
    }



    // 3. 좌석 예매
    private void reserveSeat() {
        System.out.print("ID를 입력하세요 : ");
        String userId = scanner.nextLine();

        System.out.print("비밀번호를 입력하세요 : ");
        String password = scanner.nextLine();

        System.out.print("예매할 좌석 등급을 선택하세요 (R/S/A) : ");
        String grade = scanner.nextLine().toUpperCase();

        System.out.print("예매할 좌석 번호를 입력하세요 : ");
        int seatNumber = scanner.nextInt();

        boolean reserve = seatService.reserveSeat(grade, seatNumber, userId, password);
        if (reserve) {
            System.out.println("좌석 예매 성공!");
        } else {
            System.out.println("좌석 예매 실패: 이미 예약된 좌석이거나 존재하지 않는 좌석입니다.");
        }
    }

    // 4. 예매 취소
    private void cancelReservation() {
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("ID를 입력하세요 : ");
                String userId = scanner.nextLine();

                System.out.print("비밀번호를 입력하세요 : ");
                String password = scanner.nextLine();

                System.out.print("취소할 좌석 등급을 입력하세요 : ");
                String grade = scanner.nextLine().toUpperCase();

                System.out.print("취소할 좌석 번호를 입력하세요 : ");
                int seatNumber = scanner.nextInt();

                boolean success = seatService.cancelReservation(userId, password, grade, seatNumber);
                if (success) {
                    System.out.println("예매 취소 성공!");
                    break;
                } else {
                    System.out.println("예매 취소 실패: 해당 좌석이 존재하지 않거나 본인의 예매가 아닙니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("오류 : 올바른 형식으로 입력해주세요!");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
