package com.lcw.leetcode;

/**
 * Z字形变换
 * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZChange_6 {
    public String convert(String s, int numRows) {
        //只有一行或者字符串只有一个字符
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        //初始化字符数组
        char[] rawChars = s.toCharArray();

        //求第 1 行，第二个字符为前一个字符后面的 2 * (numRows - 1) 个位置处
        StringBuilder res = new StringBuilder();
        //初始化指针，指向的元素放入字符串
        int first_point = 0;
        while (first_point < rawChars.length) {
            res.append(rawChars[first_point]);
            first_point += 2 * (numRows - 1);
        }

        //求第 1 行和第 numRows 行之间的行 n
        //计数器为偶数，第二个字符为第一个字符后面的 2 * (numRows - n) 个位置处
        //计数器为奇数，第二个字符为第一个字符后面的 2 * (n - 1) 个位置处
        for (int i = 2; i <= numRows - 1; i++) {
            //初始化指针，指向的元素放入字符串
            int point = i - 1;
            //初始化计数器
            int count = 0;
            while (point < rawChars.length) {
                res.append(rawChars[point]);
                //计数器为偶数
                if (count % 2 == 0) {
                    point += 2 * (numRows - i);
                }
                //计数器为奇数
                else {
                    point += 2 * (i - 1);
                }
                count++;
            }
        }

        //求第 numRows 行，第二个字符为前一个字符后面的 2 * (numRows - 1) 个位置处
        int numRows_point = numRows - 1;
        while (numRows_point < rawChars.length) {
            res.append(rawChars[numRows_point]);
            numRows_point += 2 * (numRows - 1);
        }

        return res.toString();
    }
}
