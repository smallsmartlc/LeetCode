package Leetcode.smart;

import java.util.Iterator;

/**
 * 0284. 顶端迭代器
 */
public class work0284 {
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    private static class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;

        private Integer cache;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if(iterator.hasNext()){
                this.cache = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer temp = this.cache;
            this.cache = iterator.hasNext()?iterator.next():null;
            return temp;
        }

        @Override
        public boolean hasNext() {
            return cache != null;
        }
    }

}

