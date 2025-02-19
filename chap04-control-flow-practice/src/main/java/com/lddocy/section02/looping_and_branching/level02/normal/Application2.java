package com.lddocy.section02.looping_and_branching.level02.normal;

public class Application2 {
    public static void main(String[] args) {
        char[] ch = new char[26];
        for (int i = 0; i < ch.length; i++) {
            ch[i] = (char)(i + 'a');
            System.out.print(ch[i]);
        }
    }
}
