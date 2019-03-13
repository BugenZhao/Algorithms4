package com.bugenzhao.algorithms4.exercise.chapter2_1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Deque;
import java.util.LinkedList;

public class Ex14 {
    static void show(Deque deque) {
        for (Object d :
                deque) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    static <Item extends Comparable> void sort(Deque<Item> deque) {
        int N = deque.size();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                show(deque);
                Item a = deque.pop();
                Item b = deque.pop();
                if (a.compareTo(b) < 0) {
                    deque.addFirst(b);
                    deque.addLast(a);
                } else {
                    deque.addFirst(a);
                    deque.addLast(b);
                }
            }
            show(deque);
            deque.addLast(deque.pop());
        }

    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            deque.addLast(StdRandom.uniform(0, 20));
        }
        sort(deque);
        for (Integer d :
                deque) {
            System.out.print(d + " ");
        }
    }
}
