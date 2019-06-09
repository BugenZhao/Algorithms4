package com.bugenzhao.algorithms4.practice;

public class MrHe {
    public static void main(String[] args) {
        for (int s = 1; s <= 4; s++) {
            for (int a = 1; a <= 10; a++) {
                for (int b = 1; b <= 10; b++) {
                    for (int c = 1; c <= 10; c++) {
                        int P = s * c;
                        int Q = s * a + ((s * a) % 4 + 1) * b + ((((s * a) % 4 + 1) * b) % 4 + 1) * c;
                        if (Q < P)
                            System.out.println("Found: s=" + s + " a=" + a + " b=" + b + " c=" + c);
                    }
                }
            }
        }
    }
}
