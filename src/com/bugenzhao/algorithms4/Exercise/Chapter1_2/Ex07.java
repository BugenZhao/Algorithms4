package com.bugenzhao.algorithms4.Exercise.Chapter1_2;

/*
 * @Author: BugenZhao 
 * @Date: 2018-12-09 16:01:40 
 * @Last Modified by:   BugenZhao 
 * @Last Modified time: 2018-12-09 16:01:40 
 */

import edu.princeton.cs.algs4.*;
import java.util.Scanner;
import java.util.Arrays;

public class Ex07 {

    public static String mystery(String s) { // reverse a string
        int N = s.length();
        if (N <= 1)
            return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        String str = StdIn.readLine();
        System.out.println(mystery(str));
    }
}
