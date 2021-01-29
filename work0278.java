package Leetcode.smart;

/**
     * 0278.第一个错误的版本
 */
public class work0278 {

    public static void main(String[] args) {

        work0278 w = new work0278();
        System.out.println(w.firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        // 二分法
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if(isBadVersion(mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version) {
        return version > 3;
    }
}

