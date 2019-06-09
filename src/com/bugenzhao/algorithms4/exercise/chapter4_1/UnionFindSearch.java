package com.bugenzhao.algorithms4.exercise.chapter4_1;

import com.bugenzhao.algorithms4.exercise.chapter1_5.UF;
import com.bugenzhao.algorithms4.exercise.chapter1_5.WeightedQuickUnionUF;

public class UnionFindSearch extends Search {
    private int count;
    private UF uf;
    private int s;

    public UnionFindSearch(Graph G, int s) {
        super(G, s);
        this.s = s;
        uf = new WeightedQuickUnionUF(G.V());
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (!uf.connected(w, v)) {
                    uf.union(w, v);
                    ++count;
                }
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return uf.connected(s, v);
    }

    @Override
    public int count() {
        return count;
    }
}
