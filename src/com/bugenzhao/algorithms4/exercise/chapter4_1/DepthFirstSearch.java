package com.bugenzhao.algorithms4.exercise.chapter4_1;

public class DepthFirstSearch extends Search {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {
        super(G, s);
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        ++count;
        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }
}
