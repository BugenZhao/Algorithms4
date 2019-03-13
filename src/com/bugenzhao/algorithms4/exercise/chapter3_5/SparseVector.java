package com.bugenzhao.algorithms4.exercise.chapter3_5;

import com.bugenzhao.algorithms4.exercise.chapter3_1_4.ST;
import com.bugenzhao.algorithms4.exercise.chapter3_1_4.SeparateChainingHashST;

public class SparseVector {
    private ST<Integer, Double> st;

    public SparseVector() {
        st = new SeparateChainingHashST<>();
    }

    public SparseVector(double[] a) {
        st = new SeparateChainingHashST<>();
        for (int i = 0; i < a.length; i++) {
            put(i, a[i]);
        }
    }

    public static void main(String[] args) {
        double a[] = {0.0, 0.0, .36, .36, .18};
        double x[] = {.05, .04, .36, .37, .19};
        System.out.println(new SparseVector(a).dot(x));

        double b[] = {.11, 0.0, -.36, .36, -.18};
        System.out.println(new SparseVector(a).sum(new SparseVector(b)));
    }


    public void put(int i, double x) {
        if (x > 1e-9 || x < -1e-9)
            st.put(i, x);
        else
            st.delete(i);
    }

    public double get(int i) {
        if (st.contains(i))
            return st.get(i);
        else
            return 0.0;
    }

    public double dot(double[] that) {
        double ans = 0.0;
        for (int i : st.keys())
            ans += that[i] * st.get(i);
        return ans;
    }

    public SparseVector sum(SparseVector that) {
        SET<Integer> keys = new HashSET<>();
        for (int i : st.keys()) {
            keys.add(i);
        }
        for (int i : that.st.keys()) {
            keys.add(i);
        }
        SparseVector ans = new SparseVector();
        for (int i : keys.keys()) {
            ans.put(i, this.get(i) + that.get(i));
        }
        return ans;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        st.keys().forEach(x -> sb.append(x + ": " + st.get(x) + "\n"));
        return sb.toString();
    }
}
