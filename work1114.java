package Leetcode.smart;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 按序打印
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1114 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(()->{
            try {
                Thread.sleep(100);
                foo.first(()-> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                foo.second(()-> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(100);
                foo.third(()-> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    private static class Foo {
        private Lock lock;
        private Condition c1;
        private Condition c2;
        private Condition c3;
        private int flag = 1;

        public Foo() {
            lock = new ReentrantLock();
            c1 = lock.newCondition();
            c2 = lock.newCondition();
            c3 = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 1) {
                    c1.await();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                flag = 2;
                c2.signal();
            } finally {
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 2) {
                    c2.await();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                flag = 3;
                c3.signal();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                while (flag != 3) {
                    c3.await();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                flag = 1;
                c1.signal();
            } finally {
                lock.unlock();
            }
        }
    }

}


