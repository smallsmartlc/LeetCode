package Leetcode.smart;


import java.util.List;
import java.util.NoSuchElementException;

/**
 * leetcode 0281 锯齿迭代器
 * lintcode 540. 左旋右旋迭代器
 */
public class work0281 {

    public static void main(String[] args) {
        work0281 w = new work0281();
        ZigzagIterator iterator = new ZigzagIterator(List.of(1, 2), List.of(3, 4, 5, 6));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static class ZigzagIterator {
        /*
         * @param v1: A 1d vector
         * @param v2: A 1d vector
         */
        private List<Integer> v1;
        private List<Integer> v2;
        private int index1 = 0;
        private int index2 = 0;
        private boolean flag;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            // do intialization if necessary
            this.v1 = v1;
            this.v2 = v2;
            if(v1.size() > 0){
                flag = true;
            }
        }

        /*
         * @return: An integer
         */
        public int next() {
            // write your code here
            if (!hasNext()) throw new NoSuchElementException();
            if (flag) {
                if (index2 < v2.size()) flag = !flag;
                return v1.get(index1++);
            } else {
                if (index1 < v1.size()) flag = !flag;
                return v2.get(index2++);
            }
        }

        /*
         * @return: True if has next
         */
        public boolean hasNext() {
            // write your code here
            if (flag) {
                return index1 < v1.size();
            } else {
                return index2 < v2.size();
            }
        }
    }
}

