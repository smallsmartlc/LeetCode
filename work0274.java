package Leetcode.smart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 0274.H指数
 */
public class work0274 {

    public static void main(String[] args) {

        work0274 w = new work0274();
        int[] nums = new int[]{3,0,6,1,5};
        System.out.println(w.hIndex(nums));
    }
    public int hIndex(int[] citations) {
        int h = citations.length;
        Arrays.sort(citations);
        for (int c : citations) {
            if(c<h) h--;
        }
        return h;
    }
    public int hIndex2(int[] citations){
        //计数排序,使用数组存储每个值的出现次数,再将这个值回写回数组
        //一般比较适合固定数字的排序,其他情况复杂度较高
        int n = citations.length;
        int[] papers = new int[n+1];
        for (int c : citations) {
            papers[c > n ? n : c]++;
        }
        int k = n;
        for (int s = papers[n]; s < k; s += papers[k]) {
            k--;
        }
        return k;
    }
}

