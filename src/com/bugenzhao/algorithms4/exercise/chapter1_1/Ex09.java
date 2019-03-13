package com.bugenzhao.algorithms4.exercise.chapter1_1;

import java.util.Scanner;

public class Ex09 {
    public static String myToBinaryString(int N) {
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = n % 2 + s;
        return s;
    }

    public static void main(String[] args) {
        int N;
        Scanner Sc = new Scanner(System.in);
        N = Sc.nextInt();
        String s = myToBinaryString(N);
        System.out.println(s);
        Sc.close();
    }
}
