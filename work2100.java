package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * 2100 适合打劫银行的日子
 *
 * @author LuCong
 * @since 2022-3-4
 **/
public class work2100 {
    public static void main(String[] args) {
        work2100 w = new work2100();
        System.out.println(w.goodDaysToRobBank(new int[]{1, 1, 1, 1, 1}, 0));
    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] preDp = new int[n];
        int[] sufDp = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) preDp[i] = preDp[i - 1] + 1;
            if (security[n - i - 1] <= security[n - i]) sufDp[n - i - 1] = sufDp[n - i] + 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - time; i++) {
            if (preDp[i] >= time && sufDp[i] >= time) list.add(i);
        }
        return list;
    }

}


