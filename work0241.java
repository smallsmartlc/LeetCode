package Leetcode.smart;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 238. 除自身以外数组的乘积
 */
public class work0241 {

    public static void main(String[] args) {

        work0241 w = new work0241();
        System.out.println(w.diffWaysToCompute2("2-1-1"));
    }

    public List<Integer> diffWaysToCompute2(String input) {
        //动态规划
        List<Integer> numList = new ArrayList<>();
        List<Character> opsList = new ArrayList<>();

        char[] chars = input.toCharArray();

        int num = 0;
        int index = 0;
        while (index < chars.length) {
            char c = chars[index];
            if (isOperation(c)) {
                numList.add(num);
                num = 0;
                opsList.add(c);
            } else {
                num = num * 10 + c - '0';
            }
            index++;
        }
        numList.add(num);
        int n = numList.size();
        List<Integer>[][] dp = new List[n][n];
        for (int i = 0; i < n; i++) {
            //附初值
            ArrayList<Integer> list = new ArrayList<>();
            list.add(numList.get(i));
            dp[i][i] = list;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0, j; (j = i + len - 1) < n; i++) {
                List<Integer> res = new ArrayList<>();
                for (int s = i; s < j; s++) {
                    List<Integer> res1 = dp[i][s];
                    List<Integer> res2 = dp[s + 1][j];
                    for (Integer i1 : res1) {
                        for (Integer i2 : res2) {
                            res.add(caculate(i1,opsList.get(s),i2));
                        }
                    }
                }
                dp[i][j] = res;
            }
        }
        return dp[0][n-1];
    }

    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) {
            return new ArrayList<>();
        }
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> res = new ArrayList<>();
        char[] chars = input.toCharArray();
        int num = 0;
        int index = 0;
        while (index < chars.length && !isOperation(chars[index])) {
            num = num * 10 + chars[index] - '0';
            index++;
        }
        if (index == input.length()) {
            res.add(num);
            map.put(input, res);
            return res;
        }
        for (int i = 0; i < chars.length; i++) {
            if (isOperation(chars[i])) {
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i + 1));
                for (Integer i1 : res1) {
                    for (Integer i2 : res2) {
                        res.add(caculate(i1, chars[i], i2));
                    }
                }
            }
        }
        map.put(input, res);
        return res;
    }

    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}

