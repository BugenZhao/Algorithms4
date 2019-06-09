package com.bugenzhao.algorithms4.exercise.chapter4_2;

import com.bugenzhao.algorithms4.exercise.chapter3_1_4.ST;
import com.bugenzhao.algorithms4.exercise.chapter3_1_4.SeparateChainingHashST;
import com.bugenzhao.algorithms4.exercise.chapter4_1.Graph;
import edu.princeton.cs.algs4.In;

public class SymbolDiGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Digraph G;

    public SymbolDiGraph(String filename, String sp) {
        st = new SeparateChainingHashST<>();
        In in = new In(filename);
        while (!in.isEmpty()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }
        keys = new String[st.size()];
        st.keys().forEach(name -> keys[st.get(name)] = name);
        G = new Digraph(st.size());
        in = new In(filename);
        while (!in.isEmpty()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Digraph G() {
        return G;
    }
}
