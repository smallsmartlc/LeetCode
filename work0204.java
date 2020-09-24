package Leetcode.smart;


public class work0204 {
    public static void main(String[] args) {
        work0204 w = new work0204();
        System.out.println(w.countPrimes(10));
    }

    //2.1.厄拉多塞筛法-优化
    public int countPrimes2_1(int n) {
        //当判断出一个数为质数时,标记该数的倍数为true
        if (n < 3) return 0;//没有比2小的质数
        int count = 1;
        boolean[] signs = new boolean[n];
        for (int i = 3; i < n; i += 2) { //只遍历奇数
            if (!signs[i]) { //质数
                count++;
                int temp = i * 3;
                while (temp < n) {
                    signs[temp] = true;
                    temp += 2 * i;
                }
            }
        }
        return count;
    }

    //2.厄拉多塞筛法
    public int countPrimes2(int n) {
        //当判断出一个数为质数时,标记该数的倍数为true
        int count = 0;
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!signs[i]) {
                count++;
                int temp = i + i;
                while (temp < n) {
                    signs[temp] = true;
                    temp += i;
                }
            }
        }
        return count;
    }

    //1.暴力法 - 优化
    public int countPrimes(int n) {
        if (n < 3) return 0;//没有比2小的质数
        int count = 1;//大于2可以从1开始计数
        for (int i = 3; i < n; i++) {
            boolean flag = true;

//            if(i % 2 == 0),位运算优化,偶数的最后一位都为0
            if ((i & 1) == 0) continue;
            //这里用j*j <= i 代替 j <= Math.sqrt(i) ,效率更高
            for (int j = 3; j * j <= i; j += 2) {
                //每次循环加2,排除偶数,减少循环次数
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
    }

}