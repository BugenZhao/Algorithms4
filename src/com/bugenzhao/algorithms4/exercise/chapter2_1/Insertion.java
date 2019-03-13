package com.bugenzhao.algorithms4.exercise.chapter2_1;

public class Insertion {
    public static void sort(Comparable[] items) {
        int N = items.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(items[j], items[j - 1]); --j)
                exch(items, j, j - 1);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }


}
