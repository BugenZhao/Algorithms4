package com.bugenzhao.algorithms4.exercise.chapter2_5;

public class KendallTau {
    public static long distance(int[] a, int[] b) {
        // 假设 a 是顺序的，则对应的 b 的逆序数对即为所求
        if (a.length != b.length)
            throw new IllegalArgumentException();
        int n = a.length;
        int[] ainv = new int[n];
        for (int i = 0; i < n; i++) {
            ainv[a[i]] = i;
        }
        int[] bnew = new int[n];
        for (int i = 0; i < n; i++) {
            bnew[i] = ainv[b[i]];
            // b 的元素相对 a 来说，在哪个位置？
        }
        return Inversions.count(bnew);
    }

    public static void main(String[] args) {
        System.out.println("KendallTau distance: " + distance(
                new int[]{0, 3, 1, 6, 2, 5, 4},
                new int[]{1, 0, 3, 6, 4, 2, 5}));
    }
}
