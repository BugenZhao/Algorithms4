package com.bugenzhao.algorithms4.exercise.chapter1_5;

public class QuickUnionUF extends UF {
    public QuickUnionUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    @Override
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        --count;
    }
}
