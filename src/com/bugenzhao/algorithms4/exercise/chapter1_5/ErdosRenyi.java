package com.bugenzhao.algorithms4.exercise.chapter1_5;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Scanner;

public class ErdosRenyi {

    static void count(int N, UF uf) {
        int pqCount = 0;
        while (uf.count() > 1) {
            int p = StdRandom.uniform(N);
            int q = StdRandom.uniform(N);
            ++pqCount;
            if (!uf.connected(p, q))
                uf.union(p, q);
        }
        System.out.println("N         : " + N);
        System.out.println("pqCount   : " + pqCount);
        System.out.println("1/2N*lnN  : " + (long) N * Math.log(N) / 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int N = scanner.nextInt();
            Stopwatch stopwatch = new Stopwatch();
            count(N, new WeightedQuickUnionUF(N));
            System.out.println("(WQuickUnion " + stopwatch.elapsedTime() + ")");
            Stopwatch stopwatch3 = new Stopwatch();
            count(N, new WeightedQuickUnionPathCompressionUF(N));
            System.out.println("(WQuickUnionPC " + stopwatch.elapsedTime() + ")");
            /*Stopwatch stopwatch1 = new Stopwatch();
            count(N, new QuickUnionUF(N));
            System.out.println("(QuickUnion  " + stopwatch.elapsedTime() + ")");
            Stopwatch stopwatch2 = new Stopwatch();
            count(N, new QuickFindUF(N));
            System.out.println("(QuickFind   " + stopwatch.elapsedTime() + ")");*/
        }
    }
}
