package Leetcode.smart;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * LeetCode1116 打印零与奇偶数
 *
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1116 {
    public static void main(String[] args) {
        ZeroEvenOdd fooBar = new ZeroEvenOdd(2);
        new Thread(() -> {
            try {
                fooBar.zero((n) -> {
                    if (n == 0) System.out.println(0);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.even(n -> {
                    if (n % 2 == 0) System.out.println(n);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.odd(n -> {
                    if (n % 2 != 0) System.out.println(n);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static class ZeroEvenOdd {
        private int n;
        private int index;
        private boolean flag = true;
        private Lock lock;
        private Condition z;
        private Condition e;

        public ZeroEvenOdd(int n) {
            this.n = n;
            lock = new ReentrantLock();
            z = lock.newCondition();
            e = lock.newCondition();
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                lock.lock();
                try {
                    while (!flag) {
                        z.await();
                    }
                    printNumber.accept(0);
                    flag = false;
                    index++;
                    e.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                lock.lock();
                try {
                    while (flag || (index & 1) != 0) {
                        e.await();
                    }
                    printNumber.accept(i);
                    flag = true;
                    z.signal();
                }finally {
                    lock.unlock();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                lock.lock();
                try {
                    while (flag || (index & 1) == 0) {
                        e.await();
                    }
                    printNumber.accept(i);
                    flag = true;
                    z.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}


