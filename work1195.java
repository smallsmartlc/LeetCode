package Leetcode.smart;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1195 交替打印字符串
 *
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1195 {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz obj = new FizzBuzz(15);
        new Thread(() -> {
            try {
                obj.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                obj.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                obj.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                obj.number(n -> System.out.println(n));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static class FizzBuzz1 {
        private int n;

        private Semaphore s1;
        private Semaphore s2;
        private Semaphore s3;
        private Semaphore s4;

        public FizzBuzz1(int n) {
            this.n = n;
            s4 = new Semaphore(1);
            s3 = new Semaphore(0);
            s2 = new Semaphore(0);
            s1 = new Semaphore(0);
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i += 3) {
                if (i % 5 != 0) {
                    s1.acquire();
                    printFizz.run();
                    s4.release();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i += 5) {
                if (i % 3 != 0) {
                    s2.acquire();
                    printBuzz.run();
                    s4.release();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i += 15) {
                s3.acquire();
                printFizzBuzz.run();
                s4.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                s4.acquire();
                if (i % 3 == 0 && i % 5 == 0) {
                    s3.release();
                } else if (i % 3 == 0) {
                    s1.release();
                } else if (i % 5 == 0) {
                    s2.release();
                } else {
                    printNumber.accept(i);
                    s4.release();
                }
            }
        }
    }

    private static class FizzBuzz {
        private int n;
        private boolean state; // 标明是否为数字状态

        private Lock lock;

        private Condition c1;
        private Condition c2;
        private Condition c3;
        private Condition c4;

        public FizzBuzz(int n) {
            this.n = n;
            this.state = true;
            this.lock = new ReentrantLock();
            c1 = lock.newCondition();
            c2 = lock.newCondition();
            c3 = lock.newCondition();
            c4 = lock.newCondition();
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int j = 3; j <= n; j += 3) {
                if (j % 5 == 0) continue;
                lock.lock();
                try {
                    while (state) {
                        c2.await();
                    }
                    printFizz.run();
                    state = true;
                    c1.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int j = 5; j <= n; j += 5) {
                if (j % 3 == 0) continue;
                lock.lock();
                try {
                    while (state) {
                        c3.await();
                    }
                    printBuzz.run();
                    state = true;
                    c1.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int j = 15; j <= n; j += 15) {
                lock.lock();
                try {
                    while (state) {
                        c4.await();
                    }
                    printFizzBuzz.run();
                    state = true;
                    c1.signal();
                } finally {
                    lock.unlock();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int j = 1; j <= n; j++) {
                lock.lock();
                try {
                    while (!state) {
                        c1.await();
                    }
                    if (j % 3 == 0 && j % 5 == 0) {
                        c4.signal();
                        state = false;
                    } else if (j % 3 == 0) {
                        c2.signal();
                        state = false;
                    } else if (j % 5 == 0) {
                        c3.signal();
                        state = false;
                    } else {
                        printNumber.accept(j);
                        c1.signal();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}







