package com.bugenzhao.algorithms4.exercise.chapter2_2_3;

import com.bugenzhao.algorithms4.exercise.chapter2_1.InsertionX;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class MergeX {
    private static Comparable[] aux;
    private static int smallLength;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        smallLength = (a.length > 100) ? 15 : 0;
        sort(a, 0, a.length - 1);
    }


    // [lo, hi]
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        if (hi - lo <= smallLength) {
            InsertionX.sort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        if (less(a[mid + 1], a[mid]))
            merge(a, lo, mid, hi);
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

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[120];
        for (int i = 0; i < integers.length; ++i)
            integers[i] = StdRandom.uniform(100);
        MergeX.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
