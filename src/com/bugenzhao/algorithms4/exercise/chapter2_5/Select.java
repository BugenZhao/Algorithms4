package com.bugenzhao.algorithms4.exercise.chapter2_5;

import com.bugenzhao.algorithms4.exercise.chapter2_2_3.Quick;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Select {
    public static Comparable select(Comparable[] a, int k) {
        --k;
        Comparable[] aa = a.clone();
        StdRandom.shuffle(aa);
        int lo = 0, hi = aa.length - 1;
        while (hi > lo) {
            int j = Quick.partition(aa, lo, hi);
            if (j == k) return aa[k];
            else if (j < k) lo = j + 1;
            else hi = j - 1;
        }
        return aa[k];
    }

    public static void main(String[] args) {
        Integer[] integers = {5, 4, 2, 6, 7, 8, 9, 1, 3};
        System.out.println(select(integers, 1));
        System.out.println(Arrays.toString(integers));
    }
}
