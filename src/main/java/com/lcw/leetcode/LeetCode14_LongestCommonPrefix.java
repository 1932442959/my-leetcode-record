package com.lcw.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LeetCode14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //初始化字符串
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < common.length(); j++) {
                if (common.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            common = common.substring(0, j);
        }
        return common;
    }
}
