package com.lddocy.comprehensive.persistance;

import com.lddocy.comprehensive.domain.Seat;

import java.util.*;
import java.util.stream.Collectors;

public class SeatRepository {
    private final SeatStorage seatStorage;
    private final List<Seat> seatList;

    public SeatRepository(SeatStorage seatStorage) {
        this.seatStorage = seatStorage;
        this.seatList = seatStorage.loadSeats();
    }

    // 1. 회원별 예매 좌석 조회 - 회원 ID로 조회
    public List<Seat> searchSeatByUserId(String userId, String password) {
        // 디버깅용 코드 - 전체 리스트 출력
//        for (Seat seat : seatList) {
//            System.out.println("좌석번호: " + seat.getSeatNumber() + ", ID: " + seat.getUserId() + ", 비밀번호: " + seat.getPassword());
//        }

        List<Seat> result = seatList.stream()
                .filter(seat -> userId.equals(seat.getUserId()) && password.equals(seat.getPassword()))
                .collect(Collectors.toList());

        return result;
    }

// 2. 등급별 좌석 조회
public Map<String, Map<String, Object>> countAvailableSeatsByGrade() {
    return seatList.stream()
            .filter(seat -> seat.getStatus().equals("예매 가능")) // 예약되지 않은 좌석
            .collect(Collectors.groupingBy(
                    Seat::getGrade,
                    Collectors.collectingAndThen(
                            Collectors.toList(),
                            seats -> {
                                Map<String, Object> result = new HashMap<>();
                                result.put("총 잔여좌석", (long) seats.size());
                                result.put("좌석번호", seats.stream()
                                        .map(Seat::getSeatNumber)
                                        .collect(Collectors.toList()));
                                return result;
                            }
                    )
            ));
}

// 3. 좌석 예매
public boolean reserveSeat(String grade, int seatNumber, String userId, String password) {
    for (int i = 0; i < seatList.size(); i++) {
        Seat seat = seatList.get(i);

        if (seat.getGrade().equals(grade) && seat.getSeatNumber() == seatNumber) {
            if (seat.getStatus().equals("예매 가능")) {
                seat.setUserId(userId);
                seat.setPassword(password);
                seat.setStatus("예매 완료");

                seatStorage.saveSeats(seatList);
                return true;
            } else {
                return false;
            }
        }
    }
    return false;
}


// 4. 예매 취소
public boolean cancelReservation(String userId, String password, String grade, int seatNumber) {
    for (int i = 0; i < seatList.size(); i++) {
        Seat seat = seatList.get(i);
        if (seat.getGrade().equals(grade) && seat.getSeatNumber() == seatNumber &&
                userId.equals(seat.getUserId()) && password.equals(seat.getPassword())) {

            seat.setUserId(null);
            seat.setPassword(null);
            seat.setStatus("예매 가능");

            seatStorage.saveSeats(seatList);
            return true;
        }
    }
    return false;
}

}

