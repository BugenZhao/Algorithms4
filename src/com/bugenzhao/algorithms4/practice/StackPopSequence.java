package com.bugenzhao.algorithms4.practice;

import edu.princeton.cs.algs4.Stack;

import java.util.Scanner;

class MyStack extends Stack<Integer> {
    @Override
    public Integer peek() {
        if (isEmpty())
            return -1;
        else
            return super.peek();
    }
}

public class StackPopSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        body:
        while (true) {
            scanner = new Scanner(System.in);
            MyStack stack = new MyStack();
            int count = 0;
            for (int i = 0; i < N; i++) {
                int num = scanner.nextInt();
                while (stack.peek() < num) {
                    stack.push(++count);
                }
                if (stack.peek() == num) {
                    stack.pop();
                } else {
                    System.out.println("NOPE.");
                    continue body;
                }
            }
            System.out.println("YEP.");
        }
    }

}
