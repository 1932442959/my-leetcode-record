package com.lcw.leetcode;

import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class FindMedianSortedArrays_4 {
    public static void main(String[] args) {
        int nums1[] = {1, 2}, nums2[] = {3, 4};
        System.out.println(new FindMedianSortedArrays_4().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums[] = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length % 2 != 0) {
            return nums[nums.length / 2];
        }
        return (Double.valueOf(nums[nums.length / 2 - 1]) + Double.valueOf(nums[nums.length / 2])) / 2;
    }
}
