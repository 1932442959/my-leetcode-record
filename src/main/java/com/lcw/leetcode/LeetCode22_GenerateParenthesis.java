package com.lcw.leetcode;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LeetCode22_GenerateParenthesis {

    public static void main(String[] args) {
        List<String> strings = new LeetCode22_GenerateParenthesis().generateParenthesis(4);
        strings.forEach(System.out::println);
    }

    private char left = '(', right = ')';

    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(right, left);
        addList(2 * n, "", new LinkedList<>(), resList, left, map);
        return resList;
    }

    private void addList(int maxLength, String s, LinkedList<Character> stack, List<String> resultList, Character addC, Map<Character, Character> map) {
        if (stack.isEmpty()) {
            stack.push(left);
            s += left;
        } else {
            s += addC;
            if (map.containsKey(addC) && stack.peek() == map.get(addC)) {
                stack.pop();
            } else {
                stack.push(addC);
            }
        }
        if (s.length() == maxLength && stack.isEmpty()) {
            if (!resultList.contains(s)) {
                resultList.add(s);
            }
            return;
        }
        if (s.length() == maxLength && !stack.isEmpty()) {
            return;
        }
        LinkedList<Character> stackL = new LinkedList<>();
        LinkedList<Character> stackR = new LinkedList<>();
        stackL.addAll(stack);
        stackR.addAll(stack);
        addList(maxLength, s, stackL, resultList, left, map);
        addList(maxLength, s, stackR, resultList, right, map);
    }
}
