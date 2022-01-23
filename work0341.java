package Leetcode.smart;

//341. 扁平化嵌套列表迭代器

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class work0341 {
    public static void main(String[] args) {
        NestedInteger nest = new NestedInteger(
                new NestedInteger(new NestedInteger(1), new NestedInteger(1)),
                new NestedInteger(2),
                new NestedInteger(new NestedInteger(1), new NestedInteger(1)));
        NestedIterator i = new NestedIterator(nest.getList());

        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    private static class NestedIterator implements Iterator<Integer> {

        private Stack<Iterator<NestedInteger>> stack;

        private int cur;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return cur;
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()) {
                Iterator<NestedInteger> peek = stack.peek();
                if (peek.hasNext()){
                    NestedInteger next = peek.next();
                    if(next.isInteger()){
                        cur = next.getInteger();
                        return true;
                    }else{
                        stack.push(next.getList().iterator());
                    }
                }else {
                    stack.pop();
                }
            }
            return false;
        }
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
    }
}