package com.bugenzhao.algorithms4.exercise.chapter3_1_4;

import edu.princeton.cs.algs4.SequentialSearchST;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SeparateChainingHashST<Key, Val> extends ST<Key, Val> {
    private int N; // number of keys
    private int M; // size of the HashTable
    private SequentialSearchST<Key, Val>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Val>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public Val get(Key key) {
        return st[hash(key)].get(key);
    }

    @Override
    public void put(Key key, Val val) {
        st[hash(key)].put(key, val);
        ++N;
    }

    @Override
    public void delete(Key key) {
        if (!contains(key)) return;
        st[hash(key)].delete(key);
        N--;
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
                    st[i].keys().forEach(queue::offer);
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
