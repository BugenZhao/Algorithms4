package com.bugenzhao.algorithms4.exercise.chapter2_1;

public class InsertionX {
    public static void sort(Comparable[] items) {
        int N = items.length;

        //将最小元素移动到最左边，作为哨兵，省略 j>0 的判断
        int exchCount = 0;
        for (int i = N - 1; i >= 1; i--) {
            if (less(items[i], items[i - 1])) {
                exch(items, i, i - 1);
                ++exchCount;
            }
        }
        if (exchCount == 0) return;

        for (int i = 1; i < N; i++) {
            int j = i;
            //减少对数组的访问次数
            Comparable tmp = items[j];
            for (; less(tmp, items[j - 1]); --j)
                items[j] = items[j - 1];
            items[j] = tmp;
        }
    }

    public static void sort(Comparable[] items, int lo, int hi) {
        int N = hi - lo + 1;

        //将最小元素移动到最左边，作为哨兵，省略 j>0 的判断
        int exchCount = 0;
        for (int i = N - 1 + lo; i >= 1 + lo; i--) {
            if (less(items[i], items[i - 1])) {
                exch(items, i, i - 1);
                ++exchCount;
            }
        }
        if (exchCount == 0) return;

        Comparable tmp;
        for (int i = 1 + lo; i < N + lo; i++) {
            int j = i;
            //减少对数组的访问次数
            tmp = items[j];
            for (; less(tmp, items[j - 1]); --j)
                items[j] = items[j - 1];
            items[j] = tmp;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }


}
