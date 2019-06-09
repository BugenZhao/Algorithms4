package com.bugenzhao.algorithms4.exercise.chapter4_1;

abstract public class Paths {
    public Paths(Graph G, int s) {
    }

    abstract public boolean hasPathTo(int v);

    abstract Iterable<Integer> pathTo(int v);
}
