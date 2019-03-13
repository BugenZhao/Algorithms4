package com.bugenzhao.algorithms4.exercise.chapter1_5;

public class WeightedQuickUnionPathCompressionUF extends WeightedQuickUnionUF {
    public WeightedQuickUnionPathCompressionUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        int root = p;
        while (root != id[root])
            root = id[root];
        while (p != root) {
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }

}
