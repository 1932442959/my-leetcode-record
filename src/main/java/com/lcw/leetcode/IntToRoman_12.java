package com.lcw.leetcode;

import java.util.*;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
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
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntToRoman_12 {
    public static void main(String[] args) {
        System.out.println(new IntToRoman_12().intToRoman(1994));
    }

    /**
     * 使用字符串数组的方式实现
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanStr = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];

            while (num >= value) {
                num -= value;
                romanStr.append(symbol);
            }
        }

        return romanStr.toString();
    }

    /**
     * 使用 TreeMap 的方式实现
     *
     * @param num
     * @return
     */
    public String intToRomanUseTreeMap(int num) {
        TreeMap<Integer, String> map = initMap();
        //初始化罗马数字字符串
        StringBuilder romanStr = new StringBuilder();
        //遍历整个罗马数字 Map，对 num 进行数字转罗马字符处理
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            //该罗马数字重复的次数
            int repeatNum = num / entry.getKey();
            //减去已经计算过的罗马数字
            num = num - repeatNum * entry.getKey();
            //没有重复次数，则 continue
            if (repeatNum == 0) {
                continue;
            }
            for (int i = 0; i < repeatNum; i++) {
                romanStr.append(entry.getValue());
            }
        }
        return romanStr.toString();
    }

    /**
     * 初始化罗马数字 Map
     *
     * @return
     */
    private TreeMap<Integer, String> initMap() {
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
        TreeMap<Integer, String> map = new TreeMap<>((o1, o2) -> o2 - o1);
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        return map;
    }
}
