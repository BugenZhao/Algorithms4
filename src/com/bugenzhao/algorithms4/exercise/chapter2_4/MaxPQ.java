package com.bugenzhao.algorithms4.exercise.chapter2_4;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ() {
        pq = (Key[]) new Comparable[2];
    }

    public MaxPQ(int M) {
        pq = (Key[]) new Comparable[M + 1];
    }

    public MaxPQ(Key[] a) {
        N = a.length;
        pq = (Key[]) new Comparable[N + 1];
        for (int i = 1; i <= N; i++) {
            pq[i] = a[i - 1];
        }
        for (int k = N / 2; k >= 1; --k) {
            sink(k);
        }
    }

    public static void main(String[] args) {
        Integer integer;
        MaxPQ<Integer> maxPQ = new MaxPQ<>();
        while (true) {
            integer = StdIn.readInt();
            if (integer == 0) maxPQ.delMax();
            else maxPQ.insert(integer);
            System.out.println(maxPQ);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int newN) {
        Key[] old = pq;
        pq = (Key[]) new Comparable[newN + 1];
        int length = Math.min(pq.length, old.length);
        for (int i = 0; i < length; i++) {
            pq[i] = old[i];
        }
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        if (N == pq.length - 1)
            resize(2 * (pq.length - 1));
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        if (N <= (pq.length - 1) / 4)
            resize((pq.length - 1) / 2);
        Key max = pq[1];
        exch(1, N);
        pq[N--] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            j = (j < N && less(j, j + 1)) ? (j + 1) : j;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(pq);
    }
}
