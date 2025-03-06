package com.lddocy.comprehensive.persistance;

import com.lddocy.comprehensive.domain.Seat;

import java.io.*;
import java.util.*;

public class FileSeatStorage implements SeatStorage {
    private static final String FILE_PATH = "src/main/java/com/lddocy/comprehensive/db/seatDB.dat";

    @Override
    public void saveSeats(List<Seat> seats) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(seats);
        } catch (IOException e) {
            throw new RuntimeException("좌석 예매 중 오류 발생", e);
        }
    }

    @Override
    public List<Seat> loadSeats() {
        List<Seat> seats = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("좌석 데이터 파일이 없어 새로 생성합니다.");
            saveSeats(getDefaultSeats());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Seat>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("좌석 정보를 모두 로딩하였습니다.");
            return seats;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("좌석 검색 중 오류 발생", e);
        }
    }

    // 초기 데이터
    private List<Seat> getDefaultSeats() {
        List<Seat> defaultSeats = new ArrayList<>();
        defaultSeats.add(new Seat(1, null, null, "예매 가능", "R", 130000L));
        defaultSeats.add(new Seat(2, "user01", "password01", "예매 완료", "R", 130000L));
        defaultSeats.add(new Seat(3, null, null, "예매 가능", "S", 110000L));
        defaultSeats.add(new Seat(4, "user02","password02", "예매 완료", "S", 110000L));
        defaultSeats.add(new Seat(5, null, null,  "예매 가능", "S", 110000L));
        defaultSeats.add(new Seat(6, "user03", "password03", "예매 완료", "S", 110000L));
        defaultSeats.add(new Seat(7, "user03", "password03", "예매 완료", "A", 90000L));
        defaultSeats.add(new Seat(8, "user04", "password04", "예매 완료", "A", 90000L));
        defaultSeats.add(new Seat(9, null, null, "예매 가능", "A", 90000L));
        defaultSeats.add(new Seat(10, null, null, "예매 가능", "A", 90000L));
        defaultSeats.add(new Seat(11, null, null, "예매 가능", "A", 90000L));
        defaultSeats.add(new Seat(12, null, null, "예매 가능", "A", 90000L));

        return defaultSeats;
    }



}
