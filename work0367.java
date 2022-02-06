package Leetcode.smart;

//367 有效的完全平方数

public class work0367 {

    public static void main(String[] args) throws AlreadyTakenException, GameEndException {
        work0367 w = new work0367();
        System.out.println(w.isPerfectSquare(2147395600));
    }

    public boolean isPerfectSquare(int num) {
        int l = 1,r = num;
        int mid;
        while (l <= r){
            mid = l + r >> 1;
            int n = mid * mid;
            if(n == num) return true;
            else if(n < num && n / mid == mid){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return false;
    }

}