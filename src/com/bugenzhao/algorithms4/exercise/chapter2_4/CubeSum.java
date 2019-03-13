package com.bugenzhao.algorithms4.exercise.chapter2_4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;

    public CubeSum(int i, int j) {
        this.i = i;
        this.j = j;
        this.sum = i * i * i + j * j * j;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        MinPQ<CubeSum> pq = new MinPQ<>();
        Map<Integer, List<CubeSum>> map = new TreeMap<>();
        for (int i = 0; i <= N; i++) {
            pq.insert(new CubeSum(i, 0));
        }
        while (!pq.isEmpty()) {
            CubeSum tmp = pq.delMin();
            if (!map.containsKey(tmp.sum)) {
                map.put(tmp.sum, new ArrayList<CubeSum>());
            }
            map.get(tmp.sum).add(tmp);
            if (tmp.j < N)
                pq.insert(new CubeSum(tmp.i, tmp.j + 1));
        }
        map.forEach((key, value) -> {
            System.out.println(key + " :");
            value.forEach(System.out::println);
        });
    }

    @Override
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }

    @Override
    public int compareTo(CubeSum that) {
        return this.sum > that.sum ? +1 : this.sum < that.sum ? -1 : 0;
    }
}
