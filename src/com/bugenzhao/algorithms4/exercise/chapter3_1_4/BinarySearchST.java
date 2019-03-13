package com.bugenzhao.algorithms4.exercise.chapter3_1_4;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Val> extends ST<Key, Val> {
    private Key[] keys;
    private Val[] vals;
    private int N;

    BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Val[]) new Object[capacity];
    }

    @Override
    public void put(Key key, Val val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        ++N;
    }

    @Override
    public Val get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }

    public int rank(Key key) {
        return rank(key, 0, N - 1);
    }

    private int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0)
            return rank(key, lo, mid - 1);
        else if (cmp > 0)
            return rank(key, mid + 1, hi);
        else
            return mid;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void delete(Key key) {
        if (key == null) return;
        if (isEmpty()) return;

        int i = rank(key);
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        N--;

        keys[N] = null;  // to avoid loitering
        vals[N] = null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<>();
        for (int i = 0; i < N; i++) {
            q.enqueue(keys[i]);
        }
        return q;
    }
}
