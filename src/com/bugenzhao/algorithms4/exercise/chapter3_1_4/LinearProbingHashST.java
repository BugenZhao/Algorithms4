package com.bugenzhao.algorithms4.exercise.chapter3_1_4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LinearProbingHashST<Key, Val> extends ST<Key, Val> {
    private int N; // number of keys
    private int M; // size of the HashTable
    private Key[] keys;
    private Val[] vals;

    public LinearProbingHashST() {
        this(997);
    }

    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        vals = (Val[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public Val get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key))
                return vals[i];
        }
        return null;
    }

    @Override
    public void put(Key key, Val val) {
        if (N >= M / 2)
            resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        ++N;
    }

    @Override
    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key tmpKey = keys[i];
            Val tmpVal = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(tmpKey, tmpVal);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N <= M / 8)
            resize(M / 2);
    }

    private void resize(int newM) {
        LinearProbingHashST<Key, Val> newST = new LinearProbingHashST<>(newM);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                newST.put(keys[i], vals[i]);
        }
        keys = newST.keys;
        vals = newST.vals;
        M = newST.M;
    }


    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                Queue<Key> queue = new LinkedList<>();
                for (int i = 0; i < M; i++) {
                    for (Key key :
                            keys) {
                        if (key != null)
                            queue.offer(key);
                    }
                }
                return new Iterator<Key>() {
                    @Override
                    public boolean hasNext() {
                        return !queue.isEmpty();
                    }

                    @Override
                    public Key next() {
                        return queue.remove();
                    }
                };
            }
        };
    }
}
