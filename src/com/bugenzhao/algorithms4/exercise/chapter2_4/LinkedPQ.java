package com.bugenzhao.algorithms4.exercise.chapter2_4;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedPQ<Key extends Comparable<Key>> {

    private Node root;
    private Node lastInserted;

    public static void main(String[] args) {
        Integer integer;
        LinkedPQ<Integer> maxPQ = new LinkedPQ<>();
        while (true) {
            integer = StdIn.readInt();
            if (integer == 0) maxPQ.delMax();
            else maxPQ.insert(integer);
            System.out.println(maxPQ);
        }
    }

    //返回以 node 为父节点的树的大小（含）
    private int size(Node node) {
        if (node == null)
            return 0;
        else return node.N;
    }

    private void swim(Node x) {
        if (x == null) return;
        if (x.parent == null) return;
        if (less(x.parent, x)) {
            exchData(x, x.parent);
            swim(x.parent);
        }
    }

    private void sink(Node x) {
        if (x == null) return;
        if (x.left == null && x.right == null) {
            return;
        } else if (x.left == null) {
            if (less(x, x.right))
                exchData(x, x.right);
        } else if (x.right == null) {
            if (less(x, x.left))
                exchData(x, x.left);
        } else {
            Node tmp = (less(x.left, x.right)) ? x.right : x.left;
            if (less(x, tmp)) {
                exchData(tmp, x);
                sink(tmp);
            }
        }
    }

    //从 x 节点开始向下查找应该插入的位置，返回更新过的 x（往往不会变化）
    private Node insert(Node x, Key data) {
        if (x == null) {
            lastInserted = new Node(data, 1);
            return lastInserted;
        }

        int leftSize = size(x.left);
        int rightSize = size(x.right);
        if (leftSize <= rightSize) {
            Node inserted = insert(x.left, data);
            x.left = inserted;
            inserted.parent = x;
        } else {
            Node inserted = insert(x.right, data);
            x.right = inserted;
            inserted.parent = x;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node resetLastInserted(Node x) {
        if (x == null) return null;
        if (x.left == null && x.right == null) return x;

        if (size(x.right) < size(x.left))
            return resetLastInserted(x.left);
        else
            return resetLastInserted(x.right);
    }

    public boolean isEmpty() {
        return size(root) == 0;
    }

    public int size() {
        return size(root);
    }

    public void insert(Key v) {
        root = insert(root, v);
        swim(lastInserted);
    }

    public Key max() {
        if (root == null)
            return null;
        else
            return root.data;
    }

    public Key delMax() {
        if (size() == 1) {
            Key ret = root.data;
            root = null;
            return ret;
        }

        Key ret = root.data;
        exchData(root, lastInserted);
        Node lastInsParent = lastInserted.parent;
        if (lastInsParent.left == lastInserted) {
            lastInsParent.left = null;
        } else {
            lastInsParent.right = null;
        }

        Node tmp = lastInserted;
        while (tmp != null) {
            --tmp.N;
            tmp = tmp.parent;
        }

        lastInserted = resetLastInserted(root);
        sink(root);
        return ret;
    }

    private boolean less(Node i, Node j) {
        return i.data.compareTo(j.data) < 0;
    }

    private void exchData(Node i, Node j) {
        Key t = i.data;
        i.data = j.data;
        j.data = t;
    }

    @Override
    public String toString() {
        if (root == null)
            return "null";
        ArrayList<String> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            list.add(node.data.toString());
        }
        return list.toString();
    }

    private class Node {
        int N;
        Key data;
        Node parent, left, right;

        public Node(Key data, int N) {
            this.data = data;
            this.N = N;
        }
    }
}
