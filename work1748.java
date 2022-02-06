package Leetcode.smart;

//LeetCode1748 唯一元素的和

import java.util.HashMap;
import java.util.Map;

public class work1748 {
    public static void main(String[] args) {
        work1748 w = new work1748();
        System.out.println(w.sumOfUnique(new int[]{2, 0, 0}));
    }

    public int sumOfUnique2(int[] nums) {
        Boolean[] map = new Boolean[101];
        int res = 0;
        for (int num : nums) {
            if(map[num] == null){
                res += num;
                map[num] = true;
            }else if(map[num]){
                res -= num;
                map[num] = false;
            }
        }
        return res;
    }
    public int sumOfUnique(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                res += num;
                map.put(num, true);
            } else if (map.get(num)) {
                res -= num;
                map.put(num, false);
            }
        }
        return res;
    }
}