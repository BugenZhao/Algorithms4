package com.bugenzhao.algorithms4.exercise.chapter4_2;

import com.bugenzhao.algorithms4.exercise.chapter1_3.Bag;
import com.bugenzhao.algorithms4.exercise.chapter1_3.Stack;
import edu.princeton.cs.algs4.In;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Bag();
        }
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public static int degree(Digraph G, int v) {
        return G.adj[v].size();
    }

    public static int maxDegree(Digraph G) {
        int max = 0;
        for (int i = 0; i < G.V(); i++) {
            max = Math.max(max, degree(G, i));
        }
        return max;
    }

    public static double avgDegree(Digraph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Digraph G) {
        int count = 0;
        for (int i = 0; i < G.V(); i++) {
            for (int j : G.adj(i)) {
                if (i == j)
                    ++count;
            }
        }
        return count / 2;
    }

    public static void main(String[] args) {
        Digraph graph = new Digraph(new In("data/tinyG.txt"));
        System.out.println(graph);
        Digraph newGraph = (Digraph) graph.clone();
        System.out.println(newGraph);
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        ++E;
    }

    public boolean hasEdge(int v, int w) {
        return adj[v].contains(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges\n");
        for (int i = 0; i < V; i++) {
            sb.append(i + ": ");
            for (int j : adj(i)) {
                sb.append(j + " ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v))
                R.addEdge(w, v);
        }
        return R;
    }

    @Override
    protected Object clone() {
        Digraph newG = new Digraph(V());
        newG.E = E();
        Stack<Integer> reverse = new Stack<>();
        for (int v = 0; v < V(); v++) {
            for (Integer key : adj[v]) {
                reverse.push(key);
            }
            while (!reverse.isEmpty()) {
                newG.adj[v].add(reverse.pop());
            }
        }
        return newG;
    }
}
