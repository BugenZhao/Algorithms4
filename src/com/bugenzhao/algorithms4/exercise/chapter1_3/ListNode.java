package com.bugenzhao.algorithms4.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ListNode<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node foreFirst;
    private Node last;
    private int N;

    public ListNode() {
        last = new Node();
        foreFirst = last;
    }

    public boolean isEmpty() {
        return foreFirst.next == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        oldLast.next = last;
        ++N;
    }


    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = foreFirst.next;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        ListNode<String> ln = new ListNode<>();
        for (int i = 0; i < 5; ++i)
            ln.push(StdIn.readString());
        for (String str : ln)
            StdOut.println(str);
    }
}
