package com.bugenzhao.algorithms4.exercise.chapter1_4;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class ThreeSumFaster {
    public static int threeSum(int[] nums, int target) {
        int cnt = 0;
        for (int l = 0; l < nums.length - 2; ++l) {
            int m = l + 1, r = nums.length - 1;
            while (m < r) {
                if (nums[l] + nums[m] + nums[r] < target) ++m;
                else if (nums[l] + nums[m] + nums[r] > target) --r;
                else {
                    System.out.println(nums[l] + " " + nums[m] + " " + nums[r]);
                    ++m;
                    --r;
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = new In("data/16Kints.txt").readAllInts();
        Arrays.sort(nums);
        System.out.println(threeSum(nums, 0));
    }
}
