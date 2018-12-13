package com.bugenzhao.algorithms4.Exercise.Chapter1_2;

import edu.princeton.cs.algs4.*;
import java.util.Scanner;
import java.util.Arrays;

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
