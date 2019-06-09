package com.bugenzhao.algorithms4.exercise.chapter4_2;

public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public static void main(String[] args) {
        String filename = "data/jobs.txt";
        String sep = "/";
        SymbolDiGraph symbolDiGraph = new SymbolDiGraph(filename, sep);
        Topological topological = new Topological(symbolDiGraph.G());

        for (int v : topological.order()) {
            System.out.println(symbolDiGraph.name(v));
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
