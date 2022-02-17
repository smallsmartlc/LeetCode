package Leetcode.smart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * LeetCode0385 迷你语法分析器
 */
public class work0385 {
    public static void main(String[] args) {
        work0385 w = new work0385();
        NestedInteger deserialize = w.deserialize("[123,[456,[789]]]");
        System.out.println(deserialize);
    }

    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        int i = 0;
        int flag = 1; // 负数
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            else if (c == '[') stack.push(new NestedInteger());
            else if (c == ',') {
                if (i != 0) {
                    stack.peek().getList().add(new NestedInteger(i));
                    i = 0;
                    flag = 1;
                }
            } else if (c == ']') {
                NestedInteger pop = stack.pop();
                if (i != 0) {
                    pop.getList().add(new NestedInteger(i));
                    i = 0;
                    flag = 1;
                }
                if (stack.empty()) return pop;
                stack.peek().getList().add(pop);
            } else if (c == '-') {
                flag = -1;
            } else { // 数字
                if (i == 0 && c - '0' == 0) { // 0的情况直接加入,遇到,]就不加0了
                    stack.peek().getList().add(new NestedInteger(0));
                    continue;
                }
                i = i * 10 + flag * (c - '0');
            }
        }
        return stack.pop();
    }

    private static class NestedInteger {
        private List<NestedInteger> list;
        private Integer integer;

        public NestedInteger(int i) {
            this.integer = i;
        }

        public NestedInteger(NestedInteger... nums) {
            list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
        }

        public boolean isInteger() {
            return list == null;
        }

        public Integer getInteger() {
            return this.integer;
        }

        public List<NestedInteger> getList() {
            return this.list;
        }

        @Override
        public String toString() {
            if (this.isInteger()) return "[" + this.getInteger() + "]";
            StringBuilder res = new StringBuilder();
            res.append('[');
            for (NestedInteger nestedInteger : this.getList()) {
                res.append(nestedInteger.toString());
                res.append(',');
            }
            res.append(']');
            return res.toString();
        }
    }
}