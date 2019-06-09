package com.bugenzhao.algorithms4.exercise.chapter4_2;


import com.bugenzhao.algorithms4.exercise.chapter1_3.Queue;
import com.bugenzhao.algorithms4.exercise.chapter1_3.Stack;

public class DepthFirstOrder extends DiSearch {
    private boolean[] marked;
    private int count;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v) {
        pre.enqueue(v);

        marked[v] = true;
        ++count;
        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }

        post.enqueue(v);
        reversePost.push(v);
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
