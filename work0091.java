package Leetcode.smart;

/**
 * 0091 解码方法
 */
public class work0091 {
    public int numDecodings2(String s) {
        char[] chs = s.toCharArray();
        if (chs[0] == '0') return 0;
        int dp = 1;
        int pre = 1;
        for (int i = 2; i <= chs.length; i++) {
            int temp = dp;
            if (chs[i - 1] == '0') dp = 0;
            if (chs[i - 2] != '0' && (chs[i - 2] - '0') * 10 + chs[i - 1] - '0' < 27) {
                dp += pre;
            }
            pre = temp;
        }
        return dp;
    }

    public int numDecodings(String s) {
        int len = s.length();
        int[] d = new int[len];
        char[] chs = s.toCharArray();
        if (chs[0] == '0') return 0;
        if (len < 2) {
            return 1;
        }
        if (chs[len - 1] != '0') {
            d[len - 1] = 1;
        } else {
            if (chs[len - 2] > '2' || chs[len - 2] <= '0') {
                return 0;
            } else {
                d[len - 1] = 0;
            }
        }
        if (chs[len - 2] != '0') {
            if (chs[len - 2] < '2' || (chs[len - 2] == '2' && chs[len - 1] < '7')) {
                d[len - 2] = 1 + d[len - 1];
            } else {
                d[len - 2] = d[len - 1];
            }
        } else {
            if (chs[len - 3] > '2' || chs[len - 3] <= '0') {
                return 0;
            } else {
                d[len - 2] = 0;
            }
        }
        for (int i = len - 3; i >= 0; i--) {
            if (chs[i] == '0') {
                if (chs[i - 1] > '0' && chs[i - 1] <= '2') {
                    d[i] = 0;
                } else {
                    return 0;
                }
                continue;
            }
            if (chs[i] < '2' || (chs[i] == '2' && chs[i + 1] < '7')) {
                d[i] = d[i + 1] + d[i + 2];
            } else {
                d[i] = d[i + 1];
            }
        }
        return d[0];
    }

    public static void main(String[] args) {
        work0091 w = new work0091();
        int[] nums = new int[]{1, 2, 2};
        String s = "226";
        System.out.println(w.numDecodings(s));
        System.out.println(w.numDecodings2(s));
    }
}
