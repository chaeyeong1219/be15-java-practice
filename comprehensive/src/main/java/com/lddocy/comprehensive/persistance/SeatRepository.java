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
    public List<Seat> searchSeatByUserId(String userId) {
        return seatList.stream()
                .filter(seat -> userId.equals(seat.getUserId()))
                .collect(Collectors.toList());
    }

    // 2. 등급별 좌석 조회
    public Map<Character, Map<String, Object>> countAvailableSeatsByGrade() {
        return seatList.stream()
                .filter(seat -> seat.getStatus() == 'N') // 예약되지 않은 좌석
                .collect(Collectors.groupingBy(
                        Seat::getGrade,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                seats -> {
                                    Map<String, Object> result = new HashMap<>();
                                    result.put("count", (long) seats.size()); // 좌석 개수
                                    result.put("seatNumbers", seats.stream()
                                            .map(Seat::getSeatNumber) // 좌석 번호 리스트
                                            .collect(Collectors.toList()));
                                    return result;
                                }
                        )
                ));
    }

    // 3. 좌석 예매
    public boolean reserveSeat(int seatNumber, String userId) {
        for (int i = 0; i < seatList.size(); i++) {
            Seat seat = seatList.get(i);

            if (seat.getSeatNumber() == seatNumber) {
                if (seat.getStatus() == 'N') {
                    Seat reservedSeat = new Seat(seatNumber, userId, 'R');
                    seatList.set(i, reservedSeat);

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
    public boolean cancelReservation(String userId, int seatNumber) {
        for (int i = 0; i < seatList.size(); i++) {
            Seat seat = seatList.get(i);
            if (seat.getSeatNumber() == seatNumber && userId.equals(seat.getUserId())) {
                Seat availableSeat = new Seat(seatNumber, null, 'N', seat.getGrade());
                seatList.set(i, availableSeat);
                seatStorage.saveSeats(seatList);
                return true;
            }
        }
        return false;
    }

}
