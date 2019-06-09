package com.bugenzhao.algorithms4.exercise.chapter4_2;

public class TarjanSCC extends SCC {
    @Override
    public boolean stronglyConnected(int v, int w) {
        return false;
    }

    @Override
    int count() {
        return 0;
    }

    @Override
    int id(int v) {
        return 0;
    }
}
