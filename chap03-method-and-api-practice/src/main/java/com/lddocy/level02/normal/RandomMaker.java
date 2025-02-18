package com.lddocy.level02.normal;

import java.util.Arrays;
import java.util.Random;

public class RandomMaker {
    public int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) + min;
    }

    public String randomUpperAlpabet(int length) {
        Random random = new Random();
        char[] ch = new char[length];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            ch[i] = (char) (random.nextInt(26) + 'A');
            result.append(ch[i]);
        }
        return result.toString();
    }

    public String rockPaperScissors() {
        String result;
        Random random = new Random();
        int num = random.nextInt(3);
        if (num == 0)
            result = "가위";
        else if (num == 1)
            result = "바위";
        else
            result = "보";
        return result;
    }

    public String tossCoin() {
        String result;
        Random random = new Random();
        int num = random.nextInt(2);
        if (num == 0)
            result = "앞면";
        else
            result = "뒷면";
        return result;
    }
}
