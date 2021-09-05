package com.lcw.leetcode;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome_5 {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(new LongestPalindrome_5().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLength = 0;
        int maxLeft = 0;
        int maxRight = 0;
        //长度小于 2，字符串本身就是最长回文子串
        if (len < 2) {
            return s;
        }
        boolean dp[][] = new boolean[len][len];
        //初始化，每个长度为 1 的子串的都是回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        //对每个长度的子串进行枚举，求出该长度下为回文子串的范围
        for (int childLen = 2; childLen <= len; childLen++) {
            for (int i = 0; i < len; i++) {
                //子串左边位置为 i，求出子串右边的位置 j
                int j = childLen + i - 1;
                //如果右边超界，退出循环
                if (j > len - 1) {
                    break;
                }
                //求子串是否是回文子串
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    //如果 i 和 j 是相邻的
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //求出最大范围
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLeft = i;
                    maxRight = j;
                    maxLength = j - i + 1;
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }
}
