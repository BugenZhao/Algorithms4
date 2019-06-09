package com.bugenzhao.algorithms4.exercise.chapter4_2;


public class DirectedDFS extends DiSearch {
    private boolean[] marked;
    private int count;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (Integer s : sources) {
            dfs(G, s);
        }
    }

    private void dfs(Digraph G, int v) {
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
