package com.bugenzhao.algorithms4.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch = scanner.next().charAt(0);
        String[] strs = new String[30];
        int n = 0;
        while (scanner.hasNext()) {
            char[] tmp = scanner.next().toCharArray();
            if (tmp[0] == '@') break;
            StringBuilder sb = new StringBuilder();
            for (char c : tmp) {
                if (c == ch) continue;
                sb.append(c);
            }
            strs[n++] = sb.toString();
        }
        Arrays.sort(strs, 0, n, Comparator.reverseOrder());
        for (String str : strs) {
            if (str == null) break;
            System.out.println(str);
        }
    }
}