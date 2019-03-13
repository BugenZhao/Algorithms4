package com.bugenzhao.algorithms4.exercise.chapter1_4;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class TwoSumFaster {
    public static int twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int cnt = 0;
        while (l < r) {
            if (nums[l] + nums[r] < target) ++l;
            else if (nums[l] + nums[r] > target) --r;
            else {
                ++l;
                --r;
                ++cnt;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = new In("data/16Kints.txt").readAllInts();
        Arrays.sort(nums);
        System.out.println(twoSum(nums, 0));
    }
}
