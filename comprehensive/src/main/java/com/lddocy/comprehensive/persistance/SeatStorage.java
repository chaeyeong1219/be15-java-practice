package com.lddocy.comprehensive.persistance;

import com.lddocy.comprehensive.domain.Seat;

import java.util.List;

public interface SeatStorage {
    void saveSeats(List<Seat> seat);
    List<Seat> loadSeats();
}
