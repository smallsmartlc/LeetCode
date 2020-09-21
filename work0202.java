package Leetcode.smart;


public class work0202 {
    public static void main(String[] args) {
        work0202 w = new work0202();
        System.out.println(w.isHappy(2));
    }

    public boolean isHappy(int n) {

        int slow = getHappy(n);
        int fast = getHappy(slow);

        while (fast != slow) {
            slow = getHappy(slow);
            fast = getHappy(getHappy(fast));
        }
        return slow == 1;
    }

    private int getHappy(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}