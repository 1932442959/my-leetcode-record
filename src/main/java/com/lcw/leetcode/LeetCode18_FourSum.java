package com.lcw.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode18_FourSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 0, 1};
        int target = 0;
        List<List<Integer>> lists = new LeetCode18_FourSum().fourSum(nums, target);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //进行顺序排序
        Arrays.sort(nums);
        //初始化结果集合
        List<List<Integer>> ans = new ArrayList<>();
        //如果数组长度小于 4
        if (nums.length < 4) {
            return ans;
        }
        dfs(0, 0, target, ans, new ArrayList<>(), nums);
        return ans;
    }

    private void dfs(int start, int sum, int target, List<List<Integer>> ans, List<Integer> res, int[] nums) {
        //如果加和等于目标值并且当前结果中已有 4 个值，则添加到 ans
        if (sum == target && res.size() == 4) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //第一种剪枝情况：n-i个元素不足以填满列表
            if (nums.length - i + res.size() < 4) {
                return;
            }
            //第二种剪枝情况：当前元素 + 当前和 + (4-确定元素个数-1)*下一个元素 > target
            if (i < nums.length - 1 && sum + nums[i] + (4 - res.size() - 1) * nums[i + 1] > target) {
                return;
            }
            //第三种剪枝情况：当前元素 + 当前和 + (4-确定元素个数-1)*最后一个元素 < target
            if (i < nums.length - 1 && sum + nums[i] + (4 - res.size() - 1) * nums[nums.length - 1] < target) {
                continue;
            }
            //第四种剪枝情况：去重 1，2位相同 那么[0,1,3,4]和[0,2,3,4]结果相同，需要去重
            if (start < i && nums[i - 1] == nums[i]) {
                continue;
            }
            //添加没有被剪枝的数据
            res.add(nums[i]);
            sum += nums[i];
            //进入下一次循环
            dfs(i + 1, sum, target, ans, res, nums);
            //回溯，跳到下一个位置
            res.remove(res.size() - 1);
            sum -= nums[i];
        }
    }
}
