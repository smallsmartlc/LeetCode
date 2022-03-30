package Leetcode.smart;

/**
 * 2024 考试的最大困扰度
 *
 * @author LuCong
 * @since 2022-3-29
 **/
public class work2024 {
    public static void main(String[] args) {
        work2024 w = new work2024();
        System.out.println(w.maxConsecutiveAnswers("TTFF", 2));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        return Math.max(getAnswer(chars, k, 'T'), getAnswer(chars, k, 'F'));
    }

    private int getAnswer(char[] chars, int k, char c) {
        int i = 0, j = 0, sum = 0;
        int res = 0;
        while (j < chars.length) {
            if (chars[j] == c) sum++;
            while (sum > k) {
                if (chars[i] == c) sum--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}


