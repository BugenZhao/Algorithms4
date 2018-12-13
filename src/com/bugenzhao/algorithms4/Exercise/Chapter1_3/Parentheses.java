package com.bugenzhao.algorithms4.Exercise.Chapter1_3;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdIn;

public class Parentheses {
    public static void main(String[] args) {
        Map<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack();
        boolean ans = true;
        while (!StdIn.isEmpty() && ans) {
            char ch = StdIn.readChar();
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            char pair = map.get(stack.pop());
            if (pair != ch)
                ans = false;
        }
        if (!stack.isEmpty())
            ans = false;
        System.out.println(ans);

    }
}
