package Leetcode.smart;

/**
 * 2055 蜡烛之间的盘子
 *
 * @author LuCong
 * @since 2022-2-9
 **/
public class work2055 {
    public static void main(String[] args) {
        work2055 w = new work2055();
        int[][] queries = LecoUtil.LecoNewNums(2, 5,
//                2, 5, 5, 9);
                1, 17, 4, 5, 14, 17, 5, 11, 15, 16);
        LecoUtil.LecoPrint(w.platesBetweenCandles(
                "***|**|*****|**||**|*", queries));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] res = new int[queries.length];
        int[] dpl = new int[n]; // 左侧最近的|坐标;
        dpl[0] = chars[0] == '|' ? 0 : -1;
        int[] dpr = new int[n]; // 右侧最近的|坐标
        dpr[n - 1] = chars[n - 1] == '|' ? n - 1 : n;
        int[] dp = new int[n];// 前面的'*'个数
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            dpl[i] = chars[i] == '|' ? i : dpl[i - 1];
            dpr[j] = chars[j] == '|' ? j : dpr[j + 1];
            dp[i] = chars[i - 1] == '*' ? dp[i - 1] + 1 : dp[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int l = dpr[queries[i][0]], r = dpl[queries[i][1]];
            if (l != n && r != -1 && l < r) res[i] = dp[r] - dp[l];
        }
        return res;
    }
}


