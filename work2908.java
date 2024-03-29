package Leetcode.smart;

/**
 * 2908 元素和最小的山形三元组 I
 *
 * @author LuCong
 * @since 2024-3-29
 **/
public class work2908 {

    public static void main(String[] args) {
        work2908 w = new work2908();
        int[] nums = new int[]{8,6,1,5,3};
        System.out.println(w.minimumSum(nums));
    }

    public int minimumSum(int[] nums) {
        // 反向接雨水
        int n = nums.length;
        int res = -1;
        int[] leftmin =  new int[n];
        int[] rightmin =  new int[n];
        leftmin[0] = nums[0];
        rightmin[n-1] = nums[n-1];
        for (int i = 1,j=n-2;i < n;i++,j--){
            leftmin[i] = Math.min(nums[i-1],leftmin[i-1]);
            rightmin[j] = Math.min(nums[j+1],rightmin[j+1]);
        }

        for(int i = 1;i<n-1;i++){
            if (nums[i]<=leftmin[i] || nums[i] <= rightmin[i]){
                continue;
            }
            if(res == -1){
                res = nums[i] + leftmin[i]+rightmin[i];
            }else{
                res = Math.min(res,nums[i] + leftmin[i]+rightmin[i]);
            }
        }
        return res;
    }
}
