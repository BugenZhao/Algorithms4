package com.bugenzhao.algorithms4.exercise.chapter1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

public class UFTest {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        In in = new In("data/largeUF.txt");
        int N = in.readInt();
        UF uf = new WeightedQuickUnionByHeightUF(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            //System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");
        System.out.println(stopwatch.elapsedTime());
    }
}
