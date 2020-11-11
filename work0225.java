package Leetcode.smart;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 */
public class work0225 {

    public static void main(String[] args) {

        MyStack obj = new MyStack();
        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }

    static class MyStack {
        //双队列
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        private void swap() {
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            this.queue1 = new LinkedList<>();
            this.queue2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            swap();
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue2.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue2.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue2.isEmpty();
        }
    }

    static class MyStack1 {
        //用栈来实现栈,狗头,测下最小空间;
        LinkedList<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack1() {
            this.queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.addFirst(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
    static class MyStack2 {
        //一个队列
        Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack2() {
            this.queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            int size = queue.size();
            queue.add(x);
            for (int i = 0; i < size; i++) {
                queue.add(queue.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

