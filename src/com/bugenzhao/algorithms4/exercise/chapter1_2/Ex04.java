package com.bugenzhao.algorithms4.exercise.chapter1_2;

import edu.princeton.cs.algs4.*;

public class Ex04 {

    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1); // world
        StdOut.println(string2); // hello

        String s1 = new String("hello");
        String s2 = s1;
        s1 = "world";
        StdOut.println(s1); // world
        StdOut.println(s2); // hello
    }
}
