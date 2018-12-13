package com.bugenzhao.algorithms4.Exercise.Chapter1_3;

import edu.princeton.cs.algs4.StdIn;

public class Ex15 {
    public static void main(String[] args) {
        int k = 3;
        if (args.length == 1)
            k = Integer.parseInt(args[0]);
        Queue<String> queue = new Queue<>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
            if (queue.size() == k + 1)
                queue.dequeue();
        }
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
    }
}
