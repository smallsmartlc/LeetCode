package Leetcode.smart;


import java.util.List;

/**
 * leetcode 0276 栅栏涂色
 * lintcode 514. 栅栏染色
 */
public class work0276 {

    public static void main(String[] args) {
        work0276 w = new work0276();
        System.out.println(w.numWays(3, 2));
    }

    public int numWays(int n, int k) {
        // write your code here
        if(n==0) return 0;
        if(n==1) return k;
        int arr[] = new int[n];
        arr[0] = k;
        arr[1] = k*k;
        for (int i = 2; i < n; i++) {
            //两种情况
            // n和n-1颜色相同,n-1和n-2颜色不同,那么就是n-2位置*k-1种方案
            // n和n-1颜色不同,此时有n-1位置*k-1种方案
            arr[i] = (arr[i-1]+arr[i-2]) * (k-1);

        }
        return arr[n-1];
    }

}

