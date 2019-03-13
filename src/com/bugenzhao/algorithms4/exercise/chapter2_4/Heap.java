package com.bugenzhao.algorithms4.exercise.chapter2_4;

import edu.princeton.cs.algs4.StdRandom;

public class Heap {
    // [0, a.length - 1]
    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        for (int k = N / 2; k >= 0; --k) {
            sink(a, k, N);
        }
        while (N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k + 1 <= N) {
            int j = 2 * k + 1;
            if (j < N && less(a, j, j + 1)) ++j;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[99];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }
        StdRandom.shuffle(integers);
        sort(integers);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }
}
