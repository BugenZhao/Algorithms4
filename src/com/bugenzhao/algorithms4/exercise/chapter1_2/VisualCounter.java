package com.bugenzhao.algorithms4.exercise.chapter1_2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class VisualCounter {

    private int count;
    private int max_count;
    private int op_count;
    private int max_op_count;

    public VisualCounter(int N, int max) {
        max_op_count = N;
        max_count = max;
        op_count = 0;
        count = 0;
        StdDraw.setXscale(0, max_op_count);
        StdDraw.setYscale(-max_count, max_count);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.01);
        StdDraw.point(0, 0);
    }

    public void increment() {
        if (count >= max_count || op_count == max_op_count) {
            System.out.println("ERROR!");
            return;
        }
        ++count;
        ++op_count;
        StdDraw.point(op_count, count);
    }

    public void decrement() {
        if (count <= -max_count || op_count == max_op_count) {
            System.out.println("ERROR!");
            return;
        }
        --count;
        ++op_count;
        StdDraw.point(op_count, count);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        VisualCounter counter = new VisualCounter(20, 10);
        for (int i = 0; i < 20; ++i) {
            int tmp = StdIn.readInt();
            if (tmp >= 0)
                counter.increment();
            else
                counter.decrement();
        }
    }
}
