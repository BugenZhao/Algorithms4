package com.bugenzhao.algorithms4.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int N;

    private int cnt_pop;
    private int cnt_push;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node old_first = first;
        first = new Node();
        first.item = item;
        first.next = old_first;
        ++N;
        ++cnt_push;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        --N;
        ++cnt_pop;
        return item;
    }

    public Item peek() {
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        private final int src_cnt_pop = cnt_pop;
        private final int src_cnt_push = cnt_push;

        public boolean hasNext() {
            if (cnt_pop != src_cnt_pop || cnt_push != src_cnt_push)
                throw new ConcurrentModificationException("");
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            if (cnt_pop != src_cnt_pop || cnt_push != src_cnt_push)
                throw new ConcurrentModificationException("");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= StdRandom.uniform(10, 20); ++i)
            stack.push(StdRandom.uniform(100));
        StdOut.println(stack.size());
        StdOut.println(stack.peek());
        for (Integer x : stack) {
            StdOut.print(x + " ");
            if (StdRandom.bernoulli(0.1))
                stack.pop();
        }
    }
}
