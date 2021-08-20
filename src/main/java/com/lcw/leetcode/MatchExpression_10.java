package com.lcw.leetcode;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MatchExpression_10 {
    public static void main(String[] args) {
        System.out.println(new MatchExpression_10().isMatch1("", ".*"));
        System.out.println(new MatchExpression_10().isMatch("", ".*"));
    }

    /**
     * 采用递归的方式解决
     *
     * @param s 条件字符串
     * @param p 正则表达式
     * @return 匹配结果
     */
    public boolean isMatch1(String s, String p) {
        //正则表达式长度为 0，则判断条件字符串长度是否为 0
        if (p.length() == 0) {
            return s.length() == 0;
        }

        //条件字符串第 0 位置上的字符是否与正则表达式第 0 个位置上的字符相同或者为 '.'
        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        //如果正则表达式字符串长度为 2 以上并且 第一次匹配就是以 a*(多个重复字符) 的形式进行匹配
        if (p.length() >= 2 && p.charAt(1) == '*') {
            //a* 形式匹配结果为 0 个或者匹配结果为多个
            return isMatch1(s, p.substring(2)) || (firstMatch && isMatch1(s.substring(1), p));
        }

        //如果条件字符串长度为 1 或者条件字符串长度为 2 以上，但是前几个字符是不同的多个字符
        return firstMatch && isMatch1(s.substring(1), p.substring(1));
    }

    /**
     * 采用动态规划的方式
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        //初始化
        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
