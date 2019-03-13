package com.bugenzhao.algorithms4.exercise.chapter1_5;

abstract public class UF {
    protected int[] id;
    protected int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    abstract public int find(int p);

    abstract void union(int p, int q);
}
