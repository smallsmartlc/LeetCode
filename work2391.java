package Leetcode.smart;

import java.util.Stack;

/**
 * Leetcode2391 收集垃圾的最少总时间
 *
 * @author LuCong
 * @since 2024-5-11
 **/
public class work2391 {
    public static void main(String[] args) {
        work2391 w = new work2391();
        System.out.println(w.garbageCollection(new String[]{"G","P","GP","GG"},new int[]{2,4,3}));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] dp = new int[n];
        int count = 0;
        int last_m = 0;
        int last_p = 0;
        int last_g = 0;
        for(int i = n-1;i >= 0 ;i--){
            for(char c : garbage[i].toCharArray()){
                if (c == 'M'){
                    last_m = i;
                } else if (c == 'P'){
                    last_p = i;
                } if (c == 'G'){
                    last_g = i;
                }
            }
            if (last_g != 0 && last_m != 0 && last_p!=0) break;
        }
        for(int i = 1;i < n;i++){
            count += garbage[i].length();
            for(char c : garbage[i].toCharArray()){
                if (c == 'M'){
                    last_m = i;
                } else if (c == 'P'){
                    last_p = i;
                } if (c == 'G'){
                    last_g = i;
                }
            }
            dp[i] = dp[i-1] + travel[i-1];
        }
        return  dp[last_m] + dp[last_p] + dp[last_g] + garbage[0].length() + count;
    }
}


