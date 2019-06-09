package com.bugenzhao.algorithms4.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> { // iterator implementation
    private Node first;
    private int n;

    public Bag() {
        n = 0;
    }

    public static void main(String[] args) {
        Bag<Boolean> bag = new Bag<>();
        for (int i = 0; i < StdRandom.uniform(5, 10); ++i)
            bag.add(StdRandom.bernoulli());
        for (boolean num : bag)
            StdOut.println(num);
    }

    public void add(Item item) {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
        ++n;
    }

    public boolean contains(Item item) {
        Node p = first;
        boolean flag = false;
        while (p != null && !flag) {
            if (p.item.equals(item))
                flag = true;
            else
                p = p.next;
        }
        return flag;
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
