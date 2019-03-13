package com.bugenzhao.algorithms4.exercise.chapter2_4;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;

public class MedianFinding {
    private MaxPQ<Double> pqa;
    private MinPQ<Double> pqb;
    private int N;

    public MedianFinding() {
        pqa = new MaxPQ<>();
        pqb = new MinPQ<>();
        N = 0;
    }

    public static void main(String[] args) {
        MedianFinding medianFinding = new MedianFinding();
        while (true) {
            int tmp = StdIn.readInt();
            if (tmp == 0)
                System.out.println(medianFinding.getMedian());
            else
                medianFinding.insert(tmp);
        }
    }

    public void insert(double item) {
        if (N == 0) {
            pqa.insert(item);
            ++N;
            return;
        }
        if (item < pqa.max()) {
            pqa.insert(item);
        } else {
            pqb.insert(item);
        }
        if (pqa.size() - pqb.size() == 2) {
            pqb.insert(pqa.delMax());
        } else if (pqb.size() - pqa.size() == 2) {
            pqa.insert(pqb.delMin());
        }
        ++N;
    }

    public double getMedian() {
        if (N % 2 == 0) {
            return (pqa.max() + pqb.min()) / 2;
        } else {
            return pqa.size() > pqb.size() ? pqa.max() : pqb.min();
        }
    }

    public int size() {
        return N;
    }
}
