package com.bugenzhao.algorithms4.exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

public class Ex09 {

    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    public static void main(String[] args) {
        Stack<String> data = new Stack<>();
        Stack<String> oper = new Stack<>();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (isOperator(str)) {
                oper.push(str);
            } else if (str.equals(")")) {
                String str1 = data.pop();
                String str2 = data.pop();
                data.push("( " + str2 + " " + oper.pop() + " " + str1 + " )");
            } else {
                data.push(str);
            }
        }
        while (!oper.isEmpty()) {
            String str1 = data.pop();
            String str2 = data.pop();
            data.push("( " + str2 + oper.pop() + str1 + " )");
        }
        System.out.println(data.pop());
    }
}
