package Leetcode.smart;

/**
 * 2006 差的绝对值为 K 的数对数目
 * @author LuCong
 * @since 2022-2-9
 **/
public class work2006 {
    public static void main(String[] args) {
        work2006 w = new work2006();
        System.out.println(w.countKDifference(new int[]{1, 2, 2, 1}, 1));
    }

    public int countKDifference(int[] nums, int k) {
        int[] map = new int[101];
        int res = 0;
        for (int num : nums) {
            res += (num + k > 100 ? 0 : map[num + k]) + (num - k < 0 ? 0 : map[num - k]);
            map[num]++;
        }
        return res;
    }

}


