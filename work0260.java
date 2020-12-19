package Leetcode.smart;

import java.util.Arrays;

/**
 * 0258 各位相加
 */
public class work0260 {

    public static void main(String[] args) {

        work0260 w = new work0260();
        int[] nums = new int[]{1,2,3,3,5,5};
        LecoUtil.LecoPrint(w.singleNumber(nums));
    }

    public int[] singleNumber2(int[] nums) {
        //位运算
        int b = 0;
        for (int num : nums) {
            b^=num;
        }
        //从只出现一次地数字II中,我们知道这样做的话出现两次的值会被异或掉
        //所以b 现在就等于 x^y
        //我们主要就是要想办法分离这两个值
        //异或 同值取0,异值取1
        // 因为异或是异值取1,所以b一定有值为1,我们把这个位上值为1的数字分成两组,这样分开异或就能得到两个值了
        int d = b & (-b);//d就是除了最右边的1,其他都为0 (-b = (~b + 1))
        int x = 0;
        for (int num : nums) {
            if((d & num) == 0){
                //这个数的d位为1,分成一组异或找出x
                x ^= num;
            }
        }
        //我们将x,y分成了两组,并找出了x
        //b = x^y,y = x^y^x
        return new int[]{x,b^x};
    }

    public int[] singleNumber(int[] nums) {
        // 普通解法
        Arrays.sort(nums);
        int[] res = new int[2];
        int index = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]!=nums[i+1]){
                res[index++] = nums[i];
                continue;
            }else{
               i++;
            }
        }
        if(res[1] == 0) res[1] = nums[nums.length-1];
        return res;
    }

}

