package com.lcw.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode7_Reverse {
    public static void main(String[] args) {
        System.out.println(new LeetCode7_Reverse().reverse(1534236469));
    }

    public int reverse1(int x) {
        long rev = 0L;
        List<Integer> list = new ArrayList<>();
        while (x / 10 != 0) {
            list.add(x % 10);
            x /= 10;
        }
        list.add(x);
        for (int i = 0; i < list.size(); i++) {
            rev += list.get(i) * Math.pow(10, list.size() - i - 1);
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        return Math.toIntExact(rev);
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int t = rev * 10;
            if (t / 10 != rev) return 0;
            rev = t + x % 10;
            x /= 10;
        }
        return rev;
    }
}
