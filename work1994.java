package Leetcode.smart;

/**
 * LeetCode1994 好子集的数目
 *
 * @author LuCong
 * @since 2022-2-22
 **/
public class work1994 {
    public static void main(String[] args) {
        work1994 w = new work1994();
        System.out.println(w.numberOfGoodSubsets(new int[]{1, 2, 3, 4}));
    }

    private int mod = 1000000007;
    private static int masks[] = new int[]{0, 0, 1, 2, -1, 4, 3, 8, -1, -1, 5, 16, -1, 32, 9, 6, -1, 64, -1, 128, -1, 10, 17, 256, -1, -1, 33, -1, -1, 512, 7};

    public int numberOfGoodSubsets(int[] nums) {
        int[] map = new int[31];
        for (int num : nums) {
            map[num]++;//统计出现频率
        }
        int mask = 1 << 10;//bitmap表示primes里的质数是否出现
        int[] dp = new int[mask]; // 每种出现情况对应的子集数目
        dp[0] = 1;
        for (int i = 2; i < 31; i++) {
            // 1和任何子集都可以共存,从2开始考虑
            if (map[i] == 0) continue;//没出现,出现则对i试除
            if (masks[i] == -1) continue;
            int cur = masks[i];
            for (int prev = mask - 1; prev >= 0; prev--) {
                if ((prev & cur) != 0) continue; //某一位有两个1
                int merge = prev | cur;//合并两个数
                dp[merge] = (int) ((dp[merge] + (long) dp[prev] * map[i]) % mod); // 防止溢出
            }
        }
        int res = 0;
        for (int i = 1; i < mask; i++) res = (res + dp[i]) % mod;
        while (map[1]-- > 0) res = (res * 2) % mod;
        return res;
    }

    private static int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static int checkNumber(int num) {
        int cur = 0; // cur为当前的bitmap
        for (int j = 0; j < 10; j++) {
            int p = primes[j], times = 0;
            while (num % p == 0) {
                cur |= (1 << j);
                num /= p;
                times++;
            }
            if (times > 1) {
                return -1; // 出现两次以上
            }
        }
        return cur;
    }

    static {
        for (int i = 2; i < 31; i++) {
            masks[i] = checkNumber(i);
        }
    }

}







