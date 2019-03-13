package com.bugenzhao.algorithms4.exercise.chapter3_1_4;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Val> extends ST<Key, Val> {
    private Node root;

    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        for (Character ch : "seacrhmlpx".toCharArray())
            bst.put(ch.toString(), 0);
        bst.draw();
        System.out.println(bst.floor("b"));
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void put(Key key, Val val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Val val) {
        if (node == null)
            return new Node(key, val, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Val get(Key key) {
        return get(root, key);
    }

    public Val get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);

        if (cmp == 0)
            return node.val;
        else if (cmp < 0)
            return get(node.left, key);
        else
            return get(node.right, key);
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    public Node select(Node node, int k) {
        if (node == null) return null;
        int lsz = size(node.left);
        if (lsz > k)
            return select(node.left, k);
        else if (lsz < k)
            return select(node.right, k - lsz - 1);
        else
            return node;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    public int rank(Node node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(node.left, key);
        else if (cmp > 0)
            return 1 + size(node.left) + rank(node.right, key);
        else
            return size(node.left);
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node == null) return null;
        if (node.left == null) return node;
        else return min(node.left);
    }

    public Key floor(Key key) {
        return floor(root, key);
    }

    public Key floor(Node node, Key key) {
        if (key.compareTo(node.key) < 0) {
            if (node.left == null) return key;
            return floor(node.left, key);
        } else if (key.compareTo(node.key) == 0)
            return key;
        else {
            if (node.right == null) return key;
            if (key.compareTo(node.right.key) > 0)
                return floor(node.right, key);
            else
                return node.key;
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.right == null)
                return node.left;
            if (node.left == null)
                return node.right;

            Node tmp = node;
            node = min(tmp.right);
            // 顺序不能错！
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Node> aux = new Queue<>();
        Queue<Key> ret = new Queue<>();
        aux.enqueue(root);
        while (!aux.isEmpty()) {
            Node node = aux.dequeue();
            ret.enqueue(node.key);
            if (node.left != null)
                aux.enqueue(node.left);
            if (node.right != null)
                aux.enqueue(node.right);
        }
        return ret;
    }

    @Override
    public String toString() {
        return keys().toString();
    }

    public void draw() {
        Queue<Node> aux = new Queue<>();
        Queue<Node> ret = new Queue<>();
        aux.enqueue(root);

        int count = 0;
        while (true) {
            ++count;
            Node node = aux.dequeue();
            if (node == null) {
                ret.enqueue(null);
                aux.enqueue(null);
                aux.enqueue(null);
            } else {
                ret.enqueue(node);
                aux.enqueue(node.left);
                aux.enqueue(node.right);
            }
            if ((count & (count + 1)) == 0) {
                boolean ok = true;
                for (Node node1 : aux) {
                    if (node1 != null) {
                        ok = false;
                        break;
                    }
                }
                if (ok) break;
            }
        }

        int level = 1;
        Node tmp;
        while (!ret.isEmpty()) {
            for (int i = 0; i < level; i++) {
                tmp = ret.dequeue();
                System.out.print(tmp == null ? "! " : (tmp.key + " "));
            }
            System.out.println();
            level *= 2;
        }
    }

    private class Node {
        private Key key;
        private Val val;
        private Node left;
        private Node right;
        private int N;

        Node(Key key, Val val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
}

