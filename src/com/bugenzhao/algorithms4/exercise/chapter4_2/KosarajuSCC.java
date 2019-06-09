package com.bugenzhao.algorithms4.exercise.chapter4_2;

public class KosarajuSCC extends SCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G);
        for (int v : order.reversePost()) {
            if (!marked[v]) {
                dfs(G, v);
                ++count;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }

    @Override
    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    @Override
    int count() {
        return count;
    }

    @Override
    int id(int v) {
        return id[v];
    }
}
