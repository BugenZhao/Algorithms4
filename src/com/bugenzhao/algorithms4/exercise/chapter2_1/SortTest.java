package com.bugenzhao.algorithms4.exercise.chapter2_1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Integer[] integers = new Integer[20];
        for (int i = 0; i < integers.length; ++i)
            integers[i] = StdRandom.uniform(100);
        ShellX.sort(integers);
        System.out.println(Arrays.toString(integers));
    }
}
