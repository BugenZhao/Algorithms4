package com.bugenzhao.algorithms4.exercise.chapter3_5;

import edu.princeton.cs.algs4.StdIn;

import java.util.HashMap;

public class UniQueue<Item> {
    private int current = 0;
    private int currentMax = 0;
    private HashMap<Integer, Item> map;

    public UniQueue() {
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        UniQueue<String> queue = new UniQueue<>();
        while (true) {
            String cmd = StdIn.readString();
            if (cmd.equals("e"))
                queue.enqueue(StdIn.readString());
            else if (cmd.equals("d"))
                System.out.println(queue.dequeue());
            else
                System.err.println("NOPE!");
        }
    }

    public void enqueue(Item item) {
        if (map.containsValue(item))
            return;
        map.put(currentMax++, item);
    }

    public Item dequeue() {
        return map.remove(current++);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
