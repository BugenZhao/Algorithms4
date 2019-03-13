package com.bugenzhao.algorithms4.exercise.chapter1_3;

import java.util.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate { // Dijkstra's two-stack algorithm for expression evalution

    public static void calc(Stack<String> ops, Stack<Double> vals) {
        String op = ops.pop();
        double a = vals.pop();
        if (op.equals("+"))
            a = a + vals.pop();
        else if (op.equals("-"))
            a = a - vals.pop();
        else if (op.equals("*"))
            a = a * vals.pop();
        else if (op.equals("/"))
            a = a / vals.pop();
        else if (op.equals("sqrt"))
            a = Math.sqrt(a);
        vals.push(a);
    }

    public static void main(String[] args) { // need a sep ' '
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        final String opstrs = "+-*/sqrt";
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (opstrs.indexOf(s) != -1)
                ops.push(s);
            else if (s.equals("("))
                ;
            else if (s.equals(")"))
                calc(ops, vals);
            else
                vals.push(Double.parseDouble(s));
        }
        while (!ops.empty()) // fix the issue if exp does not end with a ')'
            calc(ops, vals);
        StdOut.println(vals.pop());
    }
}
