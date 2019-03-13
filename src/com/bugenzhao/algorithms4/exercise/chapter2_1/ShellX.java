package com.bugenzhao.algorithms4.exercise.chapter2_1;

public class ShellX {
    public static void sort(Comparable[] items) {
        int N = items.length;
        int h = 1;
        while (h < N / 3)
            h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                int j = i;
                Comparable tmp = items[j];
                for (; j >= h && less(tmp, items[j - h]); j -= h)
                    items[j] = items[j - h];
                items[j] = tmp;
            }
            h /= 3;
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
