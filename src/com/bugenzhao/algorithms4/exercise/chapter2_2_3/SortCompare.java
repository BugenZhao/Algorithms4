package com.bugenzhao.algorithms4.exercise.chapter2_2_3;

import com.bugenzhao.algorithms4.exercise.chapter2_1.Insertion;
import com.bugenzhao.algorithms4.exercise.chapter2_1.Selection;
import com.bugenzhao.algorithms4.exercise.chapter2_1.Shell;
import com.bugenzhao.algorithms4.exercise.chapter2_1.ShellX;
import edu.princeton.cs.algs4.InsertionX;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

    static double time(String alg, Double[] a) {
        Stopwatch stopwatch = new Stopwatch();
        if (alg.equals("Insertion"))
            Insertion.sort(a);
        else if (alg.equals("Selection"))
            Selection.sort(a);
        else if (alg.equals("InsertionX"))
            InsertionX.sort(a);
        else if (alg.equals("Shell"))
            Shell.sort(a);
        else if (alg.equals("ShellX"))
            ShellX.sort(a);
        else if (alg.equals("Merge"))
            Merge.sort(a);
        else if (alg.equals("MergeX"))
            MergeX.sort(a);
        else if (alg.equals("Quick"))
            Quick.sort(a);
        return stopwatch.elapsedTime();
    }

    static double timeRandomInput(String alg, int N, int T) {
        double totalTime = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            totalTime += time(alg, a);
        }
        return totalTime;
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            int N = StdIn.readInt();
            int T = StdIn.readInt();
            System.out.println("Insertion : " + timeRandomInput("Insertion", N, T));
            System.out.println("InsertionX: " + timeRandomInput("InsertionX", N, T));
            System.out.println("Selection : " + timeRandomInput("Selection", N, T));
            System.out.println("Shell     : " + timeRandomInput("Shell", N, T));
            System.out.println("ShellX    : " + timeRandomInput("ShellX", N, T));
            System.out.println("Merge     : " + timeRandomInput("Merge", N, T));
            System.out.println("MergeX    : " + timeRandomInput("MergeX", N, T));
            System.out.println("Quick     : " + timeRandomInput("Quick", N, T));
        }
    }
}
