package com.bugenzhao.algorithms4.exercise.chapter4_2;

abstract public class SCC {
    public SCC() {
    }

    public SCC(Digraph G) {
    }

    abstract public boolean stronglyConnected(int v, int w);

    abstract int count();

    abstract int id(int v);
}
