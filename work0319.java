package Leetcode.smart;

import java.util.Arrays;

/**
 * LeetCode0319 灯泡开关
 */

public class work0319 {
    public static void main(String[] args) {
        work0319 w = new work0319();
        System.out.println(w.bulbSwitch(1));
    }

    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
    public int bulbSwitch1(int n) {
        int sum = 0;
        for (int i = 1; i*i <= n; i++) {
            sum++;
        }
        return sum;
    }
    public int bulbSwitch0(int n) {
        // 模拟过程,超时
        boolean[] lights = new boolean[n];
        Arrays.fill(lights,true);
        for (int i = 2; i <= n; i++) {
            for (int j = i-1; j < n; j+=i) {
                lights[j] = !lights[j];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(lights[i]) res++;
        }
        return res;
    }

}