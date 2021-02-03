package thread.init;

public class CreateThread {
    // 继承java.lang.Thread创建
    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                System.out.print(i + " ");
            }
        }
    }
    // 实现java.lang.Runnable接口
    public static class MyThreadRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        // 1.1 继承java.lang.Thread创建
//        MyThread t = new MyThread();
        // 1.2 实现java.lang.Runnable接口
        Thread t = new Thread(new MyThreadRunnable());
        //启动子线程
        t.start();
        /** 1.3 暂停，Java中线程的暂停是调用java.lang.Thread类的sleep方法（注意是类方法）。
         *      该方法会使当前正在执行的线程暂停指定的时间，如果线程持有锁，sleep方法结束前并不会释放该锁。
         */
//        for (int i = 0; i < 10; i++) {
//            System.out.print(i + " ");
//            try {
//                //当前main线程暂停500ms（只暂停main线程）
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                // 上述代码中，当main线程调用Thread.sleep(500)后，线程会被暂停，如果被interrupt，则会抛出InterruptedException异常。
//            }
//        }
        /**
         *  1.4 互斥Java中线程的共享互斥操作，会使用synchronized关键字。线程共享互斥的架构称为监视（monitor），而获取锁有时也称为“持有(own)监视”。
         * 每个锁在同一时刻，只能由一个线程持有。
         * 注意：synchronized方法或声明执行期间，如程序遇到任何异常或return，线程都会释放锁。
         */
        //主线程继续同时向下执行
        for (int i = 0; i < 10000; i++) {
            System.out.print(i + " ");
        }
    }
}
