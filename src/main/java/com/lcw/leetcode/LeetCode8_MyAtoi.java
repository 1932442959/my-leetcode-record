package com.lcw.leetcode;

/**
 * 字符串转换整数
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode8_MyAtoi {
    public int myAtoi(String s) {
        //初始化最大值字符串长度 若结果大于该长度且不含 "-" 则返回最大值
        int max_length_positive = String.valueOf(Integer.MAX_VALUE).length();
        //初始化最小值字符串 若结果大于该长度且含 "-" 则返回最小值
        int max_length_negative = String.valueOf(Integer.MIN_VALUE).length();
        //判断结果为正还是负 正为 true 负为 false
        boolean flag_positive_negative = true;

        //字符串长度为 0
        if (s.length() == 0) {
            return 0;
        }

        //初始化字符数组
        char[] initChars = s.toCharArray();
        //初始化指针，指示当前读取位置
        int point = 0;
        //初始化结果字符串
        String res = "";

        //读取前导空格
        while (point < s.length() && initChars[point] == ' ') {
            point++;
        }

        //读取符号
        while (point < s.length() && (initChars[point] == '-' || initChars[point] == '+')) {
            //添加 "-" or "+" 到结果
            res += initChars[point];
            //设置结果为负值
            flag_positive_negative = initChars[point] == '-' ? false : true;
            point++;
            break;
        }

        //读取数字
        //定义布尔变量，判断 0 是否出现于数字之前，true 则是数字之前的 0 去掉，false 则为数字中的 0 不可去掉
        boolean remove_zero = true;
        while (point < s.length() && (Integer.valueOf(initChars[point]) >= 48 && Integer.valueOf(initChars[point]) <= 57)) {
            //如果数字为 0
            if (initChars[point] == '0') {
                //需要去掉 0
                if (remove_zero == true) {
                    point++;
                    continue;
                }
            }
            //更改布尔变量，不需要去掉 0
            remove_zero = false;
            //添加对应数字结果
            res += initChars[point];
            point++;
        }

        //读取了符号，但是后面未读取到数据 or 什么都没有读取到
        if (res.equals("-") || res.equals("+") || res.length() == 0) {
            return 0;
        }

        //读取到了符号且为正数的情况
        if (flag_positive_negative) {
            //去掉 "+" 符号
            res.replace("+", "");
            try {
                return Integer.valueOf(res);
            } catch (Exception e) {
                return Integer.MAX_VALUE;
            }
        }

        //读取到了符号且为负数的情况
        try {
            return Integer.valueOf(res);
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }
    }
}
