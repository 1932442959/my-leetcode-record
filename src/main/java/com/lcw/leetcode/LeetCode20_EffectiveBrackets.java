package com.lcw.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20_EffectiveBrackets {
    public boolean isValid(String s) {
        // define map to store characters' relation
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        // use stack to store a new string
        LinkedList<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            // empty
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            // current character is match with the before
            if (map.get(stack.peek()) == c) {
                stack.pop();
                continue;
            }
            // not match
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
