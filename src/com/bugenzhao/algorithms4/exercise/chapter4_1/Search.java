package com.bugenzhao.algorithms4.exercise.chapter4_1;

abstract public class Search {
    public Search(Graph G, int s) {
    }

    abstract public boolean marked(int v);

    abstract public int count();
}
