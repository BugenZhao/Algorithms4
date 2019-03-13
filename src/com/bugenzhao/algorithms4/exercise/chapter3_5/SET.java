package com.bugenzhao.algorithms4.exercise.chapter3_5;

abstract public class SET<Key> {
    abstract public Iterable<Key> keys();

    SET() {
    }

    abstract public void add(Key key);

    abstract public void delete(Key key);

    abstract public boolean contains(Key key);

    abstract public int size();

    public boolean isEmpty() {
        return size() == 0;
    }
}
