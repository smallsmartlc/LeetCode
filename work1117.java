package Leetcode.smart;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 1117 H2O 生成
 * @author LuCong
 * @since 2020-10-30
 **/
public class work1117 {
    public static void main(String[] args) throws InterruptedException {
        //测试用例字符串
        String test = "OOHHHH";

        //生成结果字符串
        StringBuffer result = new StringBuffer();

        //注意：创建的Runnable任务，无法启动线程，必须依托其他类或线程启动
        //创建生成氧气任务
        Runnable releaseHydrogen = () -> result.append("H");

        //创建生成氧气任务
        Runnable releaseOxygen = () -> result.append("O");

        //保存线程数组
        Thread threads[] = new Thread[test.length()];

        H2O h2o = new H2O();
        for (int i = 0; i < test.length(); ++i) {
            Thread thread = null;
            //根据获得的字符调用相应的氧气或氢气线程
            if (test.charAt(i) == 'O') {
                thread = new OGenerator(h2o, releaseOxygen);
            } else if (test.charAt(i) == 'H') {
                thread = new HGenerator(h2o, releaseHydrogen);
            }
            //开始线程
            thread.start();
            //保存到线程数组
            threads[i] = thread;
        }

        //等侍所有线程执行完
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        //输出结果串
        System.out.println(result.toString());
    }

    //氢气生成线程
    private static class HGenerator extends Thread {
        H2O h2o;
        Runnable releaseHydrogen;

        public HGenerator(H2O h2o, Runnable releaseHydrogen) {
            this.h2o = h2o;
            this.releaseHydrogen = releaseHydrogen;
        }

        @Override
        public void run() {
            h2o.hydrogen(releaseHydrogen);
        }
    }

    //氧气生成线程
    private static class OGenerator extends Thread {
        H2O h2o;
        Runnable releaseOxygen;

        public OGenerator(H2O h2o, Runnable releaseOxygen) {
            this.h2o = h2o;
            this.releaseOxygen = releaseOxygen;
        }

        @Override
        public void run() {
            h2o.oxygen(releaseOxygen);
        }
    }

    private static class H2O {
        private Semaphore s1, s2;
        private CyclicBarrier c;

        public H2O() {
            s1 = new Semaphore(2);//H线程信号量
            s2 = new Semaphore(1);//O线程信号量
            c = new CyclicBarrier(3, () -> {
                s1.release(2);
                s2.release(1);
            });
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            s1.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            s2.acquire();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}







