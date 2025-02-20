package com.lddocy.section01.array.level04.advanced;

import java.util.Arrays;
import java.util.Random;

public class Application1 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(45) + 1;
        }
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
