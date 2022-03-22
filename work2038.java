package Leetcode.smart;

/**
 * 2038 如果相邻两个颜色均相同则删除当前颜色
 *
 * @author LuCong
 * @since 2022-3-20
 **/
public class work2038 {
    public static void main(String[] args) {
        work2038 w = new work2038();
        System.out.println(w.winnerOfGame("ABBBBBBBAAA"));
    }

    public boolean winnerOfGame(String colors) {
        char[] ch = colors.toCharArray();
        int a = 0;
        for (int i = 1; i < ch.length - 1; i++) {
            if (ch[i - 1] == ch[i] && ch[i + 1] == ch[i]) {
                if (ch[i] == 'A') a++;
                else a--;
            }
        }
        return a > 0;
    }
}


