package com.bugenzhao.algorithms4.exercise.chapter3_5;

import com.bugenzhao.algorithms4.exercise.chapter3_1_4.ST;
import com.bugenzhao.algorithms4.exercise.chapter3_1_4.SeparateChainingHashST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

public class LookupIndex<Key, Val> {
    private ST<Key, Queue<Val>> st;
    private ST<Val, Queue<Key>> ts;

    public LookupIndex() {
        st = new SeparateChainingHashST<>();
        ts = new SeparateChainingHashST<>();
    }

    public static void main(String[] args) {
        In fin = new In("data/aminoI.txt");
        String sep = ",";
        LookupIndex<String, String> table = new LookupIndex<>();
        while (!fin.isEmpty()) {
            String[] a = fin.readLine().split(sep);
            String key = a[0];
            for (int i = 1; i < a.length; i++) {
                table.put(key, a[i]);
            }
        }
        while (!StdIn.isEmpty()) {
            String query = StdIn.readLine();
            System.out.println(query + ":");

            Queue<String> vals = table.getValues(query);
            Queue<String> keys = table.getKeys(query);

            if (vals != null) {
                for (String val : vals)
                    System.out.println(" " + val);
            }
            if (keys != null) {
                for (String key : keys)
                    System.out.println(" " + key);
            }
            System.out.println();
        }
    }

    public void put(Key key, Val val) {
        if (!st.contains(key))
            st.put(key, new Queue<>());
        if (!ts.contains(val))
            ts.put(val, new Queue<>());
        st.get(key).enqueue(val);
        ts.get(val).enqueue(key);
    }

    public Queue<Val> getValues(Key key) {
        return st.get(key);
    }

    public Queue<Key> getKeys(Val val) {
        return ts.get(val);
    }
}
