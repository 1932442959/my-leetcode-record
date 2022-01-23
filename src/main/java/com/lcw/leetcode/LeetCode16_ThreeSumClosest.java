package com.lcw.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode16_ThreeSumClosest {
    public static void main(String[] args) {
        int nums[] = {0, 0, 0};
        int res = new LeetCode16_ThreeSumClosest().threeSumClosest(nums, 1);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        //数组进行排序
        Arrays.sort(nums);
        //初始化三数和
        int sum = 1000000;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                //如果当前距离更小，则赋值
                if (Math.abs(nums[i] + nums[left] + nums[right] - target) < Math.abs(sum - target)) {
                    sum = nums[i] + nums[left] + nums[right];
                }
                //如果距离为 0，直接返回 target
                if (nums[i] + nums[left] + nums[right] == target) {
                    return target;
                }
                if (nums[i] + nums[left] + nums[right] < target) {
                    left++;
                }
                if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                }
            }
        }
        return sum;
    }
}
