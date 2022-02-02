package Leetcode.smart;

//365 水壶问题

import java.util.HashSet;

public class work0365 {

    public static void main(String[] args) throws AlreadyTakenException, GameEndException {
        work0365 w = new work0365();
        System.out.println(w.canMeasureWater2(3, 5, 4));
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        if (z > x + y) return false;
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        // 两个桶必须有一个是满的或者是空的,小桶满了可以倒到大桶里,所以我们转化为考虑大桶里水的情况
        // 小桶装满往大桶倒,如果大桶满了就清空大桶,将小桶剩余的水倒进大桶
        boolean[] visited = new boolean[max]; //大桶现在多少水
        int remain = 0;// 大桶现在没有水
        while (!visited[remain]) {
            visited[remain] = true;
            remain = (remain + min) % max;
            if (remain == z || remain + max == z) {
                // 大桶里已经有z升水或者,大桶满了之后大桶加小桶是z升水
                return true;
            }
        }
        return false;
    }

    public boolean canMeasureWater2(int x, int y, int z) {
        // 开挂,数学法
        // 我们的计量单位就只有大桶和小桶,所以每次操作水的变化量只能是x或y
        // 那么转化为 z = ax + by(a,b为整数,z < x + y)
        // 通过贝祖定理得出该方程有解当且仅当z是x,y的最大公约数的倍数
        // 所以转化成求最大公约数
        if (x + y < z) {
            return false;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        // 辗转相除法
        int reminder = x % y;
        x = y;
        while (reminder != 0) {
            y = reminder;
            reminder = x % y;
            x = y;
        }
        return x;
    }
}