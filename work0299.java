package Leetcode.smart;

/**
 * LeetCode0299 猜数字游戏
 */
public class work0299 {

    public static void main(String[] args) {

        work0299 w = new work0299();
        System.out.println(w.getHint("1123",  "0111"));
    }

    public String getHint(String secret, String guess) {
        int len = Math.min(secret.length(), guess.length());
        char[] secrets = secret.toCharArray();
        char[] guesses = guess.toCharArray();
        int aNum = 0;
        int bNum = 0;
        int[] map = new int[10];
        for (int i = 0; i < secrets.length; i++) {
            map[secrets[i] - '0']++;
        }
        for (int i = 0; i < len; i++) {
            if (secrets[i] == guesses[i]){
                aNum++;
                map[secrets[i] - '0']--;
            }
        }
        for (int i = 0; i < len; i++) {
            if (map[guesses[i] - '0'] > 0) {
                bNum++;
                map[guesses[i] - '0']--;
            }
        }
        return aNum + "A" + bNum + "B";
    }

}

