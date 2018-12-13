package com.bugenzhao.algorithms4.Exercise.Chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Stack<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int N;

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
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        --N;
        return item;
    }

    public Item peek() {
        return first.item;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= StdRandom.uniform(10, 20); ++i)
            stack.push(StdRandom.uniform(100));
        StdOut.println(stack.size());
        StdOut.println(stack.peek());
        while (!stack.isEmpty())
            StdOut.print(stack.pop() + " ");
    }
}
