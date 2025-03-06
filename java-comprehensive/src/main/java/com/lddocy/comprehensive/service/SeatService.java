package com.lddocy.comprehensive.service;

import com.lddocy.comprehensive.domain.Seat;
import com.lddocy.comprehensive.persistance.SeatRepository;

import java.util.List;
import java.util.Map;

public class SeatService {
    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> searchSeatsByUserId(String userId, String password) {
        return seatRepository.searchSeatByUserId(userId, password);
    }

    public Map<String, Map<String, Object>> countAvailableSeatsByGrade() {
        return seatRepository.countAvailableSeatsByGrade();
    }

    public boolean reserveSeat(String grade, int seatNumber, String userId, String password) {
        return seatRepository.reserveSeat(grade, seatNumber, userId, password);
    }

    public boolean cancelReservation(String userId, String password, String grade, int seatNumber) {
        return seatRepository.cancelReservation(userId, password, grade, seatNumber);
    }

}
