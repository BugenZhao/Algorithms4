package com.bugenzhao.algorithms4.exercise.chapter2_5;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Inversions {
    //利用归并排序，计算一个排列的逆序数对个数
    private Inversions() {
    }

    public static long count(int[] a) {
        int[] b = new int[a.length];
        int[] aux = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        long inversions = count(aux, b, 0, a.length - 1);
        return inversions;
    }

    private static long count(int[] aux, int[] b, int lo, int hi) {
        long inversions = 0;
        if (hi <= lo) return 0;
        int mid = lo + (hi - lo) / 2;
        inversions += count(aux, b, lo, mid);
        inversions += count(aux, b, mid + 1, hi);
        inversions += merge(aux, b, lo, mid, hi);
        return inversions;
    }

    private static long merge(int[] aux, int[] b, int lo, int mid, int hi) {
        long inversions = 0;
        for (int i = lo; i <= hi; i++) {
            aux[i] = b[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                b[k] = aux[j++];
            } else if (j > hi) {
                b[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                b[k] = aux[j++];
                inversions += (mid - i + 1);
            } else {
                b[k] = aux[i++];
            }
        }
        return inversions;
    }

    public static int[] randomPermutation(int N) {
        int[] permutation = new int[N];
        for (int i = 0; i < N; i++) {
            permutation[i] = i;
        }
        StdRandom.shuffle(permutation);
        return permutation;
    }

    public static void main(String[] args) {
        int[] p = randomPermutation(5);
        System.out.println(Arrays.toString(p));
        System.out.println("Inversions: " + count(p));
    }
}
