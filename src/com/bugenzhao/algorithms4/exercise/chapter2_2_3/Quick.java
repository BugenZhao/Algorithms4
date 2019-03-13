package com.bugenzhao.algorithms4.exercise.chapter2_2_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    // [lo, hi]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = partition(a, lo, hi);
        sort(a, lo, mid - 1);
        sort(a, mid + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[1000000];
        for (int i = 0; i < integers.length; ++i)
            integers[i] = StdRandom.uniform(3);
        Merge.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
