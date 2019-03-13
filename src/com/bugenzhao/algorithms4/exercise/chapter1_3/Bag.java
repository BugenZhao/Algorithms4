package com.bugenzhao.algorithms4.exercise.chapter1_3;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Bag<Item> implements Iterable<Item> { // iterator implementation
    private class Node {
        Item item;
        Node next;
    }

    private Node first;

    public void add(Item item) {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
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

    public static void main(String[] args) {
        Bag<Boolean> bag = new Bag<Boolean>();
        for (int i = 0; i < StdRandom.uniform(5, 10); ++i)
            bag.add(StdRandom.bernoulli());
        for (boolean num : bag)
            StdOut.println(num);
    }
}
