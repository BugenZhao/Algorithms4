package com.bugenzhao.algorithms4.exercise.chapter3_5;

import edu.princeton.cs.algs4.StdIn;

import java.util.HashMap;

public class LRUCache<Key, Val> {
    private HashMap<Key, Node> map;
    private int count;
    private Node head;
    private Node tail;


    public LRUCache() {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.priv = head;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>();
        while (true) {
            String cmd = StdIn.readString();
            if (cmd.equals("p"))
                cache.put(StdIn.readString(), StdIn.readInt());
            else if (cmd.equals("g"))
                System.out.println(cache.get(StdIn.readString()));
            else if (cmd.equals("d"))
                System.out.println(cache.delete());
            else
                System.err.println("NOPE!");
            System.out.println(cache);
        }
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public Val get(Key key) {
        Node node = map.get(key);
        if (node == null)
            return null;
        if (node == head.next) {
            return node.val;
        }
        Node a = node.priv;
        Node b = node.next;
        a.next = b;
        b.priv = a;
        put(key, node.val);
        --count;
        return node.val;
    }

    public void put(Key key, Val val) {
        Node node = new Node(key, val);
        Node temp = head.next;
        node.priv = head;
        head.next = node;
        node.next = temp;
        temp.priv = node;
        map.put(key, node);
        ++count;
    }

    public Val delete() {
        if (count == 0)
            return null;
        Node node = tail.priv;
        Node temp = node.priv;
        temp.next = tail;
        tail.priv = temp;
        map.remove(node.key);
        --count;
        return node.val;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        Node a = head.next;
        while (a != tail) {
            sb.append(a.key);
            sb.append(": ");
            sb.append(a.val);
            sb.append(", ");
            a = a.next;
        }
        return sb.toString();
    }

    class Node {
        Key key;
        Val val;
        Node next;
        Node priv;

        Node(Key key, Val val) {
            this.key = key;
            this.val = val;
        }

        Node() {
        }
    }
}
