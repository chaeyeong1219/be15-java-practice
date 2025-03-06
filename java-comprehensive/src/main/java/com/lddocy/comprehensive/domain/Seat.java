package com.lddocy.comprehensive.domain;

import java.io.Serializable;

public class Seat implements Serializable {
    private static final long serialVersionUID = 3152369404337571254L;

    private int seatNumber;
    private String grade;
    private Long price;
    private String status;
    private String userId;
    private String password;

    public Seat(String userId, String password, String status) {
        this.userId = userId;
        this.password = password;
        this.status = status;
    }

    public Seat(int seatNumber, String userId, String password, String status, String grade, Long price) {
        this.seatNumber = seatNumber;
        this.userId = userId;
        this.password = password;
        this.status = status;
        this.grade = grade;
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | 등급: %s | 좌석번호: %d | 가격: %d원 | 상태: %s",
                (userId != null ? userId : "없음"), grade, seatNumber, price, status);
    }


}
