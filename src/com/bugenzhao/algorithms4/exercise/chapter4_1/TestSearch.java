package com.bugenzhao.algorithms4.exercise.chapter4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class TestSearch {
    public static void main(String[] args) throws Exception {
        Graph G = new Graph(new In("data/tinyG.txt"));
        int s = StdIn.readInt();
        Class<? extends Search>[] classes =
                new Class[]{DepthFirstSearch.class, UnionFindSearch.class};
        Search search;
        for (Class<? extends Search> aClass : classes) {
            search = aClass.getConstructor(Graph.class, int.class).newInstance(G, s);
            for (int v = 0; v < G.V(); v++) {
                if (search.marked(v))
                    System.out.print(v + " ");
            }
            System.out.println();
            if (search.count() != G.V())
                System.out.print("NOT ");
            System.out.println("connected");
        }
    }
}
