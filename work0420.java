package Leetcode.smart;

/**
 * 0420 强密码检验器
 */

public class work0420 {
    public static void main(String[] args) {
        work0420 w = new work0420();
        System.out.println(w.strongPasswordChecker("a"));
    }


    public int strongPasswordChecker(String password) {
        char[] chars = password.toCharArray();
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (char c : chars) {
            if (Character.isLowerCase(c)) hasLower = 1;
            if (Character.isUpperCase(c)) hasUpper = 1;
            if (Character.isDigit(c)) hasDigit = 1;
        }
        int categories = hasDigit + hasLower + hasUpper;

        if (chars.length < 6) return Math.max(6 - password.length(), 3 - categories);
        else if (password.length() > 20) {
            int replace = 0, remove = chars.length - 20;
            int rm2 = 0;
            int cnt = 0;
            char cur = 0;
            for (char c : chars) {
                if (c == cur) {
                    cnt++;
                } else {
                    if (remove > 0 && cnt >= 3) {
                        if (cnt % 3 == 0) {
                            // 需要删除
                            --remove;
                            --replace;
                        } else if (cnt % 3 == 1) {
                            rm2++;
                        }
                    }
                    replace += cnt / 3;
                    cnt = 1;
                    cur = c;
                }
            }
            if (remove > 0 && cnt >= 3) {
                if (cnt % 3 == 0) {
                    --remove;
                    --replace;
                } else if (cnt % 3 == 1) {
                    ++rm2;
                }
            }
            replace += cnt / 3;
            // 使用 k % 3 = 1 的组的数量，由剩余的替换次数、组数和剩余的删除次数共同决定
            int use2 = Math.min(Math.min(replace, rm2), remove / 2);
            replace -= use2;
            remove -= use2 * 2;
            // 由于每有一次替换次数就一定有 3 个连续相同的字符（k / 3 决定），因此这里可以直接计算出使用 k % 3 = 2 的组的数量
            int use3 = Math.min(replace, remove / 3);
            replace -= use3;
            remove -= use3 * 3;
            return (chars.length - 20) + Math.max(replace, 3 - categories);
        } else {
            int replace = 0;
            char cur = 0;
            int cnt = 0;
            for (char c : chars) {
                if (c == cur) {
                    cnt++;
                } else {
                    replace += cnt / 3;// 每三个重复替换一个
                    cnt = 1;
                    cur = c;
                }
            }
            replace += cnt / 3;
            return Math.max(replace, 3 - categories);
        }

    }
}