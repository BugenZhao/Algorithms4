package com.bugenzhao.algorithms4.exercise.chapter2_2_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Quick3way {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    // [lo, hi]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        } // 现在 a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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
