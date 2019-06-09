package com.bugenzhao.algorithms4.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node fore_first; // YES!!!
    private Node last;
    private int N;

    public Queue() {
        last = new Node();
        fore_first = last;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        StdOut.println(queue.isEmpty());
        for (int i = 0; i < StdRandom.uniform(5, 10); ++i) {
            int item = StdRandom.uniform(10);
            queue.enqueue(item);
            StdOut.print(item + " ");
        }
        StdOut.println("\n" + queue.size());
        while (!queue.isEmpty())
            StdOut.print(queue.dequeue() + " ");
        StdOut.println(queue.isEmpty());
    }

    public boolean isEmpty() {
        return fore_first.next == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node old_last = last;
        last = new Node();
        last.item = item;
        last.next = null;
        old_last.next = last;
        ++N;
    }

    public Item dequeue() {
        Item item = fore_first.next.item;
        fore_first = fore_first.next;
        --N;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node p = fore_first;

            @Override
            public boolean hasNext() {
                return p.next == null;
            }

            @Override
            public Item next() {
                Item item = p.item;
                p = p.next;
                return item;
            }
        };
    }

    private class Node {
        Item item;
        Node next;
    }
}
