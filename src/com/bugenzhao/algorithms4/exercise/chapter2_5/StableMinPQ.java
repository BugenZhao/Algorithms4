package com.bugenzhao.algorithms4.exercise.chapter2_5;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

class Tuple implements Comparable<Tuple> {
    String string;
    int no;

    Tuple(String string, int no) {
        this.string = string;
        this.no = no;
    }

    @Override
    public String toString() {
        return "(" + string + ", " + no + ")";
    }

    @Override
    public int compareTo(Tuple o) {
        return this.string.compareTo(o.string);
    }
}

public class StableMinPQ<Key extends Comparable<Key>> {
    private int count;
    private MinPQ<StableKey> pq;

    public StableMinPQ() {
        count = 0;
        pq = new MinPQ<>();
    }

    public static void main(String[] args) {
        StableMinPQ<Tuple> pq = new StableMinPQ<>();

        // insert a bunch of strings
        String text = "it was the best of times it was the worst of times it was the "
                + "age of wisdom it was the age of foolishness it was the epoch "
                + "belief it was the epoch of incredulity it was the season of light "
                + "it was the season of darkness it was the spring of hope it was the "
                + "winter of despair";
        String[] strings = text.split(" ");
        for (int i = 0; i < strings.length; i++) {
            pq.insert(new Tuple(strings[i], i));
        }


        // delete and print each key
        while (!pq.isEmpty()) {
            StdOut.println(pq.delMin());
        }
        StdOut.println();

    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }

    public int size() {
        return pq.size();
    }

    public Key min() {
        return pq.min().key;
    }

    public void insert(Key x) {
        pq.insert(new StableKey(x));
    }

    public Key delMin() {
        return pq.delMin().key;
    }

    private class StableKey implements Comparable<StableKey> {
        int no;
        Key key;

        public StableKey(Key key) {
            this.key = key;
            no = count++;
        }

        @Override
        public int compareTo(StableKey o) {
            int ret = this.key.compareTo(o.key);
            if (ret == 0)
                ret = this.no < o.no ? -1 : +1;
            return ret;
        }
    }
}
