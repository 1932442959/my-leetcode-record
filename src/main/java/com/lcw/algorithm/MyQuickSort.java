package com.lcw.algorithm;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * @description 描述
 * @outhor Lu Congwen
 * @create 2022-01-01 23:39
 */
public class MyQuickSort {
    public static void main(String[] args) {
        int s[] = new int[]{44, 42, 11, 90, 76, 23, 42, 88, 75, 23};
        new MyQuickSort().sort(s, 0, s.length - 1);
        for (int i : s) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public int addjustArray(int[] s, int l, int r) {
        int x = s[l], i = l, j = r;
        while (i < j) {
            while (i < j && s[j] >= x) {
                j--;
            }
            if (i < j) {
                s[i++] = s[j];
            }
            while (i < j && s[i] < x) {
                i++;
            }
            if (i < j) {
                s[j--] = s[i];
            }
        }
        s[i] = x;
        return i;
    }

    public void sort(int[] s, int l, int r) {
        if (l < r) {
            int i = addjustArray(s, l, r);
            sort(s, l, i - 1);
            sort(s, i + 1, r);
        }
    }

}
