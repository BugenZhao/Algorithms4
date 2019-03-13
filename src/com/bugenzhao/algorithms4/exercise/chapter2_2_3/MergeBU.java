package com.bugenzhao.algorithms4.exercise.chapter2_2_3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class MergeBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int N = a.length;
        for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        }
    }


    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[100];
        for (int i = 0; i < integers.length; ++i)
            integers[i] = StdRandom.uniform(100);
        MergeBU.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
