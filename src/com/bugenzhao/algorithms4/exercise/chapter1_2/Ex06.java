package com.bugenzhao.algorithms4.exercise.chapter1_2;

import edu.princeton.cs.algs4.*;

public class Ex06 {

    public static void main(String[] args) {
        String s = StdIn.readLine();
        String t = StdIn.readLine();
        if (s.length() == t.length() && s.concat(s).indexOf(t) != -1) // beautiful!
            System.out.println(s + " is a circular rotation of " + t);
        else
            System.out.println(s + " is not a circular rotation of " + t);
    }
}
