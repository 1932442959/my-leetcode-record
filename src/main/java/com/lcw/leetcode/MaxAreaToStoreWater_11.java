package com.lcw.leetcode;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaToStoreWater_11 {
    public int maxArea(int[] height) {
        //初始化最大面积
        int maxArea = 0;
        //初始化左右指针
        int leftPoint = 0;
        int rightPoint = height.length - 1;

        //计算最大面积
        while (leftPoint < rightPoint) {
            //求出面积
            int tempArea = (rightPoint - leftPoint) * Math.min(height[rightPoint], height[leftPoint]);
            //如果面积比当前最大面积还大，则赋值
            maxArea = Math.max(tempArea, maxArea);
            //指向边长较小的指针进行移动
            if (height[leftPoint] <= height[rightPoint]) {
                leftPoint++;
            } else {
                rightPoint--;
            }
        }

        return maxArea;
    }
}
