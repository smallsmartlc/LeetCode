package Leetcode.smart;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * leetcode 251. 展开二维向量
 * lintcode 601. 摊平二维向量
 */
public class work0251 {

    public static void main(String[] args) {

        work0251 w = new work0251();
        List<Integer> list1 = List.of(1,2);
        List<Integer> list2 = List.of(3);
        List<Integer> list3 = List.of(4,5,6);
        List<List<Integer>> list = List.of(list1,list2,list3);
        Vector2D vector2D = new Vector2D(list);
        while (vector2D.hasNext()){
            System.out.println(vector2D.next());
        }
    }

    private static class Vector2D implements Iterator<Integer> {
        List<List<Integer>> list;
        private int n = 0;
        private int m = 0;

        public Vector2D(List<List<Integer>> vec2d) {
            // Initialize your data structure here
            this.list = vec2d;
        }

        @Override
        public Integer next() {
            // Write your code here
            if (!hasNext()) throw new NoSuchElementException();
            return list.get(n).get(m++);
        }

        @Override
        public boolean hasNext() {
            // Write your code here
            while (n < list.size() && m == list.get(n).size()) {
                m = 0;
                n++;
            }
            return n < list.size();
        }

        @Override
        public void remove() {

        }
    }
}

