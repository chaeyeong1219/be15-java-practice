package com.lddocy.comprehensive.domain;

public enum SeatGrade {
    R, S, A;

    public static SeatGrade fromString(String grade) {
        return switch (grade.toUpperCase()) {
            case "R" -> R;
            case "S" -> S;
            case "A" -> A;
            default -> throw new IllegalArgumentException("Invalid SeatGrade: " + grade);
        };
    }
}
