package com.bugenzhao.algorithms4.exercise.chapter3_1_4;

abstract public class ST<Key, Val> {
    ST() {
    }

    abstract public Iterable<Key> keys();

    abstract public void put(Key key, Val val);

    abstract public Val get(Key key);

    abstract public void delete(Key key);

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    abstract public int size();
}
