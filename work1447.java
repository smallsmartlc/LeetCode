package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode1447 最简分数
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1447 {
    public static void main(String[] args) {
        work1447 w = new work1447();
        System.out.println(w.gcd(8,3));
        System.out.println(w.simplifiedFractions(4));
    }


    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i,j) == 1){
                    res.add(j+"/"+i);
                }
            }
        }
        return res;
    }

    private int gcd(int a,int b){
        while (b != 0){
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

}







