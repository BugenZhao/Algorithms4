package com.bugenzhao.algorithms4.exercise.chapter1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex15 {

    public static int[] readInts(String name) {
        In in = new In(name);
        String input = StdIn.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; ++i)
            ints[i] = Integer.parseInt(words[i]);
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = readInts("test.txt");
        for (int x : ints)
            StdOut.print(x + " ");
    }
}
