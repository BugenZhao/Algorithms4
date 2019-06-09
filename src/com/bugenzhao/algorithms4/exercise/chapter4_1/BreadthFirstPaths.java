package com.bugenzhao.algorithms4.exercise.chapter4_1;

import com.bugenzhao.algorithms4.exercise.chapter1_3.Queue;
import com.bugenzhao.algorithms4.exercise.chapter1_3.Stack;

public class BreadthFirstPaths extends Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPaths(Graph G, int s) {
        super(G, s);
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                edgeTo[w] = v;
                marked[w] = true;
                queue.enqueue(w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
