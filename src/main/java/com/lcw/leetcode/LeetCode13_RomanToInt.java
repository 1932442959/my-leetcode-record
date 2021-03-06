package com.lcw.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode13_RomanToInt {
    public static void main(String[] args) {
        System.out.println(new LeetCode13_RomanToInt().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = initMap();
        //长度 - 1位是因为需要判断 i 的下一位罗马数字的值是否比 i 位置处大，如果大则 i 位置处罗马数字转换结果为负数
        for (int i = 0; i < s.length() - 1; i++) {
            Integer curr = map.get(s.charAt(i));
            Integer next = map.get(s.charAt(i + 1));
            if (curr < next) {
                res -= curr;
            } else {
                res += curr;
            }
        }
        //添加 s 最后一个位置处罗马数字的值
        res += map.get(s.charAt(s.length() - 1));
        return res;
    }

    /**
     * 初始化罗马数字 Map
     *
     * @return
     */
    private Map<Character, Integer> initMap() {
        // * 字符          数值
        // * I             1
        // * IV            4
        // * V             5
        // * IX            9
        // * X             10
        // * XL            40
        // * L             50
        // * XC            90
        // * C             100
        // * CD            400
        // * D             500
        // * CM            900
        // * M             1000
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        return map;
    }
}
