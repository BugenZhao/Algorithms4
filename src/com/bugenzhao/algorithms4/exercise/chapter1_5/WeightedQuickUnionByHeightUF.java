package com.bugenzhao.algorithms4.exercise.chapter1_5;

public class WeightedQuickUnionByHeightUF extends QuickUnionUF {
    protected int[] height;

    public WeightedQuickUnionByHeightUF(int N) {
        super(N);
        height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = 0;
        }
    }

    @Override
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (height[pRoot] < height[qRoot])
            id[pRoot] = qRoot;
        else if (height[pRoot] > height[qRoot])
            id[qRoot] = pRoot;
        else {
            id[pRoot] = qRoot;
            ++height[qRoot];
        }
        --count;
    }
}
