package com.bugenzhao.algorithms4.exercise.chapter4_2;


abstract public class DiSearch {
    public DiSearch(Digraph G, int s) {
    }

    DiSearch() {}

    abstract public boolean marked(int v);

    abstract public int count();
}
