package com.bugenzhao.algorithms4.exercise.chapter3_1_4;

import java.util.Scanner;

public class HashTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(hash(scanner.next()));
        }
    }

    public static int hash(String str) {
        return str.hashCode();
    }
}
