package Leetcode.smart;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class work0179 {
    public static void main(String[] args) {
        work0179 w = new work0179();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(w.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums)
                .boxed().map(Objects::toString)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.insert(0, e));
        String res = sb.toString();
        return res.startsWith("0") ? "0" : res;
    }

}