package com.lcw.leetcode;

/**
 * 快速排序
 */
public class QuickSort_add {
    public static void main(String[] args) {
        int s[] = new int[]{23, 42, 11, 90, 76, 23, 42, 88, 75, 44};
        new QuickSort_add().quick_sort(s, 0, s.length - 1);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println("================================================");
        new QuickSort_add().quick_sort_reverse(s, 0, s.length - 1);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    public void quick_sort_reverse(int[] s, int l, int r) {
        if (l < r) {
            int i = adjustArrayReverse(s, l, r);
            quick_sort_reverse(s, l, i - 1);
            quick_sort_reverse(s, i + 1, r);
        }
    }

    public void quick_sort(int[] s, int l, int r) {
        if (l < r) {
            int i = adjustArray(s, l, r);
            quick_sort(s, l, i - 1);
            quick_sort(s, i + 1, r);
        }
    }

    private int adjustArray(int s[], int l, int r) {
        int x = s[l];
        int i = l, j = r;
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

    private int adjustArrayReverse(int s[], int l, int r) {
        int x = s[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && s[j] < x) {
                j--;
            }
            if (i < j) {
                s[i++] = s[j];
            }
            while (i < j && s[i] >= x) {
                i++;
            }
            if (i < j) {
                s[j--] = s[i];
            }
        }
        s[i] = x;
        return i;
    }
}
