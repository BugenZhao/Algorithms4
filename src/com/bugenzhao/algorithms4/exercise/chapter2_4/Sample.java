package com.bugenzhao.algorithms4.exercise.chapter2_4;

import java.util.Arrays;
import java.util.Random;

public class Sample {
    double[] tree;
    int length;
    double sum;

    public Sample(double p[]) {
        length = p.length;

        int treeSize = 1;
        while (treeSize < 2 * length) {
            treeSize = treeSize * 2;
        }
        System.out.println(treeSize);
        tree = new double[treeSize];

        int n = treeSize / 2;
        for (int i = 0; i < length; i++) {
            tree[i + n] = p[i];
        }
        while (n > 1) {
            n = n / 2;
            for (int i = 0; i < n; i++) {
                tree[i + n] = tree[(i + n) * 2] + tree[(i + n) * 2 + 1];
            }
        }

        sum = tree[1];
    }

    public static void main(String[] args) {
        double[] p = {1, 2, 3, 3};
        int[] cnt = new int[4];
        Sample sample = new Sample(p);
        sample.change(3, 4);
        for (int i = 0; i < 100000; i++) {
            ++cnt[sample.random()];
        }
        System.out.println(Arrays.toString(cnt));
    }

    public void change(int i, double v) {
        int p = i + length;
        tree[p] = v;
        while (p > 1) {
            p /= 2;
            tree[p] = tree[p * 2] + tree[p * 2 + 1];
        }
        sum = tree[1];
    }

    public int random() {
        Random random = new Random();
        double num = random.nextDouble() * sum;
        int p = 1;
        while (2 * p < tree.length) {
            if (num < tree[p * 2]) {
                p *= 2;
            } else {
                num -= tree[p * 2];
                p = p * 2 + 1;
            }
        }
        return p - length;
    }

    @Override
    public String toString() {
        return Arrays.toString(tree);
    }
}
