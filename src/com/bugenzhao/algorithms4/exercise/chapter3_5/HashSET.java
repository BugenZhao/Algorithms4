package com.bugenzhao.algorithms4.exercise.chapter3_5;

import com.bugenzhao.algorithms4.exercise.chapter3_1_4.LinearProbingHashST;

public class HashSET<Key> extends SET<Key> {

    private LinearProbingHashST<Key, Boolean> st;

    public HashSET() {
        st = new LinearProbingHashST<>();
    }

    @Override
    public void add(Key key) {
        st.put(key, true);
    }

    @Override
    public void delete(Key key) {
        st.delete(key);
    }

    @Override
    public boolean contains(Key key) {
        return st.contains(key);
    }

    @Override
    public int size() {
        return st.size();
    }

    @Override
    public Iterable<Key> keys() {
        return st.keys();
    }
}
