package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;

public class work0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        res.add(new ArrayList<>());
        res.get(0).add(1);
        if (numRows == 1) return res;
        for (int i = 1; i < numRows; i++) {
            List<Integer> thisrow = new ArrayList<>();
            List<Integer> prerow = res.get(i - 1);
            thisrow.add(1);
            for (int j = 1; j < i; j++) {
                thisrow.add(prerow.get(j - 1) + prerow.get(j));
            }
            thisrow.add(1);
            res.add(thisrow);
        }
        return res;
    }

    public static void main(String[] args) {
        work0118 w = new work0118();
        System.out.println(w.generate(2));
    }
}
