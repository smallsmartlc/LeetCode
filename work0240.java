package Leetcode.smart;


/**
 * 238. 除自身以外数组的乘积
 */
public class work0240 {

    public static void main(String[] args) {

        work0240 w = new work0240();
        int[][] nums = LecoUtil.LecoNewNums(5,5,
                1,4,7,11,15,
                2,5,8,12,19,
                3,6,9,16,22,
                10,13,14,17,24,
                18,21,23,26,30
        );
        int[][] nums2 = LecoUtil.LecoNewNums(2,1,-1,3);
        System.out.println(w.searchMatrix(nums2,3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int col = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int row = n - 1;
        while(col < m && row >=0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                row--;
            }else{
                col++;
            }
        }
        return false;
    }

}

