package com.lcw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode13_LengthOfLongestSubstring {

    private String longestStr = "";
    private Map<Character, Character> repeatMap = new HashMap<>();

    public int lengthOfLongestSubstring(String s) {
        for (int i = 0; i < s.length(); i++) {
            longestStr = longestSubString(s, i);
        }
        return longestStr.length();
    }

    private String longestSubString(String s, Integer p) {
        if (s.length() - p <= longestStr.length()) {
            return longestStr;
        }
        String currentStr = "";
        while (p < s.length()) {
            char currentChar = s.charAt(p);
            if (repeatMap.containsKey(currentChar)) {
                repeatMap.clear();
                return currentStr.length() > longestStr.length() ? currentStr : longestStr;
            }
            repeatMap.put(currentChar, currentChar);
            currentStr += currentChar;
            p++;
        }
        repeatMap.clear();
        return currentStr.length() > longestStr.length() ? currentStr : longestStr;
    }
}
