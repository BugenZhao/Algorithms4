package com.bugenzhao.algorithms4.exercise.chapter3_5;

//import edu.princeton.cs.algs4.BST;

import com.bugenzhao.algorithms4.exercise.chapter3_1_4.BST;

public class PartitionSearch {
    private static boolean START = false;
    private static boolean END = true;
    private BST<Integer, Boolean> bst;

    public PartitionSearch() {
        bst = new BST<>();
    }

    public static void main(String[] args) {
        PartitionSearch ps = new PartitionSearch();
        ps.addPartition(1643, 2033);
        ps.addPartition(5532, 7643);
        ps.addPartition(8999, 10332);
        System.out.println(ps.find(9122));
        System.out.println(ps.find(8122));
    }

    public void addPartition(int begin, int end) {
        if (begin >= end) return;
        bst.put(begin, START);
        bst.put(end, END);
    }

    public int find(int num) {
        int floor = bst.floor(num);
        boolean flag = bst.get(floor);
        if (flag == END)
            return -1;
        else
            return bst.rank(floor) / 2 + 1;
    }
}
